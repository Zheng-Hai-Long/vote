<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>
<div class="pageHeader">
	  <form id="pagerForm" method="post" action="/bfile/fileList.do">
		<input type="hidden" name="pageNum" value="${page.pageNum }" />
		<input type="hidden" name="numPerPage" value="${page.pageSize}" />
		<input type="hidden" name="id" value="${param.id}" />
		<input type="hidden" name="fileType" value="${param.fileType}" />
		<input type="hidden" name="category" value="${param.category}" />
		<input type="hidden" name="url" value="${param.url}" />
		<input type="hidden" name="description" value="${param.description}" />
	</form>
	<div class="searchBar">
		<form method="post" rel="pagerForm" action="/bfile/fileList.do" onsubmit="return navTabSearch(this)">
			<table class="searchContent">
				<tr>
					<td>
						<label for="name" style="width:60px">类别：</label>
						<select id="category" name="category"  style="width: 120px" >
							<option value=""  >全部</option>
							<c:forEach var="category" items="${categorys }">
							<option value="${category.category }" <c:if test="${param.category == category.category}">selected="selected"</c:if>>${category.category }</option>
							</c:forEach>
						</select>
						<%-- <input class="textInput" value="${param.category }" style="width:114px" id="category" name="category"  type="text"> --%>
					</td>
					<td >
						<div class="subBar">
							<ul>
								<li><div class="buttonActive"><div class="buttonContent"><button type="submit">查询</button></div></div></li>
								<li><div class="buttonActive"><div class="buttonContent"><button type="reset" onclick="resetSysLogQuery()">重置</button></div></div></li>
							</ul>
						</div>
					</td>
				</tr>
			</table>
		</form>	
	</div>
</div>
<div class="panelBar">
		<ul class="toolBar">
			<form onsubmit="return iframeCallback(this, navTabAjaxDone)" class="pageForm" enctype="multipart/form-data" action="bfile/fileImport.do" method="post">
			<li><input type="file" id="picPath" name="file"/></li>
			<li><button type="submit">上传</button></li>
			</form>
		</ul>
</div>
<div>
	<table class="table" width="100%"   layoutH="123">
		<thead>
			<tr>
				<th width="30">序号</th>
				<th width="70">文件ID</th>
				<th width="80">类别</th>
				<th width="260">文件地址</th>
				<th width="30">排序值</th>
				<th width="100">描述</th>
				<th width="100">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach  items="${list}" var="bfile" varStatus="status">
				<tr target="list_item_id" rel="${bfile.id }">
				 	<td>${status.count}</td>
				 	<td>${bfile.id }</td>
					<td>${bfile.category }</td>
					<td>${bfile.url }</td>
					<td>${bfile.sort }</td>
					<td title="${bfile.description}">${bfile.description}</td>
					<td>
					    <%-- <a class="btnTslogo" href="bfile/setFilePictureURL.do?id=${bfile.id }" target="dialog" height="260" width="420" title="配置图片链接地址"><span>配置图片链接地址</span></a>
					    <a class="btnEdit" href="bfile/editFilePicture.do?id=${bfile.id }" target="dialog" height="260" width="420" title="修改"><span>修改</span></a>--%>
					    <a class="btnDel" href="bfile/deleteFile.do?id=${bfile.id}" target="ajaxTodo" title="删除"><span>删除</span></a> 
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<c:import url="../common/panelBar.jsp" />
	<script type="text/javascript">
		function dialogAjax(json) {
			DWZ.ajaxDone(json);
			$.navTab.reload('/bfile/bfileList.do?fileType=file',{dialogId:'file_list'});
		}
	</script>
</div>
	
