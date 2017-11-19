package com.vote.pojo;

import java.util.Date;

public class ActionRole {
    private Integer id;

    private String roleName;

    private Integer isAdmin;

    private Date createTime;

    private String description;

    public ActionRole(Integer id, String roleName, Integer isAdmin, Date createTime, String description) {
        this.id = id;
        this.roleName = roleName;
        this.isAdmin = isAdmin;
        this.createTime = createTime;
        this.description = description;
    }

    public ActionRole() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public Integer getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}