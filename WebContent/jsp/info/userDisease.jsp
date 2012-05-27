<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="baseUse.searchData.UserDetailInfo"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html;charset=gb2312">
	<title>disease</title>

	<link rel="stylesheet" href="/bingle/css/userDisease.css" type="text/css" />
	<script type="text/javascript" src="/bingle/script/accordian.pack.js"></script>
	<script type="text/javascript" src="/bingle/script/inNav.js"></script>
	
	<!--[if IE]>
	 <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
	<!--[if lte IE 7]>
	 <script src="../js/IE8.js" type="text/javascript"></script><![endif]-->

	<!--[if lt IE 7]>
	 <link rel="stylesheet" type="text/css" media="all" href="../css/ie6.css"/><![endif]-->
	</head>

	<body id="index" class="home" onload="init();new Accordian('basic-accordian',5,'header_highlight');">
		<header id="banner" class="body">
			<h1><img src="/bingle/img/logo.jpg"/></h1>
			<nav>
				<ul>
					<%
						if(!request.getSession().getAttribute("login").equals("1")){
							out.println("<li><a href='/bingle/'>首页</a></li>");
						}
					%>
					<li><a href="/bingle/SearchControlServlet?searchType=patients">病友</a></li>
					<li><a href="/bingle/SearchControlServlet?searchType=diseases">病症</a></li>
					<li><a href="ForumControlServlet?func=ini">交流区</a></li>
					<% if(request.getSession().getAttribute("login").equals("1")){
						out.println("<li class='active'><a href='jsp/info/selfInfo.jsp'>控制面板</a></li>");
						out.println("<li><a href='/bingle/LogoutControlServlet'>注销登录</a></li>");
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
		
		<nav id="infoNav" class="body" onmouseover='nowMouse="on";move();' onmouseout='nowMouse="off";move();' >
			<ul>
				<li><a href="/bingle/UpdateInfoControlServlet?type=mainPage">基本资料</a></li>
				<li><a href="/bingle/jsp/info/status.jsp">个人状态</a></li>
				<li><a href="/bingle/UpdateInfoControlServlet?type=disease" class="active">疾病情况</a></li>
			</ul>
		</nav>
		
		<section id="container" class="body">
			<br/>
			<div id="basic-accordian" ><!--Parent of the Accordion-->
				<div id="title">
				<%
					HttpSession sessionR = request.getSession();
					UserDetailInfo result = (UserDetailInfo)sessionR.getAttribute("udi");
					for(int i = 0; result != null && i < result.getUserDiseaseInfo().size(); i++){
				%>
					<div id="<%=result.getUserDiseaseInfo().get(i).getDiseaseName() %>-header" class="accordion_headings header_highlight" ><%=result.getUserDiseaseInfo().get(i).getDiseaseName() %></div>
					<%} %>
				</div>
				<div id="content">
					<%
						for(int i = 0; result != null && i < result.getUserDiseaseInfo().size(); i++){
					%>
					<div id="<%=result.getUserDiseaseInfo().get(i).getDiseaseName() %>-content">
						<div class="accordion_child">
							<form id="form" action="/bingle/UpdateInfoControlServlet?type=updateDisease" method="post">
							<input type="hidden" name="diseasename" value="<%=result.getUserDiseaseInfo().get(i).getDiseaseName() %>">
							<h4>药物服用<span class="alter"><a href="/bingle/UpdateInfoControlServlet?type=updateDiseaseDrug&diseasenum=<%=i %>">编辑药物</a></span></h4><br />
							<%
								for(int j = 0; j < result.getUserDiseaseInfo().get(i).getDrugName().size(); j++){
							%>
								<div class="tag"><%=result.getUserDiseaseInfo().get(i).getDrugName().get(j) %></div>
							<%
								}
							%>
							<br /><br/>
							<h4>病症原因<span class="alter"><input type="submit" value="编辑"></span></h4><br /><textarea rows="4" cols="117" name="reason"><%=result.getUserDiseaseInfo().get(i).getReason() %></textarea>
							<h4>个人治疗情况<span class="alter"><input type="submit" value="编辑"></span></h4><br /><textarea rows="4" cols="117" name="treatment"><%=result.getUserDiseaseInfo().get(i).getTreatmentIntro() %></textarea>
							<h4>个人建议<span class="alter"><input type="submit" value="编辑"></span></h4><br /><textarea rows="4" cols="117" name="tips"><%=result.getUserDiseaseInfo().get(i).getTips() %></textarea>
							</form>
							<a href="/bingle/UpdateInfoControlServlet?type=deleteUserDisease&diseasename=<%=result.getUserDiseaseInfo().get(i).getDiseaseName() %>">删除该病</a>
						</div>
					</div>
					<%} %>					
				</div>
			</div>
		</section>
		
		<footer id="about" class="body">
			<p>blablabla</p>
		</footer>
		
	</body>
</html>
			