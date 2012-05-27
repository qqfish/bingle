<!DOCTYPE html>
<%@ page language="java"%>
<%@ page import="baseUse.searchData.UserDetailInfo"%>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html;charset=gb2312">
	<title>User Detail Result</title>

	<link rel="stylesheet" href="/bingle/css/userDetailResult.css" type="text/css" />
	<script type="text/javascript" src="/bingle/script/accordian.pack.js"></script>

	<!--[if IE]>
	 <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
	<!--[if lte IE 7]>
	 <script src="../js/IE8.js" type="text/javascript"></script><![endif]-->

	<!--[if lt IE 7]>
	 <link rel="stylesheet" type="text/css" media="all" href="../css/ie6.css"/><![endif]-->
	</head>

	<body id="index" class="home" onload="new Accordian('basic-accordian',5,'header_highlight');">
		<header id="banner" class="body">
			<h1><img src="/bingle/img/logo.jpg"/></h1>
						
			<nav>
				<ul>
					<%
						if(!request.getSession().getAttribute("login").equals("1")){
							out.println("<li><a href='/bingle/'>首页</a></li>");
						}
					%>
					<li class='active'><a href="/bingle/SearchControlServlet?searchType=patients">病友</a></li>
					<li><a href="/bingle/SearchControlServlet?searchType=diseases">病症</a></li>
					<li><a href="/bingle/ForumControlServlet?func=ini">交流区</a></li>
					<% if(request.getSession().getAttribute("login").equals("1")){
						out.println("<li><a href='jsp/info/selfInfo.jsp'>控制面板</a></li>");
						out.println("<li><a href='/bingle/LogoutControlServlet'>注销登录</a></li>");
					}
					%>
				</ul>
				<form action="#" id="search" method="get">
					<input type="search" id="search_word" placeholder="Search this site">
					<input type="submit" value="查找病友" class="search-btn" name="subBtn">
					<input type="submit" value="查找病症" class="search-btn" name="subBtn">
				</form>
			</nav>
		</header>
		<section id="container" class="body">
			<div id="basic-accordian" >



			  <div id="test-header" class="accordion_headings header_highlight" >基本资料</div>
			  

			  
			  <div id="test-content">
			  

				<div class="accordion_child">
					<table class="info">
						<tr>
							<td>用户名:</td>
							<td>${result.username }</td>
						</tr>
						<tr>
							<td>地址</td>
							<td>${result.address }</td>
						</tr>
						<tr>
							<td>年龄:</td>
							<td>${result.age }</td>
						</tr>
						<tr>
							<td>e-mail:</td>
							<td>${result.email }</td>
						</tr>
						<tr>
							<td>标签:</td>
							<td>${tag }</td>
						</tr>
					</table>
				</div>
				
			  </div>



			  <div id="test1-header" class="accordion_headings" >状况表</div>
			  

			  
			  <div id="test1-content">
			  

				<div class="accordion_child">
					<img src="img/list.jpg"/>
				</div>
				
			  </div>

			  <div id="test2-header" class="accordion_headings" >所患病症</div>
			  

			  
			  <div id="test2-content">
			  

				<div class="accordion_child">
					<table class="disease">
						<th style="width:10%;">病症名</th>
						<th style="width:40%;">治疗情况</th>
						<th>病因</th>
						<th style="width:40%;">个人建议</th>
						<th>所用药物</th>
						<% 
						UserDetailInfo result = (UserDetailInfo) request.getAttribute("result");
						for(int i = 0; i < result.getUserDiseaseInfo().size(); i++){ 
						%>
						<tr>
							<td><%=result.getUserDiseaseInfo().get(i).getDiseaseName() %></td>
							<td><%=result.getUserDiseaseInfo().get(i).getTreatmentIntro() %></td>
							<td><%=result.getUserDiseaseInfo().get(i).getReason() %></td>
							<td><%=result.getUserDiseaseInfo().get(i).getTips() %></td>
							<td>
								<%
									for(int j = 0; j < result.getUserDiseaseInfo().get(i).getDrugName().size(); j++){
								%>
									<div class="tag"><%=result.getUserDiseaseInfo().get(i).getDrugName().get(j) %></div>
								<%} %>
							</td>
						</tr>
						<%} %>
					</table>
				</div>
				
			  </div>
			  
			</div>
		</section>
		
		<footer id="about" class="body">
			<p>blablabla</p>
		</footer>
		
	</body>
</html>
						