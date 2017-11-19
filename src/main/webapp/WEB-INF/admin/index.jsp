<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-eq../../../uiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-eq../../../uiv="X-UA-Compatible" content="IE=7" />
<title>美怡管理后台</title>
<link href="../../../ui/themes/default/style.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="../../../ui/themes/css/core.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="../../../ui/themes/css/print.css" rel="stylesheet" type="text/css" media="print"/>
<link href="../../../ui/uploadify/css/uploadify.css" rel="stylesheet" type="text/css" media="screen"/>
<script src="../../../ui/js/jquery-1.7.2.js" type="text/javascript"></script>
<script src="../../../ui/js/jquery.cookie.js" type="text/javascript"></script>
<script src="../../../ui/js/jquery.validate.js" type="text/javascript"></script>
<script src="../../../ui/js/jquery.bgiframe.js" type="text/javascript"></script>
<script src="../../../ui/xheditor/xheditor-1.1.14-zh-cn.min.js" type="text/javascript"></script>
<script src="../../../ui/uploadify/scripts/jquery.uploadify.js" type="text/javascript"></script>
<script src="../../../ui/uploadify/scripts/jquery.uploadify.min.js" type="text/javascript"></script>
<script src="../../../ui/bin/dwz.min.js" type="text/javascript"></script>
<script src="../../../ui/js/dwz.regional.zh.js" type="text/javascript"></script>
<script src="../../../ui/js/dwz.core.js" type="text/javascript"></script>
<script src="../../../ui/js/dwz.util.date.js" type="text/javascript"></script>
<script src="../../../ui/js/dwz.validate.method.js" type="text/javascript"></script>
<script src="../../../ui/js/dwz.barDrag.js" type="text/javascript"></script>
<script src="../../../ui/js/dwz.drag.js" type="text/javascript"></script>
<script src="../../../ui/js/dwz.tree.js" type="text/javascript"></script>
<script src="../../../ui/js/dwz.accordion.js" type="text/javascript"></script>
<script src="../../../ui/js/dwz.../../../ui.js" type="text/javascript"></script>
<script src="../../../ui/js/dwz.theme.js" type="text/javascript"></script>
<script src="../../../ui/js/dwz.switchEnv.js" type="text/javascript"></script>
<script src="../../../ui/js/dwz.alertMsg.js" type="text/javascript"></script>
<script src="../../../ui/js/dwz.contextmenu.js" type="text/javascript"></script>
<script src="../../../ui/js/dwz.navTab.js" type="text/javascript"></script>
<script src="../../../ui/js/dwz.tab.js" type="text/javascript"></script>
<script src="../../../ui/js/dwz.resize.js" type="text/javascript"></script>
<script src="../../../ui/js/dwz.dialog.js" type="text/javascript"></script>
<script src="../../../ui/js/dwz.dialogDrag.js" type="text/javascript"></script>
<script src="../../../ui/js/dwz.sortDrag.js" type="text/javascript"></script>
<script src="../../../ui/js/dwz.cssTable.js" type="text/javascript"></script>
<script src="../../../ui/js/dwz.stable.js" type="text/javascript"></script>
<script src="../../../ui/js/dwz.taskBar.js" type="text/javascript"></script>
<script src="../../../ui/js/dwz.ajax.js" type="text/javascript"></script>
<script src="../../../ui/js/dwz.pagination.js" type="text/javascript"></script>
<script src="../../../ui/js/dwz.database.js" type="text/javascript"></script>
<script src="../../../ui/js/dwz.datepicker.js" type="text/javascript"></script>
<script src="../../../ui/js/dwz.effects.js" type="text/javascript"></script>
<script src="../../../ui/js/dwz.panel.js" type="text/javascript"></script>
<script src="../../../ui/js/dwz.checkbox.js" type="text/javascript"></script>
<script src="../../../ui/js/dwz.history.js" type="text/javascript"></script>
<script src="../../../ui/js/dwz.combox.js" type="text/javascript"></script>
<script src="../../../ui/js/dwz.print.js" type="text/javascript"></script>
<script src="js/head.js" type="text/javascript"></script>
<!-- 可以用dwz.min.js替换前面全部dwz.*.js (注意：替换是下面dwz.regional.zh.js还需要引入)
<script src="bin/dwz.min.js" type="text/javascript"></script>
-->
<script src="../../../ui/js/dwz.regional.zh.js" type="text/javascript"></script>

<!-- <link rel="stylesheet" type="text/css" href="My97DatePicker/skin/WdatePicker.css" />
<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script> -->

<script type="text/javascript">
//document.onkeydown=banBackSpace;
$(function(){
	DWZ.init("../../../ui/dwz.frag.xml", {
		loginUrl:"loginfo.do",	// 跳到登录页面
		statusCode:{ok:200, error:300, timeout:301}, //【可选】
		pageInfo:{pageNum:"pageNum", numPerPage:"numPerPage", orderField:"orderField", orderDirection:"orderDirection"}, //【可选】
		debug:false,	// 调试模式 【true|false】
		callback:function(){
			initEnv();
			$("#themeList").theme({themeBase:"../../../ui/themes"}); // themeBase 相对于index页面的主题base路径
		}
	});
});
</script>
</head>

<body scroll="no">
	<div id="layout">
		<div id="header">
			<div class="headerNav">
				<!-- <a class="logo" href="http://">标志</a> -->
				<div style="font-size: 25px;font-weight: bold;color: #fff;padding-left:10px;height: 40px;padding-top: 10px;width: 70%;">美怡管理后台
						<marquee style="height: 40px;font-size: 25px;width: 80%; float: right;margin: 0 auto;margin-top:-30px\9;line-height: 40px;overflow: hidden;" onmouseover="this.stop();" onmouseout="this.start();" scrollamount="3" id="dangerSchemes">
						</marquee>
				</div>
				
				<ul class="nav">
					<li><a href="javascript:void(0);">您好,${userName }</a></li>
					<li><a href="action/${actionUser.id }/actionUserEditGET" target="dialog" rel="actionUserEditit" mask=true width="480" height="242">个人信息</a></li>
					<li><a href="action/actionUserPwd" target="dialog" rel="actionUserPwd" mask=true width="510" height="170" >修改密码</a></li>
					<li><a href="loginout">退出</a></li>
				</ul>
				<!-- 
				<ul class="themeList" id="themeList">
					<li theme="default"><div class="selected">蓝色</div></li>
					<li theme="green"><div>绿色</div></li>
					<li theme="red"><div>红色</div></li>
					<li theme="purple"><div>紫色</div></li>
					<li theme="silver"><div>银色</div></li>
					<li theme="azure"><div>天蓝</div></li>
				</ul>
				 -->
			</div>
		</div>
		
		<!-- navMenu -->
		
		<div id="leftside">
			<div id="sidebar_s">
				<div class="collapse">
					<div class="toggleCollapse"><div></div></div>
				</div>
			</div>
			<div id="sidebar">
				<div class="toggleCollapse"><h2>主菜单</h2><div>收缩</div></div>

				<div class="accordion" fillSpace="sidebar">
					${roleStr}
				</div>
			</div>
		</div>
		
		<div id="container">
			<div id="navTab" class="tabsPage">
				<div class="tabsPageHeader">
					<div class="tabsPageHeaderContent"><!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
						<ul class="navTab-tab">
							<li tabid="main" class="main"><a href="javascript:;"><span><span class="home_icon">我的主页</span></span></a></li>
						</ul>
					</div>
					<div class="tabsLeft">left</div><!-- 禁用只需要添加一个样式 class="tabsLeft tabsLeftDisabled" -->
					<div class="tabsRight">right</div><!-- 禁用只需要添加一个样式 class="tabsRight tabsRightDisabled" -->
					<div class="tabsMore">more</div>
				</div>
				<ul class="tabsMoreList">
					<li><a href="javascript:;">我的主页</a></li>
				</ul>
				<div class="navTab-panel tabsPageContent layoutBox">
					<div class="page unitBox">
						<div class="accountInfo">
							<p><h1 style="font-size: 22px;text-align: center;">您好，${userName}。欢迎使用美怡管理平台！</h1></p>
					
						</div>
						<div class="pageFormContent" layoutH="80">
						<!--	<h2 style="font-size: 18px;">系统操作说明： </h2>
							<pre style="margin:20px;line-height:2.2em;font-size: 18px;">
1.本系统为短信下发管理系统，所有操作<span style="color: red;font-size: 18px;">请慎重</span>！！！
2.号码请<span style="color: red;font-size: 18px;">踢重</span>。
3.数据文件中号码应<span style="color: red;font-size: 18px;">一行一个</span>，必须是<span style="color: red;font-size: 18px;">11位移动号码</span>，两头不要带引号
							</pre>-->
							<%-- <%@ include file="common/common.jsp"%>
							<script type="text/javascript">
							document.onkeydown=banBackSpace;
							</script> --%>
							
							<%-- <div class="pageHeader">
								<form id="pagerForm" method="post" action="researchDatas.do">
									<input type="hidden" name="pageNum" value="${page.pageNum }" />
									<input type="hidden" name="numPerPage" value="${page.pageSize}" />
									
								</form>
								<div class="searchBar">
									<form method="post" rel="pagerForm" action="researchDatas.do" onsubmit="return navTabSearch(this)">
										<table class="searchContent">
											<tr>
												<td>
													<label for="name" style="width:50px">数据来源：</label>
													<select id="source" name="source"  style="width: 120px" >
														<option value="全部"  >全部</option>
														<option value="PC"  <c:if test="${ds.source == 'PC'}">selected="selected"</c:if> >PC端</option>
														<option value="H5"  <c:if test="${ds.source == 'H5'}">selected="selected"</c:if> >H5端</option>
													</select>
												</td>
												<td>
													<label for="name" style="width:80px;">日期：</label>
													<input name="startDate" type="text" class="textInput readonly valid Wdate" style="width:114px;height:15px;"
									                   onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'endDate\')}'})"
									                   id="startDate"
									                   value="<fmt:formatDate value="${ds.startDate}" pattern="yyyy-MM-dd"/>"
									                   maxlength="19">
												</td>
												<td>
													<label for="name" style="width:50px">- 到 -</label>
													<input name="endDate" type="text" class="textInput readonly valid Wdate" style="width:114px;height:15px;"
									                   onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'startDate\')}'})"
									                   id="endDate"
									                   value="<fmt:formatDate value="${ds.endDate}" pattern="yyyy-MM-dd"/>"
									                   maxlength="19">
												</td>
												<td>&nbsp;</td>
												<td >
													<div class="subBar">
														<ul>
															<li><div class="buttonActive"><div class="buttonContent"><button type="submit">查询</button></div></div></li>
															<li><div class="buttonActive"><div class="buttonContent"><button type="button" onclick="resetSysLogQuery()">重置</button></div></div></li>
														</ul>
													</div>
												</td>
											</tr>
										</table>
									</form>	
								</div>
							</div> --%>
							
							<%-- <div class="pageContent">
								<div class="panelBar">
									<ul class="toolBar">
										<li><span>待办事项：</span></li>
										<li><span>待审核项目(<font color="red">${projectNotAudit.total }</font>)</span></li>
										<li><span>待打款(<font color="red">${unPayMoney.total}</font>)</span></li>
										<li><span>善管家审核(<font color="red">${loveGroupNotAudit.total }</font>)</span></li>
										<li><span>实名认证(<font color="red">${helpPeopleNotAudit.total }</font>)</span></li>
										<li><span>企业认证(<font color="red">${companyNotAudit.total }</font>)</span></li>
									</ul>
								</div>
								<table class="table" width="100%" layoutH="171">
									<thead>
										<tr>
											<th width="30">序号</th>
											<th width="80">日期</th>
											<th width="50">项目上线数</th>
											<th width="80">需要善款</th>
											<th width="80">已筹善款</th>
											<th width="80">已打款金额</th>
											<th width="50">成功项目数</th>
											<th width="60">总访问量</th>
											<th width="50">总捐款笔数</th>
											<th width=50">新注册人数</th>
											<th width="50">新捐款人数</th>
											<th width="80">匿名捐款人数</th>
											<th width="50">补单次数</th>
											<th width="50">总捐款人数</th>
											<th width="50">数据来源</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach  items="${list}" var="datas"  varStatus="status">
											<tr target="list_item_id" rel="${ds.id }">
												<td>${status.count}</td>
												<td><fmt:formatDate value="${datas.createTime}" pattern="yyyy-MM-dd"/></td>
												<td >${datas.newProjectNum}</td>
												<td ><fmt:formatNumber type="number" maxFractionDigits="3" value="${datas.needMoney}"/></td>
												<td ><fmt:formatNumber type="number" maxFractionDigits="3" value="${datas.donatedMoney}"/></td>
												<td ><fmt:formatNumber type="number" maxFractionDigits="3" value="${datas.payedMoney }"/></td>
												<td >${datas.successProjectNum}</td>
												<td >${datas.pageView}</td>
												<td >${datas.totalDonationNum}</td>
												<td >${datas.newRegisterNum}</td>
												<td >${datas.newDonationNum }</td>
												<td >${datas.nickDonationNum }</td>
												<td >${datas.reorder }</td>
												<td >${datas.donationPeopleNum }</td>
												<td >${datas.source }</td>
											</tr>
										</c:forEach>
										<tr>
											<td>合计</td>
											<td></td>
											<td>${tds.totalNewProjectNum }</td>
											<td><fmt:formatNumber type="number" maxFractionDigits="3" value="${tds.totalNeedMoney }"/></td>
											<td><fmt:formatNumber type="number" maxFractionDigits="3" value="${tds.totalDonatedMoney }"/></td>
											<td><fmt:formatNumber type="number" maxFractionDigits="3" value="${tds.totalPayedMoney }"/></td>
											<td>${tds.totalSuccessProjectNum }</td>
											<td>${tds.totalPageView }</td>
											<td>${tds.totalDonationNum }</td>
											<td>${tds.totalNewRegisterNum }</td>
											<td>${tds.totalNewDonationNum }</td>
											<td>${tds.totalNickDonationNum }</td>
											<td>${tds.totalReorderNum }</td>
											<td>${tds.totalDonationPeopleNum }</td>
											<td></td>
										</tr>
									</tbody>
								</table>
								<c:import url="common/panelBar.jsp" />
							</div> --%>
						</div>
					</div>
				</div>
			</div>
		</div>
		
	</div>

	<%@ include file="common/footer.jsp"%>

</body>
</html>