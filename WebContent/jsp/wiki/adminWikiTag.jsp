<%@page pageEncoding="utf-8"%>
<%@ page language="java"%>
<%@ page import="baseUse.wikiData.TagDataList"%>
<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
	<title>管理更新病症</title>

	<link rel="stylesheet" href="/bingle/css/search.css" type="text/css" />

	<!--[if IE]>
	 <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
	<!--[if lte IE 7]>
	 <script src="../js/IE8.js" type="text/javascript"></script><![endif]-->

	<!--[if lt IE 7]>
	 <link rel="stylesheet" type="text/css" media="all" href="../css/ie6.css"/><![endif]-->
	</head>

	<body id="index" class="home">
		<header id="banner" class="body">
			<h1><img src="/bingle/img/logo.jpg"/></h1>
						
			<nav>
				<ul>
					<li><a href="/bingle/SearchControlServlet?searchType=patients">病友</a></li>
					<li><a href="/bingle/SearchControlServlet?searchType=diseases">病症</a></li>
					<li><a href="ForumControlServlet?func=ini">交流区</a></li>
					<li><a href="/bingle/adminDiseaseAndTag?type=disease">管理病症</a></li>
					<li class="active"><a href="/bingle/adminDiseaseAndTag?type=tag">管理标签</a></li>
				</ul>
				<form action="/bingle/SearchControlServlet" id="search" method="get">
				<input type="search" name="keyword" placeholder="Search this site">
				<input type="submit" value="patients" class="search-btn" name="searchType">
				<input type="submit" value="diseases" class="search-btn" name="searchType">
			</form>
			</nav>
		</header>
		<section id="container" class="body">
			<header id="search-list-header">
			</header>
			<table id="search-list-context" >
				<thead>
					<tr>
						<th>采用</th>
						<th>标签名称</th>
						<th>标签介绍</th>
						<th>标签替代名</th>
					</tr>
				</thead>
				<form action="SubmitWikiControlServlet" method="post">
					<tbody>
					<% 
					TagDataList result = (TagDataList) request.getAttribute("result");
					if(result == null){
					%>
						<tr class="search-result">
							<td></td>
							<td>没有结果</td>
							<td></td>
							<td></td>
						</tr>
					<%
					}
					else{
						for(int i = 0; i < result.getTag().size(); i++){ 
					%>
						<tr class="search-result">
							<td><input type="checkbox" name="submitTag" value="<%=i %>"></td>
							<td><a><%=result.getTag().get(i).getTagname() %></a></td>
							<td><a><%=result.getTag().get(i).getTagIntro() %></a></td>
							<td>
								<%for(int j = 0; j < result.getTag().get(i).getAlterName().size(); j++){ %>
								<div class="tag"><%=result.getTag().get(i).getAlterName().get(j).getAlternateName() %></div></td>
								<%} %>
						</tr>
					<%}} %>	
					</tbody>
					<tfoot>
						<tr>
							<td><input type="submit" value="提交"></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
					</tfoot>
				</form>
			</table>			
		</section>
		
		<footer id="about" class="body">
			<p>blablabla</p>
		</footer>
		
	</body>
</html>
