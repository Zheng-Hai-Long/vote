<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<link href="../../../../res/css/common.css" rel="stylesheet" type="text/css" media="screen"/>
<script type="text/javascript" src="../../../../res/js/imgPro.js"></script>
<script type="text/javascript" src="../../../../res/js/jquery.imgareaselect.js"></script>

	<div class="pageContent">
		<form onsubmit="return iframeCallback(this, img_u_dialogAjaxDone);"
			class="pageForm" enctype="multipart/form-data"
			action="/bfile/save/upload/img" method="post">
			<input type="hidden" name="fileType" value="picture">
			<div layouth="60" class="pageFormContent"
				style="height: 500px; overflow: auto;">
				<div class="unit">
					<label>类别:</label>
					<input name="category" type="text" size="33" maxlength="70" class=""  value=""/>
				</div>
				<div class="unit">
					<label>排序值:</label>
					<input name="sort" type="text" size="33" class=""  value=""/>
				</div>
				<div class="unit">
					<label>图片描述:</label>
					<textarea id="description" name="description" rows="3" cols="35"></textarea>
				</div>
				<div class="unit">
					<div align=center>
						<table class="searchContent">
							<tr align="left">
								<td>内容图片：</td>
								<td><input type="file" id="picPath" name="img"
									onChange="PreviewImage(this,190,190);" />
								</td>
							</tr>
						</table>
					</div>
					<img id="preview_size_fake" />
					<div id="Preview" class="Preview"></div>
				</div>
			</div>
			<div class="formBar">
				<ul>
					<li><div class="buttonActive">
							<div class="buttonContent">
								<button type="submit">保存</button>
							</div>
						</div></li>
					<li>
						<div class="button">
							<div class="buttonContent">
								<button class="close" type="button" onclick="deleleDiv();">取消</button>
							</div>
						</div></li>
				</ul>
			</div>
		</form>
	</div>
	<script type="text/javascript">
		/**
		 * 获取图片坐标
		 */
		$(document).ready(function() {
			i_imageAreaSelect("190", "190");
		});
		function img_u_dialogAjaxDone(json) {
			DWZ.ajaxDone(json);
			if (json.statusCode == '200') {
				if (json.navTabId) { //把指定navTab页面标记为需要“重新载入”。注意navTabId不能是当前navTab页面的
					deleleDiv();
					navTab.reload('/bfile/img/list',
									{
										navTabId : json.navTabId
									});
				}
				if ("closeCurrent" == json.callbackType) {
					$.pdialog.closeCurrent();
				}
			}
		}
	</script>
