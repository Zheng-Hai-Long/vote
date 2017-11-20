package com.vote.service;

import com.vote.pojo.ActionUserrole;

/**
 *  用户登录服务层 
 * @author admin
 */
public interface ActionUserRoleService {
	
    public ActionUserrole queryUserRole(ActionUserrole actionUserRole);
	/**
	 * 用户角色信息查询
	 * @return 用户角色总条数
	 */
	public int selectUserRole(ActionUserrole u);
	
	/**
	 * 删除用户角色关联信息
	 * @param id
	 */
	public void userRoleDelete(int id);
	
	/**
	 * 新增用户角色关联信息
	 * @param u
	 */
	public void userRoleAdd(ActionUserrole u);
	
	/**
	 * 删除用户角色关联
	 * @param id
	 */
	public void userDeleteId(int id);
}
