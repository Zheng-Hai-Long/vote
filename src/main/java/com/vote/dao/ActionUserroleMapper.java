package com.vote.dao;

import com.vote.pojo.ActionUserrole;

public interface ActionUserroleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ActionUserrole record);

    int insertSelective(ActionUserrole record);

    ActionUserrole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ActionUserrole record);

    int updateByPrimaryKey(ActionUserrole record);

    ActionUserrole queryUserRole(ActionUserrole actionUserRole);
    //用户角色管理查询
    int selectUserRole(ActionUserrole u);
    //删除
    void userRoleDelete(int id);
    //新增
    void userRoleAdd(ActionUserrole u);
    //删除用户角色关联
    void userDeleteId(int id);
}