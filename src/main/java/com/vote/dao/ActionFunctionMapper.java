package com.vote.dao;

import com.vote.pojo.ActionFunction;
import com.vote.pojo.ActionUser;
import com.vote.pojo.vo.ActionFunctionVO;

import java.util.List;

public interface ActionFunctionMapper {
    /**functionDelete*/
    int deleteByPrimaryKey(Integer id);

    int insert(ActionFunction record);

    /**functionAdd*/
    int insertSelective(ActionFunction record);

    ActionFunction selectByPrimaryKey(Integer id);
    /**functionEditOk*/
    int updateByPrimaryKeySelective(ActionFunction record);

    int updateByPrimaryKey(ActionFunction record);

    /**菜单查询*/
    List<ActionFunction> queryFunctionList(ActionFunctionVO vo);

    /**获取父类*/
    ActionFunction functionEditParentFun(int id);

    /**修改*/
    ActionFunction functionEdit(int id);

    /**分配权限__查找全部权限*/
    List<ActionFunction> selectRoleFunList();

    /**用户登录初始化菜单权限*/
    List<ActionFunction> indexUserFunParam(ActionUser user);

    /**初始化菜单按钮权限*/
    List<ActionFunction> functionListTo(int id);

}