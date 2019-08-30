package com.rbacmanager.permission.pojo;


import java.sql.Date;

public class UserToken {
    private Integer id;
    private Integer uid;
    private String token;
    private Date updateDate;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "UserToken{" +
                "id=" + id +
                ", uid=" + uid +
                ", token='" + token + '\'' +
                ", updateDate='" + updateDate + '\'' +
                '}';
    }
}
