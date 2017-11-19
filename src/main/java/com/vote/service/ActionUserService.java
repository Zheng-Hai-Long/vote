package com.vote.service;

import java.util.List;
import com.vote.pojo.ActionUser;
import com.vote.pojo.vo.ActionUserVO;


/**
 *  用户登录服务层
 * @author admin
 */
public interface ActionUserService {
	
	/**
	 * 用户登录
	 * @param userName 登录名
	 * @param passWord 密码
	 * @return
	 */
	public ActionUser queryUser(String userName, String passWord);
	
	/**
	 * 用户列表查询
	 * @return 用户列表信息
	 */
    public List<ActionUser> queryUserList(ActionUserVO vo);
	
	/**
	 * 用户列表总数查询
	 * @return 用户列表总条数
	 */
	//public int queryUserListCount(Page<ActionUser> page);
	
	/**
	 * 用户信息添加
	 * @param u
	 */
	public void userAdd(ActionUser u);
	
	/**
	 * 用户信息修改
	 * @param id
	 * @return ActionUser
	 */
	public ActionUser userEdit(int id);
	
	/**
	 * 用户信息修改保存
	 * @param u
	 */
	public void userEditOk(ActionUser u);
	
	/**
	 * 用户信息删除
	 * @param id
	 */
	public void userDelete(int id);
	
	/**
	 * 分配用户查询
	 * @return
	 */
	public List<ActionUser> selectRoleUserList(int createname);
	
	/**
	 * 用户初始化密码
	 * @param u
	 */
	public void userInit(ActionUser u);
	
	/**
	 * 用户修改状态
	 * @param u
	 */
	public void userStatus(ActionUser u);
	/**
	 * 通过id查询
	 * @param id
	 */
	public ActionUser queryById(int id);

}
