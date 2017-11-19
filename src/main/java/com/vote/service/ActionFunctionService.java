package com.vote.service;

import java.util.List;
import com.vote.pojo.ActionFunction;
import com.vote.pojo.ActionUser;
import com.vote.pojo.vo.ActionFunctionVO;

public interface ActionFunctionService {
	
	
	/**
	 *  用户登录初始化菜单权限
	 * @return
	 */
	public List<ActionFunction> indexList(ActionUser user);
	
	/**
	 * 菜单列表查询
	 * @return 菜单列表信息
	 */
    public List<ActionFunction> queryFunctionList(ActionFunctionVO vo);

	/**
	 * 菜单新增
	 * @param u
	 */
	public void functionAdd(ActionFunction u);
	
	/**
	 * 获取单个权限信息父类
	 * @param id
	 * @return
	 */
	public ActionFunction functionEditParentFun(int id);
	
	/**
	 * 菜单信息修改
	 * @param id
	 * @return
	 */
	public ActionFunction functionEdit(int id);
	
	/**
	 * 修改信息保存
	 * @param u
	 */
	//public void functionEditOk(ActionFunction u);
	
	/**
	 * 菜单信息删除
	 * @param id
	 */
	public void functionDelete(int id);
	/**
	 * 分配权限__查找全部权限
	 * @return
	 */
	public List<ActionFunction> selectRoleFunList();
	
	/**
	 * 初始化菜单按钮权限
	 * @return
	 */
	public List<ActionFunction> functionUserList(ActionUser user);

}
