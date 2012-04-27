<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>

<html lang="en">
	<head>
	<meta charset="gkb" />
	<title>Reply</title>

	<link rel="stylesheet" href="/bingle/css/reply.css" type="text/css" />

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
					<li><a href="search.jsp">病友</a></li>
					<li><a href="search.jsp">病症</a></li>
					<li class="active"><a href="forum.jsp">交流区</a></li>
				</ul>
				<form action="#" id="search" method="get">
					<input type="search" id="search_word" placeholder="Search this site">
					<input type="submit" value="查找病友" class="search-btn" name="subBtn">
					<input type="submit" value="查找病症" class="search-btn" name="subBtn">
				</form>
			</nav>
		</header>
		<section id="container" class="body">
			<header class="forumHead">
				<div class="forumTitle">
					<a href="index.jsp">病了么</a>
					 - 
					<a href="#">病友论坛</a>
					 -
					<a href="#">${listname}</a>
					 -
					<a href="#">${name}</a>
					 -
					<a href="#">回复</a>
				</div>
			</header>
			<div id="textArea">
				<form action="ForumControlServlet">
					<p>RE:${name}<p><hr>
					<textarea cols="100" rows="10" name="content"></textarea><br/>
					<input class="button" type="submit" value="回复主题">
					<input class="button" type="reset" value="重置内容">
					<input type="hidden" name="func" value="newreply">
					<input type="hidden" name="id" value="${id}">
					<input type="hidden" name="user" value="${user}">
					<input type="hidden" name="url" value = "${lpb.url}">
				</form>
			</div>
		</section>
		<footer id="about" class="body">
			<p>blablabla</p>
		</footer>
	</body>
</html>