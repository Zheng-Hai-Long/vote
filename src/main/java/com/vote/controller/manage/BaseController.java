package com.vote.controller.manage;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.vote.constants.SessionConstants;
import com.vote.pojo.ActionUser;
import com.vote.utils.ActionUtil;
import com.vote.utils.JsonUtil;


@Controller
public class BaseController
{
    protected transient final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    private String detail;

    public void saveLogDetail(String detail)
    {
        this.detail = detail;
    }
    
    public String getDetail()
    {
        return detail;
    }

    public void saveAdmin(HttpServletRequest req, ActionUser user)
    {
        setAttribute(req, SessionConstants.SESSION_OPERATOR_USER, user);
    }
    
    public void removeAdmin(HttpServletRequest req)
    {
        req.getSession().removeAttribute(SessionConstants.SESSION_OPERATOR_USER);
    }

    public ActionUser getActionUser(HttpServletRequest req)
    {
        return (ActionUser)req.getSession().getAttribute(SessionConstants.SESSION_OPERATOR_USER);
    }

    public void setAttribute(HttpServletRequest request, String key, Object object)
    {
        request.getSession().setAttribute(key, object);
    }
    
    @InitBinder
    public void initBinder(WebDataBinder binder)
    {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }
    
    /**
     * 
     * @param rel
     * @param msg
     * @param callbackType callbackType如果是closeCurrent就会关闭当前tab 或是dialog
     * @return
     */
    public String responseSuccess(String rel, String msg, String callbackType)
    {
        if (callbackType == null)
        {
            callbackType = "";
        }
        return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", msg, rel, "", callbackType, ""));
    }
    
    /**
     * 
     * @param rel
     * @param msg
     * @param callbackType callbackType如果是closeCurrent就会关闭当前tab 或是dialog
     * @return
     */
    public String responseFaild(String rel, String msg, String callbackType)
    {
        if (callbackType == null)
        {
            callbackType = "";
        }
        return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("300", msg, rel, "", callbackType, ""));
    }
    
    /**
     * 弹出上传图片框
     * @param key 返回到页面的对象
     * @param viewName 返回页面
     * @param vo 公共vo
     * @param service 公共service
     * @param model ModelMap
     * @return
     */
   /* public String alertUploadImg(String key,String viewName,UploadImageVO vo,IUploadImageService service,ModelMap model){
    	if(vo.getId()!=null){
    		vo=service.selectById(vo.getId());
    	}
    	model.put(key, vo);
    	return viewName;
    }*/
    
    /**
     * 图片的排序页面显示
     * @param idName
     * @param viewName
     * @param imgId
     * @param id
     * @param model
     * @return
     *//*
    public String sortImg(String idName,String viewName,Integer imgId,Integer id,ModelMap model){
    	BFile bFile = bfileService.queryById(imgId);
    	model.put("bFile", bFile);
    	model.put(idName, id);
    	return viewName;
    }
    
    *//**
     * 图片的显示和隐藏
     * @param imgId
     * @param viewName
     * @param isHide
     * @param model
     * @return
     *//*
    public String imgHideOrShow(Integer imgId,String viewName,Integer isHide,ModelMap model){
    	BFile bFile = bfileService.queryById(imgId);
    	bFile.setIsHide(isHide);
    	bfileService.update(bFile);
    	return responseSuccess(viewName, "update success", "");
    }
    
    *//**
     * 图片说明
     * @param imgId
     * @param viewName
     * @param model
     * @return
     *//*
    public String detailImg(Integer imgId,String viewName,ModelMap model){
    	String realPath = "http://res.17xs.org/picture/";
    	BFile bFile = bfileService.queryById(imgId);
    	bFile.setUrl(realPath+bFile.getUrl());
    	model.put("bFile", bFile);
    	return viewName;
    }
    //上传图片
    //删除图片
    public String imgDel(UploadImageVO vo,Integer imgId,IUploadImageService service,ModelMap model,String parameter){
    	if (vo != null && vo.getId() != null && imgId != null)
        {
    		if(parameter=="manage_img")
    		{
    			Project project=new Project();
    			project = projectService.queryById(vo.getId());
    		
        	//vo = service.queryById(vo.getId());
            String contentImageId = "";
            if (project != null)
            {
                contentImageId = project.getContentImageId() == null ? "" : project.getContentImageId();
                if (contentImageId.indexOf(imgId + "") >= 0)
                {
                    contentImageId = contentImageId.replaceAll("," + imgId, "");
                    contentImageId = contentImageId.replaceAll(imgId + ",", "");
                    contentImageId = contentImageId.replaceAll(imgId + "", "");
                }
                //vo.setContentImageId(contentImageId);
                //vo.setLastUpdateTime(new Date());
                	project.setContentImageId(contentImageId);
                	project.setLastUpdateTime(new Date());
            		projectService.update(project);
            }
            
                //proje.update(vo);
                
                Config config = new Config();
                config.setConfigKey("fileBasicURL");
                String fileBasicURL = configService.queryByParam(config).get(0).getConfigValue();
                if (StringUtil.isEmpty(fileBasicURL))
                {
                	return responseFaild(parameter, "删除失败！", null);
                }
                String realPath = fileBasicURL + "/upload/picture/";
                BFile bFile = bfileService.queryById(imgId);
                boolean result = ImageTool.deletePicture(realPath + bFile.getUrl());//删除图片
                if (result)
                {
                	bfileService.delete(imgId);
                }
                model.put("project", project);
                return responseSuccess(parameter, "删除成功！", null);
            }
    		else if(parameter=="auction_img")
    		{
    			AuctionProject ap=new AuctionProject();
    			ap = auctionProjectService.queryById(vo.getId());
    			String contentImageId = "";
            if (ap != null)
            {
                contentImageId = ap.getContentImageId() == null ? "" : ap.getContentImageId();
                if (contentImageId.indexOf(imgId + "") >= 0)
                {
                    contentImageId = contentImageId.replaceAll("," + imgId, "");
                    contentImageId = contentImageId.replaceAll(imgId + ",", "");
                    contentImageId = contentImageId.replaceAll(imgId + "", "");
                }
                	ap.setContentImageId(contentImageId);
                	ap.setLastUpdateTime(new Date());
                	auctionProjectService.update(ap);
            }
            
                
                Config config = new Config();
                config.setConfigKey("fileBasicURL");
                String fileBasicURL = configService.queryByParam(config).get(0).getConfigValue();
                if (StringUtil.isEmpty(fileBasicURL))
                {
                	return responseFaild(parameter, "删除失败！", null);
                }
                String realPath = fileBasicURL + "/upload/picture/";
                BFile bFile = bfileService.queryById(imgId);
                boolean result = ImageTool.deletePicture(realPath + bFile.getUrl());//删除图片
                if (result)
                {
                	bfileService.delete(imgId);
                }
                model.put("ap", ap);
                return responseSuccess(parameter, "删除成功！", null);
    		}
    		else if(parameter=="gift_img")
    		{
    			Gift gift=new Gift();
    			gift = giftService.queryById(vo.getId());
    			String contentImageId = "";
            if (gift != null)
            {
                contentImageId = gift.getContentImageId() == null ? "" : gift.getContentImageId();
                if (contentImageId.indexOf(imgId + "") >= 0)
                {
                    contentImageId = contentImageId.replaceAll("," + imgId, "");
                    contentImageId = contentImageId.replaceAll(imgId + ",", "");
                    contentImageId = contentImageId.replaceAll(imgId + "", "");
                }
                gift.setContentImageId(contentImageId);
                gift.setLastUpdateTime(new Date());
                giftService.update(gift);
            }
                Config config = new Config();
                config.setConfigKey("fileBasicURL");
                String fileBasicURL = configService.queryByParam(config).get(0).getConfigValue();
                if (StringUtil.isEmpty(fileBasicURL))
                {
                	return responseFaild(parameter, "删除失败！", null);
                }
                String realPath = fileBasicURL + "/upload/picture/";
                BFile bFile = bfileService.queryById(imgId);
                boolean result = ImageTool.deletePicture(realPath + bFile.getUrl());//删除图片
                if (result)
                {
                	bfileService.delete(imgId);
                }
                model.put("gift", gift);
                return responseSuccess(parameter, "删除成功！", null);
    		}
    		else if(parameter=="news")
    		{
    			NewsVO newsvo=new NewsVO();
    			newsvo = newsService.queryById(vo.getId());
        		
            	//vo = service.queryById(vo.getId());
                String contentImageId = "";
                if (newsvo != null)
                {
                    contentImageId = newsvo.getContentImageId() == null ? "" : newsvo.getContentImageId();
                    if (contentImageId.indexOf(imgId + "") >= 0)
                    {
                        contentImageId = contentImageId.replaceAll("," + imgId, "");
                        contentImageId = contentImageId.replaceAll(imgId + ",", "");
                        contentImageId = contentImageId.replaceAll(imgId + "", "");
                    }
                    //vo.setContentImageId(contentImageId);
                    //vo.setLastUpdateTime(new Date());
                    newsvo.setContentImageId(contentImageId);
                    newsvo.setLastUpdateTime(new Date());
                    newsService.editNews(newsvo);
                }
                
                    Config config = new Config();
                    config.setConfigKey("fileBasicURL");
                    String fileBasicURL = configService.queryByParam(config).get(0).getConfigValue();
                    if (StringUtil.isEmpty(fileBasicURL))
                    {
                    	return responseFaild("cover_img", "删除失败！", null);
                    }
                    String realPath = fileBasicURL + "/upload/picture/";
                    BFile bFile = bfileService.queryById(imgId);
                    boolean result = ImageTool.deletePicture(realPath + bFile.getUrl());//删除图片
                    if (result)
                    {
                    	bfileService.delete(imgId);
                    }
                    model.put("project", newsvo);
                    return responseSuccess("manage_img", "删除成功！", null);
    		}
    		else if(parameter=="cover_image"){
    			Category cate = categoryService.selectById(vo.getId());
            if (vo != null)
            {
            	cate.setCoverImageId(null);
                categoryService.update(cate);
                
                Config config = new Config();
                config.setConfigKey("fileBasicURL");
                String fileBasicURL = configService.queryByParam(config).get(0).getConfigValue();
                if (StringUtil.isEmpty(fileBasicURL))
                {
                    return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("300","faild for fileBasicURL is null",parameter, "","",""));
                }
                String realPath = fileBasicURL + File.separator+"upload"+File.separator+"picture"+File.separator;
                BFile bFile = bfileService.queryById(imgId);
                boolean result = ImageTool.deletePicture(realPath + bFile.getUrl());//删除图片
                if (result)
                {
                    bfileService.delete(imgId);
                }
                model.put("category", vo);
                return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", "delete success", parameter, "", "", ""));
            }
    		}
    		else if(parameter=="goodlibrary_img")
    		{
    			GoodLibrary goodLibrary=new GoodLibrary();
    			goodLibrary = goodLibraryService.queryById(vo.getId());
    			String contentImageId = "";
            if (goodLibrary != null)
            {
                contentImageId = goodLibrary.getContentImageId() == null ? "" : goodLibrary.getContentImageId();
                if (contentImageId.indexOf(imgId + "") >= 0)
                {
                    contentImageId = contentImageId.replaceAll("," + imgId, "");
                    contentImageId = contentImageId.replaceAll(imgId + ",", "");
                    contentImageId = contentImageId.replaceAll(imgId + "", "");
                }
                goodLibrary.setContentImageId(contentImageId);
                if(goodLibrary.getLogoId()!=null&&goodLibrary.getLogoId().equals(imgId)){
                	goodLibrary.setLogoId(0);
                }
                goodLibraryService.update(goodLibrary);
            }
                Config config = new Config();
                config.setConfigKey("fileBasicURL");
                String fileBasicURL = configService.queryByParam(config).get(0).getConfigValue();
                if (StringUtil.isEmpty(fileBasicURL))
                {
                	return responseFaild(parameter, "删除失败！", null);
                }
                String realPath = fileBasicURL + "/upload/picture/";
                BFile bFile = bfileService.queryById(imgId);
                boolean result = ImageTool.deletePicture(realPath + bFile.getUrl());//删除图片
                if (result)
                {
                	bfileService.delete(imgId);
                }
                model.put("goodLibrary", goodLibrary);
                return responseSuccess(parameter, "删除成功！", null);
    		}
    		
            else{
            	return responseFaild(parameter, "删除失败！", null);
            }
    			
        }
    	else{
        	return responseFaild(parameter, "删除失败！", null);
        }
		return responseFaild(parameter, "删除失败！", null);
    }
    //设为logo
    public String setLogo(UploadImageVO vo,Integer imgId,ModelMap model,String parameter){
    	 if (vo != null && vo.getId() != null && imgId != null)
         {
    		 if(parameter=="cover_image"){
    			 NewsVO newsvo =new NewsVO();
    			 newsvo = newsService.selectById(vo.getId());
                 if (newsvo != null)
                 {
                	newsvo.setCoverImageId(imgId);
                 	newsService.editNews(newsvo);
                    model.put("news", newsvo);
                    return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", "set logo success", parameter, "", "", ""));
                 }
                 return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("300", "faild for error", parameter, "", "", ""));
    		 }
    		 else if(parameter=="manage_img"){
    			 Project project =new Project();
    			 project = projectService.selectById(vo.getId());
                 if (project != null)
                 {
                	 project.setCoverImageId(imgId);
                	projectService.update(project);
                    model.put("project", project);
                    return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", "set logo success", parameter, "", "", ""));
                 }
                 return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("300", "faild for error", parameter, "", "", ""));
    		 }
    		 else if(parameter=="auction_img"){
    			 AuctionProject ap =new AuctionProject();
    			 ap = auctionProjectService.queryByAuctionProjectId(vo.getId());
    	            if (ap != null)
    	            {
    	            	ap.setCoverImageId(imgId);
    	                auctionProjectService.update(ap);
    	                Project p = projectService.queryById(vo.getId());
    	                if(p != null){
    	                	p.setCoverImageId(imgId);
    	                	projectService.update(p);
    	                }
    	                model.put("ap", ap);
    	                return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", "set logo success", parameter, "", "", ""));
    	            }
    			 return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("300", "faild for error", parameter, "", "", ""));
    		 }
    		 else if(parameter=="gift_img"){
    			 Gift gift =new Gift();
    			 gift = giftService.selectById(vo.getId());
                 if (gift != null)
                 {
                	 gift.setCoverImageId(imgId);
                	giftService.update(gift);
                    model.put("gift", gift);
                    return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", "set logo success", parameter, "", "", ""));
                 }
                 return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("300", "faild for error", parameter, "", "", ""));
    		 }
    		 else if(parameter=="goodlibrary_img"){
    			 GoodLibrary goodLibrary =new GoodLibrary();
    			 goodLibrary = goodLibraryService.selectById(vo.getId());
                 if (goodLibrary != null)
                 {
                	 goodLibrary.setLogoId(imgId);
                	goodLibraryService.update(goodLibrary);
                    model.put("goodLibrary", goodLibrary);
                    return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", "set logo success", parameter, "", "", ""));
                 }
                 return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("300", "faild for error", parameter, "", "", ""));
    		 }
    		 else
             {
                 return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("300", "faild for error", parameter, "", "", ""));
             }
         }else{
             return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("300", "faild for error", parameter, "", "", ""));
         }
    }
    *//**
     * 修改图片排序
     * @param bf
     * @param model
     * @param param
     * @return
     *//*
    public String editSort(BFile bf,ModelMap model,String param){
    	BFile bFile = bfileService.queryById(bf.getId());
    	bFile.setSort(bf.getSort());
    	saveLogDetail("修改项目图片排序"+bFile.getId());
    	int flag = bfileService.update(bFile);
    	if(flag >0){
    		return responseSuccess(param, "update success", "closeCurrent");
    	}else {
    		return responseFaild(param, "update fail", "closeCurrent");
		}
    }
    
    *//**
     * 清空图片排序
     * @param contentImageId
     * @param param
     * @return
     *//*
    public String clearSort(String contentImageId,String param){
    	List<BFile> imgList = new ArrayList<BFile>();
    	if(StringUtil.isNotEmpty(contentImageId)){
    		 String[] image_ids = contentImageId.split("\\,");
             List<Integer> idList = new ArrayList<Integer>();
             for (String image_id : image_ids)
             {
                 if (StringUtil.isNotEmpty(image_id))
                 {
                 	idList.add(Integer.parseInt(image_id));
                 }
             }
            imgList = bfileService.queryByIdList(idList);
            for(BFile bFile :imgList){
                BFile bf = new BFile();
                bf.setId(bFile.getId());
                bf.setSort(0);
                bfileService.update(bf);
            }
    	}else {
			return responseFaild(param, "clear fail", "");
		}
    	return responseSuccess(param, "clear success", "");
    }*/
}

