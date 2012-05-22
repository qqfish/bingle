<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>

<html lang="en">
	<head>
	<meta charset="gbk" />
	<title>Forum List</title>

	<link rel="stylesheet" href="/bingle/css/forumList.css" type="text/css" />

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
					<a href="#">病友论坛</a>
				</div>
			</header>
			
			
			<div id="selection">
				<table>
					<th>论坛列表</th>
					<tr>
						<td class="list"><img src="/bingle/img/list.jpg"/></td>
						<td class="textList"><a href="ForumControlServlet?func=topicList&topic=${fl.forumList[0].topicListName}">${fl.forumList[0].topicListName}</a>
						<br/>${fl.forumList[0].topicListName}</td>
						<td class="tags">
							<a href="#">${fl.forumList[0].tagName[0]}</a>,
							<a href="#">标签</a>,
							<a href="#">标签</a>
						</td>
						<td class="list"><img src="/bingle/img/list.jpg"/></td>
						<td class="textList"><a href="#">感冒</a><br/>感冒了</td>
						<td class="tags">
							<a href="#">标签</a>,
							<a href="#">标签</a>,
							<a href="#">标签</a>
						</td>
					</tr>
					<tr>
						<td class="list"><img src="/bingle/img/list.jpg"/></td>
						<td class="textList"><a href="ForumControlServlet">感冒</a><br/>感冒了</td>
						<td class="tags">
							<a href="#">标签</a>,
							<a href="#">标签</a>,
							<a href="#">标签</a>
						</td>
						<td class="list"><img src="/bingle/img/list.jpg"/></td>
						<td class="textList"><a href="#">感冒了</a><br/>感冒了</td>
						<td class="tags">
							<a href="#">标签</a>,
							<a href="#">标签</a>,
							<a href="#">标签</a>
						</td>
					</tr>
				</table>
			</div>
		</section>
		
		<footer id="about" class="body">
			<p>blablabla</p>
		</footer>
	</body>
</html>
