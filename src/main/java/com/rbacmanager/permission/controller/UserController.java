package com.rbacmanager.permission.controller;

import com.rbacmanager.permission.mapper.RealUserMapper;
import com.rbacmanager.permission.mapper.UserRoleMapper;
import com.rbacmanager.permission.pojo.RealUser;
import com.rbacmanager.permission.pojo.Role;
import com.rbacmanager.permission.pojo.User;
import com.rbacmanager.permission.service.RoleService;
import com.rbacmanager.permission.service.UserService;
import com.rbacmanager.permission.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @Autowired
    RealUserMapper realUserMapper;
    @Autowired
    UserRoleMapper userRoleMapper;

    @GetMapping("")
    public String listUser(Model model) {
        List<User> users = userService.listUser();
        model.addAttribute("users", users);
        return "listUser";
    }

    @GetMapping("/{user_id}")
    public String editUserRolePage(@PathVariable(value = "user_id") Integer id, Model model) {
        User user = userService.selectByPrimaryKey(id);
        List<Map<String, Object>> userRoles = userRoleMapper.selectUserRoleByUserPrimaryKey(id);
        List<Role> roles = roleService.listRoles();
        model.addAttribute("user", user);
        model.addAttribute("roles", roles);
        model.addAttribute("userRoles", userRoles);
        return "editUserRole";
    }

    @DeleteMapping("/{user_id}")
    public String deleteUser(@PathVariable(value = "user_id") Integer id) {
        userService.deleteByPrimaryKey(id);
        return "redirect:/users";
    }

    @PostMapping("")
    public String addUser(String username) {
        RealUser realUser = realUserMapper.selectByUserName(username);
        User user = new User();
        if (realUser != null) {
            if (userService.selectByUid(realUser.getId()) == null) {
                user.setUid(realUser.getId());
                user.setUsername(realUser.getUsername());
                user.setPassword(realUser.getPassword());
                userService.addUser(user);
            }
        }
        return "redirect:/users";
    }

    @GetMapping("/checktoken")
    public String checkToken() {
        String token;
        List<User> users = userService.listUser();
        for (User user: users) {
            token = user.getToken();
            if (token != null && !token.equals("")) {
                if (!TokenUtil.checkTokenExpires(token)) {
                    userService.updateAvailability(user.getUser_id());
                }
            }
        }
        return "redirect:/users";
    }
}
