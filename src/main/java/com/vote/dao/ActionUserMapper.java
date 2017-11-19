package com.vote.dao;

import com.vote.pojo.ActionUser;
import com.vote.pojo.vo.ActionUserVO;

import java.util.List;

public interface ActionUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ActionUser record);

    int insertSelective(ActionUser record);

    ActionUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ActionUser record);

    int updateByPrimaryKey(ActionUser record);

    //用户登录查询
    ActionUser queryUser(ActionUser u);
    //用户列表查询
    List<ActionUser> queryUserList(ActionUserVO vo);
    //添加
    void userAdd(ActionUser u);
    //修改
    ActionUser userEdit(int id);
    //修改保存
    void userEditOk(ActionUser u);
    //删除
    void userDelete(int id);

    //分配用户__查找全部用户
    List<ActionUser> selectRoleUserList(int createname);
    //用户初始化密码
    void userInit(ActionUser u);
    //用户修改状态
    void userStatus(ActionUser u);
    //通过id查询
    ActionUser queryById(int id);
}