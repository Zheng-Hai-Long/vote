package com.vote.dao;

import com.vote.pojo.ActionRole;
import com.vote.pojo.ActionRolefun;
import com.vote.pojo.vo.ActionRoleVO;

import java.util.List;

public interface ActionRolefunMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ActionRolefun record);

    int insertSelective(ActionRolefun record);

    ActionRolefun selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ActionRolefun record);

    int updateByPrimaryKey(ActionRolefun record);

    //角色功能管理查询
    int selectRoleFun(ActionRolefun u);
    //删除角色功能
    void roleFunDelete(int id);
    //新增角色功能
    void roleFunAdd(ActionRolefun u);
    //删除功能
    void funDelete(int id);
}