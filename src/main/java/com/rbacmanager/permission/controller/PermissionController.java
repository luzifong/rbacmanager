package com.rbacmanager.permission.controller;

import com.rbacmanager.permission.mapper.RolePermissionMapper;
import com.rbacmanager.permission.pojo.Permission;
import com.rbacmanager.permission.pojo.RolePermission;
import com.rbacmanager.permission.service.PermissionService;
import com.rbacmanager.permission.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/permissions")
public class PermissionController {
    @Autowired
    RoleService roleService;
    @Autowired
    PermissionService permissionService;
    @Autowired
    RolePermissionMapper rolePermissionMapper;

    @GetMapping("")
    public String editRolePermission(@RequestParam(value = "role_id")String role_id, @RequestParam(value = "permission_id")String... ids) {
        Boolean flag = true;
        Integer intRoleId = Integer.parseInt(role_id);
        if (ids.length > 0) {
            for (String id: ids) {
                Integer intId = Integer.parseInt(id.substring(1, id.length()));
                if (intId != 0) {
                    if (flag){
                        rolePermissionMapper.deleteRolePermissionByRolePrimaryKey(intRoleId);
                        flag = false;
                    }
                    RolePermission rolePermission = new RolePermission();
                    rolePermission.setRole_id(intRoleId);
                    rolePermission.setRole_name(roleService.selectRoleNameByRoleId(intRoleId));
                    rolePermission.setPermission_id(intId);
                    rolePermission.setPermission_name(permissionService.selectPermissionNameByPermissionId(intId));
                    rolePermissionMapper.addRolePermission(rolePermission);
                }
                else rolePermissionMapper.deleteRolePermissionByRolePrimaryKey(intRoleId);
            }
        }
        return "redirect:/roles/" + role_id;
    }
    @GetMapping("/list")
    public String listPermission(Model model) {
        List<Permission> permissions = permissionService.listPermissions();
        model.addAttribute("permissions", permissions);
        return "listPermission";
    }

    @DeleteMapping("/{permission_id}")
    public String deletePermission(@PathVariable(value = "permission_id") Integer id) {
        permissionService.deleteByPrimaryKey(id);
        return "redirect:/permissions/list";
    }
}
