<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<%@ page language="java" %>

<html lang="en">
	<head>
	<meta charset="gkb" />
	<title>Post</title>

	<link rel="stylesheet" href="/bingle/css/post.css" type="text/css" />

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
					<a href="#">病友论坛</a>
					 -
					<a href="#">感冒</a>
					 -
					<a href="#">发表帖子</a>
				</div>
			</header>
			<div id="textArea">
				<form action="/bingle/ForumControlServlet" method="post">
					<p>发表帖子<p><hr>
					<input id="tittle" type="text" name="tittle"/><br/>
					<textarea cols="100" rows="10" name="content"></textarea><br/>
					<input class="button" type="submit" value="发表帖子">
					<input class="button" type="reset" value="重置内容">
					<input type="hidden" name="func" value="newtopic">
					<input type="hidden" name="user" value="${user}">
					<input type="hidden" name="list" value="${list}">
					<input type="hidden" name="url" value="${lpb.url}">
				</form>
			</div>
		</section>
		<footer id="about" class="body">
			<p>blablabla</p>
		</footer>
	</body>
</html>