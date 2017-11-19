package com.vote.pojo;

import java.util.Date;

public class ActionUser {
    private Integer id;

    private String userName;

    private String password;

    private String department;

    private String realName;

    private Integer sex;

    private String mobile;

    private Integer status;

    private Integer createName;

    private Date createTime;

    public ActionUser(Integer id, String userName, String password, String department, String realName, Integer sex, String mobile, Integer status, Integer createName, Date createTime) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.department = department;
        this.realName = realName;
        this.sex = sex;
        this.mobile = mobile;
        this.status = status;
        this.createName = createName;
        this.createTime = createTime;
    }

    public ActionUser() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCreateName() {
        return createName;
    }

    public void setCreateName(Integer createName) {
        this.createName = createName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}