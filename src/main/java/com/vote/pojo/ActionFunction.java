package com.vote.pojo;

import java.util.List;

public class ActionFunction {
    private Integer id;

    private String funName;

    private String action;

    private Integer displayMode;

    private Integer parentFun;

    private String code;

    private String rel;

    private String target;

    private List<ActionFunction> actionFunctionlist;

    public ActionFunction(Integer id, String funName, String action, Integer displayMode, Integer parentFun, String code, String rel, String target, List<ActionFunction> actionFunctionlist) {
        this.id = id;
        this.funName = funName;
        this.action = action;
        this.displayMode = displayMode;
        this.parentFun = parentFun;
        this.code = code;
        this.rel = rel;
        this.target = target;
        this.actionFunctionlist =  actionFunctionlist;
    }

    public ActionFunction() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFunName() {
        return funName;
    }

    public void setFunName(String funName) {
        this.funName = funName == null ? null : funName.trim();
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action == null ? null : action.trim();
    }

    public Integer getDisplayMode() {
        return displayMode;
    }

    public void setDisplayMode(Integer displayMode) {
        this.displayMode = displayMode;
    }

    public Integer getParentFun() {
        return parentFun;
    }

    public void setParentFun(Integer parentFun) {
        this.parentFun = parentFun;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel == null ? null : rel.trim();
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target == null ? null : target.trim();
    }

    public List<ActionFunction> getActionFunctionlist() {
        return actionFunctionlist;
    }

    public void setActionFunctionlist(List<ActionFunction> actionFunctionlist) {
        this.actionFunctionlist = actionFunctionlist;
    }
}