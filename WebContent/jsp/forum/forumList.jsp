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

	<link rel="stylesheet" href="../../css/forumList.css" type="text/css" />

	<!--[if IE]>
	 <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
	<!--[if lte IE 7]>
	 <script src="js/IE8.js" type="text/javascript"></script><![endif]-->

	<!--[if lt IE 7]>
	 <link rel="stylesheet" type="text/css" media="all" href="css/ie6.css"/><![endif]-->
	</head>

	<body id="index" class="home">
		<header id="banner" class="body">
			<h1><a href="index.jsp"><img src="../../img/logo.jpg"/></a></h1>
						
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
				</div>
			</header>
			<div id="selection">
				<table>
					<th>论坛列表</th>
					<tr>
						<td class="list"><img src="../../img/list.jpg"/></td>
						<td class="textList"><a href="#">感冒</a><br/>交流有关感冒相关信息</td>
						<td class="tags">
							<a href="#">标签</a>,
							<a href="#">标签</a>,
							<a href="#">标签</a>
						</td>
						<td class="list"><img src="../../img/list.jpg"/></td>
						<td class="textList"><a href="#">心脑血管疾病</a><br/>交流有关心脑血管疾病相关信息</td>
						<td class="tags">
							<a href="#">标签</a>,
							<a href="#">标签</a>,
							<a href="#">标签</a>
						</td>
					</tr>
					<tr>
						<td class="list"><img src="../../img/list.jpg"/></td>
						<td class="textList"><a href="ForumControlServlet">头痛</a><br/>交流有关头痛相关信息</td>
						<td class="tags">
							<a href="#">标签</a>,
							<a href="#">标签</a>,
							<a href="#">标签</a>
						</td>
						<td class="list"><img src="../../img/list.jpg"/></td>
						<td class="textList"><a href="#">胃病</a><br/>交流有关胃病相关信息</td>
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