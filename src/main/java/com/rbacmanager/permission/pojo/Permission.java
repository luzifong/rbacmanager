package com.rbacmanager.permission.pojo;

public class Permission {
    private Integer permission_id;
    private String permission_name;
    private String permission_info;

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

    public String getPermission_info() {
        return permission_info;
    }

    public void setPermission_info(String permission_info) {
        this.permission_info = permission_info;
    }
}
