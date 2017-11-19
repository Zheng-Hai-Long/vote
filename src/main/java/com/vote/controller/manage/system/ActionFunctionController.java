package com.vote.controller.manage.system;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.vote.pojo.ActionFunction;
import com.vote.pojo.vo.ActionFunctionVO;
import com.vote.service.ActionFunctionService;
import com.vote.service.ActionRoleFunService;
import com.vote.utils.ActionUtil;
import com.vote.utils.JsonUtil;
import com.vote.controller.manage.BaseController;

/**
 * 菜单  action
 * @author dell
 */
@Controller
public class ActionFunctionController extends BaseController{
	
	@Autowired
	private ActionFunctionService actionFunctionService;
	@Autowired
	private ActionRoleFunService actionRoleFunService;
	
	/** 菜单列表页面*/
    private static String actionFunctionList = "admin/actionFunction/actionFunctionList";
	/** 菜单添加页面*/
    private static String actionFunctionAdd = "admin/actionFunction/actionFunctionAdd";
	
    private static String actionFunctionEdit = "admin/actionFunction/actionFunctionEdit";
	/** 查找带回页面*/
    private static String parentId = "admin/actionFunction/parentId";

	/**
	 *  菜单列表查询  post
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/action/actionFunctionList", method = RequestMethod.POST)
    //@ActionLog(content = "查询菜单列表")
    public String actionFunctionListPost(ActionFunctionVO vo, ModelMap model)
    {
		//调用sql查询方法
        List<ActionFunction> functionList = actionFunctionService.queryFunctionList(vo);

        PageInfo<ActionFunction> page = new PageInfo<ActionFunction>(functionList);
		model.put("page", page);
        model.put("functionList", functionList);
        model.put("actionFunction", vo);
		return actionFunctionList;
	}
	
	/**
	 *  菜单列表查询  get
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/action/actionFunctionList", method = RequestMethod.GET)
    public String actionFunctionListGet(ActionFunctionVO vo,
			ModelMap model){
        String actionFunction = actionFunctionListPost(vo, model);
		return actionFunction;
	}
	
	/**
	 *  添加权限 get
	 * @param req
	 * @param resp
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/action/actionFunctionAdd", method = RequestMethod.GET)
	public String actionFunctionAddGet(HttpServletRequest req, HttpServletResponse resp,
			ModelMap model){
		return actionFunctionAdd;
	}
	/**
	 *  添加权限 Post
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/action/actionFunctionAdd", method = RequestMethod.POST)
	@ResponseBody
    //@ActionLog(content = "添加菜单")
    public String actionFunctionAddPost(ActionFunction function,
			ModelMap model){
        saveLogDetail("添加菜单：" + function.toString());
        if(function.getParentFun()==null){
        	function.setParentFun(0);
        }
        logger.info("添加菜单"+function.toString());
		actionFunctionService.functionAdd(function);
		logger.info("添加菜单成功"+function.toString());
		return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", "success", "actionFunctionList", "", "closeCurrent", ""));
	}
	
	/**
	 * 查询全部权限 get
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/action/parentId", method = RequestMethod.GET)
    public String parentIdGet(ActionFunctionVO vo,
			ModelMap model){
        String parent = parentIdPost(vo, model);
		return parent;
	}
	
	/**
	 * 查询全部权限  post
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/action/parentId", method = RequestMethod.POST)
    //@ActionLog(content = "查询全部菜单")
	public String parentIdPost(ActionFunctionVO vo,
			ModelMap model){
		//调用sql查询方法
		List<ActionFunction> list = actionFunctionService.queryFunctionList(vo);
		PageInfo<ActionFunction> page = new PageInfo<ActionFunction>(list);
        model.put("page", page);
        model.put("actionFunction", vo);
        model.addAttribute("list", list);
		return parentId;
	}
	
	/**
	 *  跳转修改页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/action/actionFunctionEdit", method = RequestMethod.GET)
    public String actionUserEditGET(ActionFunction vo,
			ModelMap model) {
        ActionFunction function = actionFunctionService.functionEditParentFun(vo.getId());
		if(function.getParentFun() != 0){
            function = actionFunctionService.functionEdit(vo.getId());
		}
		model.put("function", function);
		return actionFunctionEdit;
	}
	
	/**
	 * 修改页面信息保存
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/action/actionFunctionEdit", method = RequestMethod.POST)
	@ResponseBody
    //@ActionLog(content = "修改菜单")
    public String actionUserEditPost(ActionFunction vo,
			ModelMap model) {
		StringBuffer sb = new StringBuffer();
        sb.append("修改前：").append(actionFunctionService.functionEditParentFun(vo.getId()).toString());
        saveLogDetail(sb.toString());
        //TODO
		//actionFunctionService.functionEditOk(vo);
		return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", "Edit menu success", "actionFunctionList", "actionFunctionList", "closeCurrent", ""));
		
	}
	
	/**
	 * 权限信息删除
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/action/actionFunctionDelete", method = RequestMethod.POST)
	@ResponseBody
    //@ActionLog(content = "删除菜单")
	public String actionFunctionDeletePost(@RequestParam("id")int id,
			ModelMap model){
        saveLogDetail("删除菜单：" + actionFunctionService.functionEditParentFun(id));
		//删除权限菜单
		actionFunctionService.functionDelete(id);
		//删除角色权限关联信息
		actionRoleFunService.funDelete(id);
		return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", "delete menu success", "actionFunctionList", "", "", ""));
	}
}
