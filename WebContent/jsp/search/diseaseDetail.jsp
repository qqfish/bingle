<!DOCTYPE html>
<%@ page language="java" %>
<%@ page import="baseUse.searchData.DiseaseDetailInfo"%>
<%@ page import="baseUse.searchData.UserShortInfo"%>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html;charset=gb2312">
	<title>Disease Detail Result</title>

	<link rel="stylesheet" href="/bingle/css/diseaseDetail.css" type="text/css" />

	<!--[if IE]>
	 <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
<!--[if lte IE 7]>
	 <script src="../js/IE8.js" type="text/javascript"></script><![endif]-->

<!--[if lt IE 7]>
	 <link rel="stylesheet" type="text/css" media="all" href="../css/ie6.css"/><![endif]-->
	</head>

	<body id="index" class="home">
		<header id="banner" class="body">
			<h1><a href="index.jsp"><img src="img/logo.jpg"/></a></h1>
						
			<nav>
				<ul>
					<li><a href="/bingle/SearchControlServlet?searchType=patients">病友</a></li>
					<li class="active"><a href="/bingle/SearchControlServlet?searchType=diseases">病症</a></li>
					<li><a href="ForumControlServlet?func=ini">交流区</a></li>
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
			<header>
				<h3 id="resultTitle">病症信息</h3>
			</header>
			<div class="information">
				<table class="Info">
					<tr class="alt">
						<td class="left">病症名:</td>
						<td class="right">${result.diseaseName}</td>
					</tr>
					<tr>
						<td class="left">病症介绍:</td>
						<td class="right">${result.diseaseIntro}</td>
					</tr>
					<tr class="alt">
						<td class="left">本资料最近更新时间:</td>
						<td class="right">${result.editTime}</td>
					</tr>
					<tr>
						<td id="update" colspan="2"><a href="#">我要更新资料</a></td>
					</tr>
				</table>
				<br/>
				<table id="relation">
					<th class="alt">推荐病友</th>
					<% 
					DiseaseDetailInfo result = (DiseaseDetailInfo) request.getAttribute("result");
					for (int i=0;(i<result.getUserOfThis().size())&&(i<10);i++)
					{
						out.println("<tr><td><a href=\"SearchControlServlet?username="+result.getUserOfThis().get(i).getUsername()+"\">"+result.getUserOfThis().get(i).getUsername()+"</a></td></tr>");
					}
					%>
				</table>
			</div>
		</section>
		<footer id="about" class="body">
			<p>blablabla</p>
		</footer>
	</body>
</html>
