package com.vote.service;

import java.util.List;
import com.vote.pojo.ActionRole;
import com.vote.pojo.vo.ActionRoleVO;
/**
 *  角色服务层 
 * @author admin
 */
public interface ActionRoleService {
	
	/**
	 * 角色列表查询
	 * @return 角色列表信息
	 */
    public List<ActionRole> queryRoleList(ActionRoleVO vo);
	
	/**
	 * 角色列表总数查询
	 * @return
	 */
	//public int queryRoleListCount(Page<ActionRole> page);
	
	/**
	 * 角色新增
	 * @param u
	 */
	public void roleAdd(ActionRole u);
	
	/**
	 * 角色信息修改
	 * @param id
	 * @return
	 */
	public ActionRole roleEdit(int id);
	
	/**
	 * 角色修改信息保存
	 * @param u
	 */
	public void roleEditOk(ActionRole u);
	
	/**
	 * 角色信息删除
	 * @param id
	 */
	public void roleDelete(int id);
	
	/**
	 * 分配角色--查询全部角色信息
	 * @param isAdmin 0：超管群组，1：普通群组
	 * @return
	 */
	public List<ActionRole> selectRoleList(int isAdmin);
}
