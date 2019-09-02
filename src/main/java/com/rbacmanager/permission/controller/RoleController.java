package com.rbacmanager.permission.controller;

import com.rbacmanager.permission.mapper.RolePermissionMapper;
import com.rbacmanager.permission.mapper.UserRoleMapper;
import com.rbacmanager.permission.pojo.Permission;
import com.rbacmanager.permission.pojo.Role;
import com.rbacmanager.permission.pojo.User;
import com.rbacmanager.permission.pojo.UserRole;
import com.rbacmanager.permission.service.PermissionService;
import com.rbacmanager.permission.service.RoleService;
import com.rbacmanager.permission.service.UserService;
import com.rbacmanager.permission.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    RoleService roleService;
    @Autowired
    UserService userService;
    @Autowired
    PermissionService permissionService;
    @Autowired
    UserRoleMapper userRoleMapper;
    @Autowired
    RolePermissionMapper rolePermissionMapper;

    @GetMapping("")
    public String editUserRole(@RequestParam(value = "user_id") Integer user_id,
                               @RequestParam(value = "expires") Integer expiresDays,
                               @RequestParam(value = "role_id")String... ids) {
        java.util.Date date = new java.util.Date();
        Boolean flag = true;
        if (ids.length > 0) {
            for (String id: ids) {
                Integer intId = Integer.parseInt(id.substring(1, id.length()));
                if (intId != 0) {
                    if (flag) {
                        userRoleMapper.deleteUserRoleByUserPrimaryKey(user_id);
                        userService.cleanTokenInfoByUserId(user_id, new Date(date.getTime()));
                        flag = false;
                    }
                    UserRole userRole = new UserRole();
                    userRole.setUser_id(user_id);
                    userRole.setUsername(userService.selectUsernameByUserId(user_id));
                    userRole.setRole_id(intId);
                    userRole.setRole_name(roleService.selectRoleNameByRoleId(intId));
                    userRoleMapper.addUserRole(userRole);
                }
                else {
                    userRoleMapper.deleteUserRoleByUserPrimaryKey(user_id);
                    userService.cleanTokenInfoByUserId(user_id, new Date(date.getTime()));
                }
            }
        }
        if (expiresDays != null && flag == false) {
            String token = TokenUtil.generateToken(userService.selectByPrimaryKey(user_id), expiresDays);
            userService.updateTokenInfoByUserId(user_id, token, new Date(date.getTime()));
        }
        return "redirect:/users/" + user_id;
    }

    @RequestMapping("/list")
    public String listRole(Model model) {
        List<Role> roles = roleService.listRoles();
        model.addAttribute("roles", roles);
        return "listRole";
    }

    @DeleteMapping("/{role_id}")
    public String deleteRole(@PathVariable(value = "role_id") Integer id) {
        roleService.deleteByPrimaryKey(id);
        return "redirect:/roles/list";
    }

    @GetMapping("/{role_id}")
    public String editRolePermission(@PathVariable(value = "role_id") Integer id ,Model model) {
        Role role = roleService.selectByPrimaryKey(id);
        List<Map<String, Object>> rolePermissions = rolePermissionMapper.selectRolePermissionByRolePrimaryKey(id);
        List<Permission> permissions = permissionService.listPermissions();
        model.addAttribute("role", role);
        model.addAttribute("rolePermissions", rolePermissions);
        model.addAttribute("permissions", permissions);
        return "editRolePermission";
    }
}
