<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<link href="css/common.css" rel="stylesheet" type="text/css" media="screen"/>
<link rel="stylesheet" type="text/css" href="css/viewimg1.css">

<div class="pageContent">
		<div style="width:100%;height:460px;float: center; overflow: auto;">
			<ul class="goodsarea">
	  			<c:forEach var="item" items="${imgList}" varStatus="status">
					<li>
						<%-- <a
							href="bfile/showDetail.do?id=${item.id}"
							target="dialog" width="820" height="680" style="color:blue;"
							rel="show_img" title="文件图片"  resizable="true" mask="true"
							maxable="false" drawable="true"> --%>
						<a
							href="${item.url}"
							target="_bank">
			        	<div class="goodsimage">
			        		<div class="prev">
								<img src="${item.url}" />
							</div>
	      				</div>
	      				</a>
	        		</li>
	        		<c:if test="${status.count%3==0}"><br/></c:if>
	    		</c:forEach>
			</ul>
		</div>
</div>
