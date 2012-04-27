<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html;charset=gb2312">
	<title>个人资料</title>

	<link rel="stylesheet" href="css/selfInfo.css" type="text/css" />
	<script type="text/javascript" src="script/inNav.js"></script>
	<!--[if IE]>
	 <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
	<!--[if lte IE 7]>
	 <script src="../js/IE8.js" type="text/javascript"></script><![endif]-->

	<!--[if lt IE 7]>
	 <link rel="stylesheet" type="text/css" media="all" href="../css/ie6.css"/><![endif]-->
	</head>

	<body id="index" class="home" onload="init();">
		<header id="banner" class="body">
			<h1><img src="/bingle/img/logo.jpg"/></h1>
						
			<nav>
				<ul>
					<li><a href="search.htm">病友</a></li>
					<li><a href="search.htm">病症</a></li>
					<li><a href="ForumControlServlet?func=ini">交流区</a></li>
					<li class="active"><a href="#">控制面板</a></li>
				</ul>
				<form action="#" id="search" method="get">
					<input type="search" id="search_word" placeholder="Search this site">
					<input type="submit" value="查找病友" class="search-btn" name="subBtn">
					<input type="submit" value="查找病症" class="search-btn" name="subBtn">
				</form>
			</nav>
		</header>
		
		<nav id="infoNav" class="body" onmouseover='nowMouse="on";move();' onmouseout='nowMouse="off";move();' >
			<ul>
				<li><a href="#" class="active">基本资料</a></li>
				<li><a href="#">个人状态</a></li>
				<li><a href="#">疾病情况</a></li>
				<li><a href="#">治疗过程</a></li>
				<li><a href="#">管理标签</a></li>
			</ul>
		</nav>
		
		<section id="container" class="body">
			<h3>基本资料</h3>
			<table>
				<tr>
					<th>用户名</th>
					<td>${udi.username}</td>
				</tr>
				<tr>
					<th>用户群</th>
					<td>${udi.groupname}</td>
				</tr>
				<tr>
					<th>年龄</th>
					<td>${udi.age}</td>
				</tr>
				<tr>
					<th>性别</th>
					<td>${udi.gender?"女":"男"}</td>
				</tr>
				<tr>
					<th>email</th>
					<td>${udi.email}</td>
				</tr>
				<tr>
					<th>现有疾病</th>
					<td>${udi.userDiseaseInfo[0].diseaseName }</td>
				</tr>	
				<tr>
					<th>身体状况</th>
					<td><canvas></canvas></td>
				</tr>
				<tr>
					<th>心理状况</th>
					<td><canvas></canvas></td>
				</tr>
			</table>
		</section>
		
		<footer id="about" class="body">
			<p>blablabla</p>
		</footer>
		
	</body>