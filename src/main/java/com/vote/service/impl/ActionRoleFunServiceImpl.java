package com.vote.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vote.dao.ActionRolefunMapper;
import com.vote.pojo.ActionRolefun;
import com.vote.service.ActionRoleFunService;
/**
 *  角色权限服务层 service
 * @author admin
 */
@Service
public class ActionRoleFunServiceImpl implements ActionRoleFunService{
	
	@Autowired
	private ActionRolefunMapper actionRolefunMapper;
	
	/**
	 * 角色权限信息查询
	 * @return 角色权限总条数
	 */
	/*public int selectRoleFun(ActionRolefun u){
		return actionRolefunMapper.selectRoleFun(u);
	}*/
	
	/**
	 * 删除权限关联信息
	 * @param id
	 */
	public void funDelete(int id){
		actionRolefunMapper.funDelete(id);
	}
	
	/**
	 * 删除角色权限关联信息
	 * @param id
	 */
	public void roleFunDelete(int id){
		actionRolefunMapper.roleFunDelete(id);
	}
	
	/**
	 * 新增角色权限关联信息
	 * @param u
	 */
	public void roleFunAdd(ActionRolefun u){
		actionRolefunMapper.roleFunAdd(u);
	}
}
