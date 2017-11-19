package com.vote.dao;

import com.vote.pojo.ActionRole;
import com.vote.pojo.vo.ActionRoleVO;

import java.util.List;

public interface ActionRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ActionRole record);

    int insertSelective(ActionRole record);

    ActionRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ActionRole record);

    int updateByPrimaryKey(ActionRole record);

    //查询角色列表信息
    List<ActionRole> queryRoleList(ActionRoleVO vo);

    //添加
    void roleAdd(ActionRole u);
    //修改
    ActionRole roleEdit(int id);
    //修改保存
    void roleEditOk(ActionRole u);
    //删除
    void roleDelete(int id);
    //分配角色--查询全部角色信息
    List<ActionRole> selectRoleList(int isAdmin);
}