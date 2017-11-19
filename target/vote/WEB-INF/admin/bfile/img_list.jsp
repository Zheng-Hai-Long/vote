<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>
<div class="pageHeader">
	  <form id="pagerForm" method="post" action="bfile/img/list">
		<input type="hidden" name="pageNum" value="${page.pageNum }" />
		<input type="hidden" name="numPerPage" value="${page.pageSize}" />
		<input type="hidden" name="id" value="${param.id}" />
		<input type="hidden" name="fileType" value="${param.fileType}" />
		<input type="hidden" name="category" value="${param.category}" />
		<input type="hidden" name="url" value="${param.url}" />
		<input type="hidden" name="description" value="${param.description}" />
	</form>
	<div class="searchBar">
		<form method="post" rel="pagerForm" action="/bfile/img/list" onsubmit="return navTabSearch(this)">
			<table class="searchContent">
				<tr>
					<td>
						<label for="name" style="width:60px">图片ID：</label>
						<input class="textInput" value="${param.id }" style="width:114px" name="id"  type="text" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9.]+/,'');}).call(this)">
					</td>
					<td>
						<label for="name" style="width:60px">文件类型：</label>
						<input class="textInput" value="${param.fileType }" style="width:114px" id="fileType" name="fileType"  type="text">
					</td>
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
			<li><a class="add" href="bfile/upload/image" target="dialog" rel="upload_image" title="上传图片" mask=true width="500" height="500" maxable="false"><span>上传图片</span></a></li>
			<!-- <li><a class="add" href="bfile/uploadVideo.do" target="dialog" rel="uploadVideo" title="上传视频" mask=true width="500" height="500" maxable="false"><span>上传视频</span></a></li> -->
		</ul>
</div>
<div>
	<table class="table" width="100%"   layoutH="123">
		<thead>
			<tr>
				<th width="30">序号</th>
				<th width="70">图片ID</th>
				<th width="80">文件类型</th>
				<th width="80">类别</th>
				<th width="100">文件地址</th>
				<th width="100">H5中等图地址</th>
				<th width="100">H5小图地址</th>
				<th width="50">排序值</th>
				<th width="80">描述</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach  items="${list}" var="bfile" varStatus="status">
				<tr target="list_item_id" rel="${bfile.id }">
				 	<td>${status.count}</td>
				 	<td>${bfile.id }</td>
					<td>${bfile.fileType }</td>
					<td>${bfile.category }</td>
					<td><a href="${bfile.url }" target="_blank" style="color:blue;">点击查看图片</a></td>
					<td><a href="${bfile.middleUrl }" target="_blank" style="color:blue;">点击查看图片</a></td>
					<td><a href="${bfile.litterUrl }" target="_blank" style="color:blue;">点击查看图片</a></td>
					<td>${bfile.sort }</td>
					<td title="${bfile.description}">${bfile.description}</td>
					<td>
					    <a class="btnTslogo" href="bfile/set/img/${bfile.id }/url" target="dialog" height="260" width="420" title="配置图片链接地址"><span>配置图片链接地址</span></a>
					    <a class="btnEdit" href="bfile/edit/${bfile.id }/img" rel="bfileEdit_list" target="dialog" height="450" width="420" title="修改"><span>修改</span></a>
					    <a class="btnDel" href="bfile/delete/${bfile.id}/img" target="ajaxTodo" title="删除"><span>删除</span></a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<c:import url="../common/panelBar.jsp" />

</div>
	
