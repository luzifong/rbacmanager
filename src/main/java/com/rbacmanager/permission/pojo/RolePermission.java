package com.rbacmanager.permission.pojo;

public class RolePermission {
    private Integer id;
    private Integer role_id;
    private String role_name;
    private Integer permission_id;
    private String permission_name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public Integer getPermission_id() {
        return permission_id;
    }

    public void setPermission_id(Integer permission_id) {
        this.permission_id = permission_id;
    }

    public String getPermission_name() {
        return permission_name;
    }

    public void setPermission_name(String permission_name) {
        this.permission_name = permission_name;
    }

    @Override
    public String toString() {
        return "RolePermission{" +
                "id=" + id +
                ", role_id=" + role_id +
                ", role_name='" + role_name + '\'' +
                ", permission_id=" + permission_id +
                ", permission_name='" + permission_name + '\'' +
                '}';
    }
}
