<%@ page language="java" import="java.util.*,baseUse.forumData.ForumList" pageEncoding="GBK"%>
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
			<h1><img src="/bingle/img/logo.jpg"/></h1>
						
			<nav>
				<ul>
					<%
						if(!request.getSession().getAttribute("login").equals("1")){
							out.println("<li><a href='/bingle/'>��ҳ</a></li>");
						}
					%>
					<li><a href="/bingle/SearchControlServlet?searchType=patients">����</a></li>
					<li><a href="/bingle/SearchControlServlet?searchType=diseases">��֢</a></li>
					<li class="active"><a href="/bingle/ForumControlServlet?func=ini">������</a></li>
					<% if(request.getSession().getAttribute("login").equals("1")){
						out.println("<li><a href='jsp/info/selfInfo.jsp'>�������</a></li>");
						out.println("<li><a href='/bingle/LogoutControlServlet'>ע����¼</a></li>");
					}
					%>
				</ul>
				<form action="/bingle/SearchControlServlet" id="search" method="get">
				<input type="search" name="keyword" placeholder="Search this site">
				<input type="submit" value="patients" class="search-btn" name="searchType">
				<input type="submit" value="diseases" class="search-btn" name="searchType">
			</form>
			</nav>
		</header>
		<%
		ForumList fl = (ForumList) request.getSession().getAttribute("fl");
		
		 %>
		<section id="container" class="body">
			<header class="forumHead">
				<div class="forumTitle">
					<a href="index.jsp">����ô</a>
					 - 
					<a href="#">������̳</a>
				</div>
			</header>
			<div id="selection">
				<table>
					<tr></tr>
					<th>��̳�б�</th>
					${table}
				</table>
			</div>
		</section>
		
		<footer id="about" class="body">
			<p>blablabla</p>
		</footer>
	</body>
</html>
