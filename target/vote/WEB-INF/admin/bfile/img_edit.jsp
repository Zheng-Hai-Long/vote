<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="pageContent">
	<form method="post" action="bfile/update/img" class="pageForm required-validate" rel="" onsubmit="return iframeCallback(this, dialogAjaxDone);">
		<div class="pageFormContent" layoutH="57">
		<input type="hidden" id="id" name="id" value="${bf.id }">
		<div class="unit">
			<label>类别:</label>
			<input name="category" type="text" size="30" value="${bf.category }" />
		</div>
		<div class="unit">
			<label>排序值:</label>
			<input name="sort" type="text" size="30" value="${bf.sort }" />
		</div>
		<div class="unit">
			<label>是否隐藏:</label>
			<select id="isHide" name="isHide"  style="width: 180px" >
			<option value="0" <c:if test="${bf.isHide==0 }">selected="selected"</c:if>>显示</option>
			<option value="1" <c:if test="${bf.isHide==1 }">selected="selected"</c:if>>隐藏</option>
			</select>
		</div>
		<div class="unit">
			<label>备注:</label>
			<input name="description" type="text" size="30" value="${bf.description }"  />
		</div>
		<div class="unit">
				<label>图片:</label>
				<div class="goodsimage">
					<a href="${bf.litterUrl}" target="_bank">
		        	<div class="prev">
						<img style="width:160px;height:160px;" src="${bf.litterUrl}" />
					</div>
					</a>
      			</div>
		</div>
		<div class="unit">
				<c:choose>
					<c:when test="${bf.litterUrl != null }">
						<a class="button" href="bfile/upload/image?id=${bf.id }&category=${bf.category}"
		 				rel="upload_headImg" target="dialog" title="修改图片" width="500" height="500" mask="true" maxable="false">
		 				<span>修改图片</span></a>
					</c:when>
					<c:otherwise>
						<a class="button" href="bfile/upload/image?id=${bf.id }&category=${bf.category}"
		 				rel="upload_headImg" target="dialog" title="上传图片" width="500" height="500" mask="true" maxable="false">
		 				<span>上传图片</span></a>
					</c:otherwise>
				</c:choose>
		</div>
		</div>
		<div class="formBar">
			<ul>
				<li>
					<div class="buttonActive">
						<div class="buttonContent">
							<button type="submit">保存</button>
						</div>
					</div>
				</li>
				<li>
					<div class="button">
						<div class="buttonContent">
							<button type="button" class="close">取消</button>
						</div>
					</div>
				</li>
			</ul>
		</div>
	</form>
</div>
