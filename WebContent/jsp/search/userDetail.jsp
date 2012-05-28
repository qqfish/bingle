<!DOCTYPE html>
<%@ page language="java"%>
<%@ page import="baseUse.searchData.UserDetailInfo"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=gb2312">
<title>User Detail Result</title>

<link rel="stylesheet" href="/bingle/css/userDetailResult.css" type="text/css" />

<!--[if IE]>
	 <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
<!--[if lte IE 7]>
	 <script src="../js/IE8.js" type="text/javascript"></script><![endif]-->

<!--[if lt IE 7]>
	 <link rel="stylesheet" type="text/css" media="all" href="../css/ie6.css"/><![endif]-->
</head>

<body id="index" class="home">
	<header id="banner" class="body">
		<h1>
			<a href="index.jsp"><img src="/bingle/img/logo.jpg" /></a>
		</h1>
		<nav>
			<ul>
				<li class="active"><a href="/bingle/SearchControlServlet?searchType=patients">病友</a></li>
				<li><a href="/bingle/SearchControlServlet?searchType=diseases">病症</a></li>
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
			<h3 id="resultTitle">病友信息</h3>
		</header>
		<div class="information">
			<table class="selfInfo">
				<th class="title" colspan="2">病友个人信息</th>
				<tr class="alt">
					<td class="left">用户名:</td>
					<td class="right">${result.username}</td>
				</tr>
				<tr>
					<td class="left">年龄:</td>
					<td class="right">${result.age }</td>
				</tr>
				<tr class="alt">
					<td class="left">地址:</td>
					<td class="right">${result.address }</td>
				</tr>
				<tr>
					<td class="left">e-mail:</td>
					<td class="right">${result.email }</td>
				</tr>
				<tr class="alt">
					<td class="left">标签:</td>
					<td class="right">${tag }</td>
				</tr>
			</table>
			<br /> <br />
			<% 
			UserDetailInfo result = (UserDetailInfo) request.getAttribute("result");
			for(int i = 0; i < result.getUserDiseaseInfo().size(); i++){ 
			%>
				<table class="diseaseInfo">
					<th class="title" colspan="2">所患病症相关信息</th>
					<tr class="alt">
						<td class="left">病名:</td>
						<td class="right"><%=result.getUserDiseaseInfo().get(i).getDiseaseName() %></td>
					</tr>
					<tr>
						<td class="left">治疗情况:</td>
						<td class="right"><%=result.getUserDiseaseInfo().get(i).getTreatmentIntro()%></td>
					</tr>
					<tr class="alt">
						<td class="left">得病原因:</td>
						<td class="right"><%=result.getUserDiseaseInfo().get(i).getReason()%></td>
					</tr>
					<tr>
						<td class="left">Tips:</td>
						<td class="right"><%=result.getUserDiseaseInfo().get(i).getTips()%></td>
					</tr>
					<tr class="alt">
						<td class="left">所用药物:</td>
						<td class="right"><%for(int j = 0; j < result.getUserDiseaseInfo().get(i).getDrugName().size(); j++){ %>
							<div class="tag"><%=result.getUserDiseaseInfo().get(i).getDrugName().get(j) %></div>
						
						<%} %>
						</td>
					</tr>
				</table>
				<br />
				<br />
			<%} %>
		</div>
	</section>

	<footer id="about" class="body">
		<p>blablabla</p>
	</footer>

</body>
</html>
