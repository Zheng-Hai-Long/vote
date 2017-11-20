package com.vote.controller.manage.system;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.vote.pojo.ActionRole;
import com.vote.pojo.ActionUser;
import com.vote.pojo.ActionUserrole;
import com.vote.pojo.vo.ActionUserVO;
import com.vote.service.ActionRoleService;
import com.vote.service.ActionUserRoleService;
import com.vote.service.ActionUserService;
import com.vote.utils.ActionUtil;
import com.vote.utils.JsonUtil;
import com.vote.utils.MD5;
import com.vote.controller.manage.BaseController;

/**
 *  用户表  action
 * @author admin
 */
@Controller
public class ActionUserController extends BaseController{
	
	@Autowired
	private ActionUserService actionUserService;
	@Autowired
	private ActionUserRoleService actionUserRoleService;
	@Autowired
	private ActionRoleService actionRoleService;
	
	//返回用户列表页面
    private static String actionUserList = "admin/actionUser/actionUserList";
	
    private static String actionUserAdd = "admin/actionUser/actionUserAdd";
	
    private static String actionUserEdit = "admin/actionUser/actionUserEdit";
    
    private static String actionUserDetail = "admin/actionUser/actionUserDetail";
	
	//角色用户关联页面
    private static String actionUserRole = "admin/actionUser/actionUserRole";
	
    private static String ACTION_USER_LIST = "system/action_uesr_list";
    
    @RequestMapping(value = "/actionUser", method = RequestMethod.GET)
    // //@ActionLog(content = "登录")
    public String actionUser(HttpServletRequest req, HttpServletResponse resp, ModelMap model)
    {
        return ACTION_USER_LIST;
    }

	/**
	 *  用户列表信息查询  post
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/action/actionUserList", method = RequestMethod.POST)
    //@ActionLog(content = "查询用户列表")
    public String actionUserList(ActionUserVO vo,
			ModelMap model){
		//调用sql查询方法
        List<ActionUser> userList = actionUserService.queryUserList(vo);
        PageInfo<ActionUser> page = new PageInfo<ActionUser>(userList);
		model.put("page", page);
        model.put("userList", userList);
        model.put("actionUser", vo);
        saveLogDetail(null);
		return actionUserList;
		
	}
	
	/**
	 *  用户列表信息查询  get
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/action/actionUserList", method = RequestMethod.GET)
    public String actionUserListget(ActionUserVO vo,
			ModelMap model){
        return actionUserList(vo, model);
	}
	
	/**
	 *  添加用户 get
	 * @param req
	 * @param resp
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/action/actionUserAdd", method = RequestMethod.GET)
	public String actionUserAddget(HttpServletRequest req, HttpServletResponse resp,
			ModelMap model){
		return actionUserAdd;
	}
	/**
	 *  添加用户 post
	 * @param req
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/action/actionUserAdd", method = RequestMethod.POST)
	@ResponseBody
    //@ActionLog(content = "添加用户")
    public String actionUserAddpost(ActionUser actionUser, HttpServletRequest req,
			ModelMap model) {
        ActionUser acionUserSession = super.getActionUser(req);
		StringBuffer sb = new StringBuffer();
        String password = actionUser.getPassword();
        String pwd = MD5.encodeString(actionUser.getUserName().trim() + password);
        actionUser.setPassword(pwd);
        if (acionUserSession != null)
        {
            actionUser.setCreateName(acionUserSession.getId());
        }
        else
        {
            actionUser.setCreateName(1);
        }
        actionUser.setCreateTime(new Date());
        ActionUser users = actionUserService.queryUser(actionUser.getUserName(), pwd);
		if(users != null){
			sb.append("用户信息已存在: ").append(users.toString());
            saveLogDetail(sb.toString());
            return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("300", "this adminUser is existed", "", "", "", ""));
		}
        saveLogDetail(sb.toString());
        actionUserService.userAdd(actionUser);
        sb.append("用户信息添加成功 ：").append(actionUser.toString());
        return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", "add success", "actionUserList", "", "closeCurrent", ""));
	}
	
	    /**
     *  跳转修改页面
     * @param req
     * @param model
     * @return
     */
    @RequestMapping(value = "/action/{id}/actionUserDetail")
    public String actionUserDetail(@PathVariable("id")Integer id, HttpServletRequest req, ModelMap model)
    {
        if (id != null)
        {
            ActionUser user = actionUserService.userEdit(id);
            model.put("actionUser", user);
        }
        return actionUserDetail;
        
    }
    
    /**
     *  跳转修改页面
     * @param req
     * @param model
     * @return
     */
    @RequestMapping(value = "/action/{id}/actionUserEditGET")
    public String actionUserEditGET(@PathVariable("id")Integer id, HttpServletRequest req,
			ModelMap model) {
        if (id != null)
        {
            ActionUser user = actionUserService.userEdit(id);
            model.put("actionUser", user);
        }
        return actionUserEdit;
		
	}
	
	/**
	 * 用户信息修改保存
	 * @param model
	 * @return
	 */
    @RequestMapping(value = "/action/actionUserEdit")
	@ResponseBody
    //@ActionLog(content = "修改用户")
    public String actionUserEditPost(ActionUser actionUser,
			ModelMap model){
		StringBuffer sb = new StringBuffer();
		ActionUser user = actionUserService.userEdit(actionUser.getId());
        actionUser.setCreateName(user.getCreateName());
        actionUser.setCreateTime(user.getCreateTime());
        actionUser.setDepartment(user.getDepartment());
        actionUser.setPassword(user.getPassword());
        actionUser.setStatus(user.getStatus());

        sb.append("修改前：").append(user.toString());
        sb.append("\n修改后：").append(actionUser.toString());
        saveLogDetail(sb.toString());
        actionUserService.userEditOk(actionUser);
		return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", "edit success", "actionUserList", "", "closeCurrent", ""));
		
	}
	
	/**
	 * 用户信息删除
	 * @param req
	 * @param resp
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/action/actionUserDelete", method = RequestMethod.POST)
	@ResponseBody
    //@ActionLog(content = "删除用户")
    public String actionUserDeletePost(HttpServletRequest req, HttpServletResponse resp,
			ModelMap model){
		String id = req.getParameter("id");
		ActionUser user = actionUserService.userEdit(Integer.parseInt(id));
		
		if(user.getCreateName() == 0){
            return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("300", "this admin is superadmin,can`t delete", "", "", "", ""));
		}
        saveLogDetail("删除用户：" + user.toString());
		//删除用户信息
		actionUserService.userDelete(Integer.parseInt(id));
		//删除用户角色关联信息
		actionUserRoleService.userDeleteId(Integer.parseInt(id));
        return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", "delete success", "actionUserList", "", "forward", "action/actionUserList"));
	}
	
	/**
	 * 用户信息 初始化密码
	 * @param req
	 * @param resp
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/action/actionUserInit", method = RequestMethod.POST)
	@ResponseBody
    //@ActionLog(content = "初始化密码")
    public String actionUserInitPost(HttpServletRequest req, HttpServletResponse resp,
			ModelMap model){
		String id = req.getParameter("id");
		ActionUser user = actionUserService.userEdit(Integer.parseInt(id));
		if(user.getCreateName() == 0){
            return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("300", "this admin is superadmin,can`t reset password!", "", "", "", ""));
		}
        String password = MD5.encodeString(user.getUserName().trim() + "123456");
		user.setPassword(password);
        saveLogDetail("用户初始化密码：" + user.toString());
		actionUserService.userInit(user);
        return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200","reset password success","actionUserList","","",""));
	}
	
	/**
	 * 用户信息 修改状态
	 * @param req
	 * @param resp
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/action/actionUserStats", method = RequestMethod.POST)
	@ResponseBody
    //@ActionLog(content = "修改用户状态")
    public String actionUserStats(HttpServletRequest req, HttpServletResponse resp,
			ModelMap model){
		String id = req.getParameter("id");
		ActionUser user = actionUserService.userEdit(Integer.parseInt(id));
		if(user.getCreateName() == 0){
            return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("300", "this admin is superadmin,can`t edit", "", "", "", ""));
		}
        saveLogDetail("修改用户状态：" + user.toString());
		actionUserService.userStatus(user);
        return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200",
            "update success",
            "actionUserList",
            "",
            "forward",
            "action/actionUserList"));
	}
	
	
	
	/**
	 * 分配角色 保存Post
	 * @param req
	 * @param resp
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/action/actionUserRole", method = RequestMethod.POST)
	@ResponseBody
    //@ActionLog(content = "分配角色")
    public String actionUserRolePost(HttpServletRequest req, HttpServletResponse resp,
			ModelMap model){
		String userId = req.getParameter("userId");
		String values = req.getParameter("values");
		//首先删除用户角色关联信息
		actionUserRoleService.userDeleteId(Integer.parseInt(userId));
		String[] value = values.split(",");
		if(value.length>1){
			return responseFaild("actionUserList", "只能分配一种角色！", "");
		}
		if(value.length >0){
			for(String mp : value){
				ActionUserrole ur = new ActionUserrole();
				ur.setRoleId(Integer.parseInt(mp));
				ur.setUserId(Integer.parseInt(userId));
				actionUserRoleService.userRoleAdd(ur);
			}
		}
        saveLogDetail("角色id：" + values + " \n分配用户id：" + userId);
        return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", "give role success", "actionUserList", "", "closeCurrent", ""));
	}
	
	
	/**
	 * 用户分配角色
	 * @param req
	 * @param resp
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/action/actionUserRole", method = RequestMethod.GET)
	public String actionUserRoleGet(HttpServletRequest req,HttpServletResponse resp,
			ModelMap model){
		String id = req.getParameter("id");
		ActionUser user = actionUserService.userEdit(Integer.parseInt(id));
		List<ActionRole> role = actionRoleService.selectRoleList(user.getCreateName());
		model.put("userId", id);
		model.put("actionStr", getUserRole(role, 0, new StringBuffer(), Integer.parseInt(id)));
		return actionUserRole;
	}
	
	/**
	 * 分配角色信息列表
	 * @param actionUser 角色列表
	 * @param level 等级
	 * @param sb 返回字符串
	 * @param userId 用户ID
	 * @return
	 */
	public String getUserRole(List<ActionRole> actionUser, int level, StringBuffer sb, int userId){
		for (ActionRole tmp : actionUser) {
			// 查询该用户是否已经和该角色存在对应关系
            ActionUserrole aur = new ActionUserrole();
            aur.setUserId(userId);
            aur.setRoleId(tmp.getId());
            int count = actionUserRoleService.selectUserRole(aur);
			if (count > 0) {
				sb.append("<li><a checked=\"true\" tname=\"name\" tvalue=\"").append(tmp.getId()).append("\" >").append(tmp.getRoleName()).append("</a></li>");
			} else {
				sb.append("<li><a tname=\"name\" tvalue=\"").append(tmp.getId()).append("\" >").append(tmp.getRoleName()).append("</a></li>");
			}
		}
		return sb.toString();
	}
}
