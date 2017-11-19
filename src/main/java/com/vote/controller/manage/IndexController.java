package com.vote.controller.manage;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;

import com.vote.pojo.ActionFunction;
import com.vote.pojo.ActionUser;
import com.vote.service.ActionFunctionService;

@Controller
public class IndexController extends BaseController
{
    @Autowired
    private ActionFunctionService actionFunctionService;
    
    public String listMenu(ActionUser user)
    {
        StringBuffer menu = new StringBuffer();//总菜单的html代码容器

        List<ActionFunction> af = actionFunctionService.indexList(user);

        List<ActionFunction> actionList = new ArrayList<ActionFunction>();
        for (ActionFunction tmp : af)
        {
            if (tmp.getParentFun() == 0)
            {
                actionList.add(tmp);
            }
            for (ActionFunction tmpp : af)
            {
                if (tmp.getId() == tmpp.getParentFun() || tmp.getId().equals(tmpp.getParentFun()))
                {
                    if (tmp.getActionFunctionlist() == null)
                    {
                        tmp.setActionFunctionlist(new ArrayList<ActionFunction>());
                    }
                    tmp.getActionFunctionlist().add(tmpp);
                }
            }
        }
        menu.append(this.getRoleStr(actionList, new StringBuffer()));
        return menu.toString();
        
    }

    public String getRoleStr(List<ActionFunction> actionList, StringBuffer sb)
    {
        for (ActionFunction tmp : actionList)
        {
            String actionName = tmp.getFunName();
            if (tmp.getParentFun() == 0)
            {
                sb.append("<div class=\"accordionHeader\"><h2><span>Folder</span>");
                sb.append(actionName);
                sb.append("</h2></div><div class=\"accordionContent\"><ul class=\"tree treeFolder\">");

                if (tmp.getActionFunctionlist() != null)
                {
                    this.getRoleStr(tmp.getActionFunctionlist(), sb);
                }

                sb.append("</ul></div>");
            }
            else
            {
                String target = tmp.getTarget();
                if (StringUtils.isEmpty(target))
                {
                    sb.append("<li><a>").append(actionName).append("</a>");
                }
                else
                {
                    sb.append("<li><a target=\"");
                    sb.append(target).append("\" href=\"");
                    sb.append(tmp.getAction());
                    sb.append("\" ");

                    String rel = tmp.getRel();
                    if (!StringUtils.isEmpty(rel))
                    {
                        sb.append("rel=\"").append(rel).append("\" ");
                    }

                    sb.append(" >").append(actionName).append("</a>");
                }

                if (tmp.getActionFunctionlist() != null)
                {
                    sb.append("<ul>");
                    this.getRoleStr(tmp.getActionFunctionlist(), sb);
                    sb.append("</ul>");
                }
            }
        }
        return sb.toString();
    }

    /**
     * 获取用户角色菜单按钮权限
     * @return
     */
    public List<ActionFunction> getUserActionFunctionList(ActionUser user)
    {
        //获取角色菜单权限
        List<ActionFunction> funList = actionFunctionService.functionUserList(user);
        return funList;
    }
}
