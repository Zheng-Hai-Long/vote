package com.vote.service;

import com.vote.pojo.ActionRolefun;
/**
 *  角色权限服务层 
 * @author admin
 */
public interface ActionRoleFunService {
	
	/**
	 * 角色权限信息查询
	 * @return 角色权限总条数
	 */
	public int selectRoleFun(ActionRolefun u);
	
	/**
	 * 删除权限关联信息
	 * @param id
	 */
	public void funDelete(int id);
	
	/**
	 * 删除角色权限关联信息
	 * @param id
	 */
	public void roleFunDelete(int id);
	
	/**
	 * 新增角色权限关联信息
	 * @param u
	 */
	public void roleFunAdd(ActionRolefun u);
}
