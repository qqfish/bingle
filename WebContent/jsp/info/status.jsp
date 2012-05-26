<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html;charset=gb2312">
	<title>个人资料</title>

	<link rel="stylesheet" href="/bingle/css/selfInfo.css" type="text/css" />
	<script type="text/javascript" src="/bingle/script/inNav.js"></script>
	<script type="text/javascript" src="/bingle/script/RGraph/RGraph.common.core.js" ></script>
	<script type="text/javascript" src="/bingle/script/RGraph/RGraph.line.js" ></script>
	<script type="text/javascript" src="/bingle/script/draw.js"></script>
	
	<!--[if IE]>
	 <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
	<!--[if lte IE 7]>
	 <script src="../js/IE8.js" type="text/javascript"></script><![endif]-->

	<!--[if lt IE 7]>
	 <link rel="stylesheet" type="text/css" media="all" href="../css/ie6.css"/><![endif]-->
	</head>

	<body id="index" class="home" onload="init();drawBody(${udi.bodyStatus });drawMind(${udi.mindStatus });">
		<header id="banner" class="body">
			<h1><img src="/bingle/img/logo.jpg"/></h1>
						
			<nav>
				<ul>
					<li><a href="/bingle/SearchControlServlet?searchType=patients">病友</a></li>
					<li><a href="/bingle/SearchControlServlet?searchType=diseases">病症</a></li>
					<li><a href="ForumControlServlet?func=ini">交流区</a></li>
					<% if(request.getSession().getAttribute("login").equals("1"))
						out.println("<li class='active'><a href='jsp/info/selfInfo.jsp'>控制面板</a></li>");
					%>
				</ul>
				<form action="/bingle/SearchControlServlet" id="search" method="get">
				<input type="search" name="keyword" placeholder="Search this site">
				<input type="submit" value="patients" class="search-btn" name="searchType">
				<input type="submit" value="diseases" class="search-btn" name="searchType">
			</form>
			</nav>
		</header>
		
		<nav id="infoNav" class="body" onmouseover='nowMouse="on";move();' onmouseout='nowMouse="off";move();' >
			<ul>
				<li><a href="/bingle/jsp/info/selfInfo.jsp">基本资料</a></li>
				<li><a href="/bingle/jsp/info/status.jsp" class="active">个人状态</a></li>
				<li><a href="/bingle/UpdateInfoControlServlet?type=disease">疾病情况</a></li>
				<li><a href="/bingle/UpdateInfoControlServlet?type=normalTag">管理标签</a></li>
			</ul>
		</nav>
		
		<section id="container" class="body">
			<table>
				<tr>
					<th>身体状况</th>
					<td><canvas id="body"></canvas></td>
				</tr>
				<tr>
					<th>心理状况</th>
					<td><canvas id="mind"></canvas></td>
				</tr>
			</table>
  </body>
</html>
