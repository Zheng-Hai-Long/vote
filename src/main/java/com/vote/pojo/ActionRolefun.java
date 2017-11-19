package com.vote.pojo;

public class ActionRolefun {
    private Integer id;

    private Integer roleId;

    private Integer funId;

    public ActionRolefun(Integer id, Integer roleId, Integer funId) {
        this.id = id;
        this.roleId = roleId;
        this.funId = funId;
    }

    public ActionRolefun() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getFunId() {
        return funId;
    }

    public void setFunId(Integer funId) {
        this.funId = funId;
    }
}