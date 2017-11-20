<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>管理后台</title>
<link href="/ui/themes/css/login.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<div id="login">
		<div id="login_header">
			<h1 class="login_logo">
				<!-- <img src="../../../ui/themes/default/images/login_logo.gif" /> -->
				<img src="/res/images/logo.png" />
			</h1>
			<div class="login_headerContent">
				<div class="navList">
					<ul>
					</ul>
				</div>
				<h2 class="login_title"></h2>
			</div>
			
		</div>
		<div id="login_content">
		
			<div class="loginForm">
			<div ><img src="/ui/themes/default/images/login_title.png" /></div>
				<div>
				<form action="/adminlogin" method="post"  class="pageForm req../../../uired-validate">
					<br />
					<br/>
					<br/>
					<p>
						<label>用户名：</label>
						<input type="text" name="username" size="20" class="login_input"/>
					</p>
					<p>
						<label>密码：</label>
						<input type="password" name="password" size="20" class="login_input" />
					</p>
						 
					<!-- <p>
						<label>验证码：</label>
						<input type="text" name="rand" style=" width:70px" height="15" />
						&nbsp<img src="common/RandomNum.jsp" width="50" height="20" onclick="this.src='common/RandomNum.jsp?t='+new Date();"/>
					</p> -->
						
					<p>
						<span style="color: red">${msg}</span>
					</p>
					<div class="login_bar">
						<input class="sub" type="submit" value=""/>
					</div>
				</form>
				</div>
			</div>
			<div class="login_banner"><!-- <img src="../../../ui/themes/default/images/login_banner.jpg"/> --><img src="/res/images/1.png" width="630px" height="230px"/></div>
			<!-- <div class="login_main">
				<ul class="helpList">
					<li><a href="#"></a></li>
					<li><a href="#"></a></li>
					<li><a href="#"></a></li>
					<li><a href="#"></a></li>
				</ul>
				<div class="login_inner">
					<p></p>
					<p></p>
					<p></p>
				</div>
			</div> -->
		</div>
		<div id="login_footer">
			Copyright &copy; 2017 . All Rights Reserved.
		</div>
	</div>
</body>
</html>