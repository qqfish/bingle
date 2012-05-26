<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
	<head>
	<meta charset="gkb" />
	<title>Work Done</title>

	<link rel="stylesheet" href="/bingle/css/workDone.css" type="text/css" />

	<!--[if IE]>
	 <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
	<!--[if lte IE 7]>
	 <script src="js/IE8.js" type="text/javascript"></script><![endif]-->

	<!--[if lt IE 7]>
	 <link rel="stylesheet" type="text/css" media="all" href="css/ie6.css"/><![endif]-->
	</head>

	<body id="index" class="home">
		<header id="banner" class="body">
			<h1><a href="index.jsp"><img src="/bingle/img/logo.jpg"/></a></h1>
						
			<nav>
				<ul>
					<li><a href="/bingle/SearchControlServlet?searchType=patients">病友</a></li>
				<li><a href="/bingle/SearchControlServlet?searchType=diseases">病症</a></li>
					<li class="active"><a href="ForumControlServlet?func=ini">交流区</a></li>
					<% if(request.getSession().getAttribute("login").equals("1"))
						out.println("<li><a href='jsp/info/selfInfo.jsp'>控制面板</a></li>");
					%>
				</ul>
				<form action="/bingle/SearchControlServlet" id="search" method="get">
				<input type="search" name="keyword" placeholder="Search this site">
				<input type="submit" value="patients" class="search-btn" name="searchType">
				<input type="submit" value="diseases" class="search-btn" name="searchType">
			</form>
			</nav>
		</header>
		<section id="container" class="body">
			<header class="forumHead">
				<div class="forumTitle">
					<a href="index.jsp">病了么</a>
					 - 
					<a href="ForumControlServlet?func=ini">病友论坛</a>
				</div>
			</header>
			<article id="work">
				<br>
				操作成功,5秒后自动返回
				<br>
				<br>
				<br>
				<%
					String url = request.getParameter("url");
					response.setHeader("refresh","5;URL="+url);
					out.println("<a href=\""+url+"\">手动点击返回</a>");
				%>
			</article>
		</section>
		<footer id="about" class="body">
			<p>blablabla</p>
		</footer>
	</body>
</html>