<%@ page language="java" import="java.util.*" import="java.sql.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <base href="<%=basePath%>">
    
    <title>病了么</title>
    <meta charset="gkb" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/main.css">
	
	<!--[if IE]>
	 <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
	<!--[if lte IE 7]>
	 <script src="js/IE8.js" type="text/javascript"></script><![endif]-->

	<!--[if lt IE 7]>
	 <link rel="stylesheet" type="text/css" media="all" href="css/ie6.css"/><![endif]-->
	 
	 <script src="script/check.js" charset="utf-8"></script>
  </head>
  
  <body id="index" class="home">
  	<header id="banner" class="body">
		<h1><img src="img/logo.jpg"/></h1>
						
		<nav>
			<ul>
				<li><a href="/bingle/SearchControlServlet?searchType=patients">病友</a></li>
				<li><a href="/bingle/SearchControlServlet?searchType=diseases">病症</a></li>
				<li><a href="ForumControlServlet?func=ini">交流区</a></li>
			</ul>
			<form action="/bingle/SearchControlServlet" id="search" method="get">
				<input type="search" name="keyword" placeholder="Search this site">
				<input type="submit" value="patients" class="search-btn" name="searchType">
				<input type="submit" value="diseases" class="search-btn" name="searchType">
			</form>
		</nav>
	</header>
	<section id="container" class="body">
		<section id="login" class="body">
			<form action="LoginControlServlet" method="post">
				<fieldset>
					<legend>登陆：</legend>
					<ol>
						<li>
							<label>用户名：<input type="text" name="userName"/></label>
						</li>
						<li>
							<label>密码：<input type="password" name="password"/></label>
						</li>
						<br>
						<li>
							<label><input type="submit" value="登陆" /></label>
						</li>
					</ol>
				</fieldset>
			</form>
		</section>
		<section id="main">
			<img src="img/logo.jpg"/>
			<section id="register" class="body">
				<form action="RegisterControlServlet" method="post" onsubmit="return check();">
					<ol>
						<li>
							<label>用户名称:<input type="text" id="username" name="username" class="inBox" placeholder="begin with a letter and of 6-16 characters " pattern="^[a-zA-Z][a-zA-Z0-9_]{5,15}$" onblur="checkUsername();"/>
							<span id="usernameMsg"></span></label>
						</li>
						<li>
							<label>输入密码:<input type="password" id="password1" name="password" class="inBox" placeholder="at least 6 character" onblur="validPassword();"/>
							<span id="passwordMsg1"></span></label>
						</li>
						<li>
							<label>确认密码:<input type="password" id="password2" class="inBox" placeholder="type your password" onblur="checkPassword();"/>
							<span id="passwordMsg2"></span></label>
						</li>
						<li>
							<label>邮件地址:<input type="email" id="email" name="email" class="inBox" placeholder="user@example.com" onblur="checkEmail();"/>
							<span id="emailMsg"></span></label>
						</li>
						<hr><br>
						<li>
							<label>性别:
								<input type="radio" name="gender"/>男
								<input type="radio" name="gender"/>女
							</label>
						</li>
						<li>
							<label>年龄:<input type="number" name="age" class="inBox" min="0" max="150"></label>
						</li>
						<br>
						<li>
							<label><input type="submit" class="regButton" value="立即注册"/></label>
						</li>
						</ol>
				</form>
			</section>
			<aside id="feature">
				<p>还在为病痛而烦恼吗？</p>
				<p>快加入<span>病了么</span>。</p>
				<ul>
					<li>全面病症资料</li><li>详细治疗经验</li><li>大量热心病友</li>
				</ul>
				<p>陪伴你共度难关。</p>
				<p>你将不再会是一个人在战斗！</p>
			</aside>
		</section>
	</section>
		
	<footer id="about" class="body">
		<p>blablabla</p>
	</footer>
  </body>
</html>
