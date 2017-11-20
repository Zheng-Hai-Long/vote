package com.vote.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vote.dao.ActionUserroleMapper;
import com.vote.pojo.ActionUserrole;
import com.vote.service.ActionUserRoleService;

/**
 *  用户登录服务层 service
 * @author admin
 */
@Service
public class ActionUserRoleServiceImpl implements ActionUserRoleService{
	
	@Autowired
	private ActionUserroleMapper actionUserroleMapper;
	
    public ActionUserrole queryUserRole(ActionUserrole actionUserRole)
    {
        return actionUserroleMapper.queryUserRole(actionUserRole);
    }
	/**
	 * 用户角色信息查询
	 * @return 用户角色总条数
	 */
	public int selectUserRole(ActionUserrole u){
		return actionUserroleMapper.selectUserRole(u);
	}
	
	/**
	 * 删除用户角色关联信息
	 * @param id
	 */
	public void userRoleDelete(int id){
		actionUserroleMapper.userRoleDelete(id);
	}
	
	/**
	 * 新增用户角色关联信息
	 * @param u
	 */
	public void userRoleAdd(ActionUserrole u){
		actionUserroleMapper.userRoleAdd(u);
	}
	
	/**
	 * 删除用户角色关联
	 * @param id
	 */
	public void userDeleteId(int id){
		actionUserroleMapper.userDeleteId(id);
	}
}
