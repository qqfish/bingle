<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="baseUse.searchData.UserDetailInfo"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="/bingle/text/html;charset=gb2312">
	<title>tags</title>

	<link rel="stylesheet" href="/bingle/css/tags.css" type="text/css" />
	<script type="text/javascript" src="/bingle/script/inNav.js"></script>
	
	<!--[if IE]>
	 <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
	<!--[if lte IE 7]>
	 <script src="../js/IE8.js" type="text/javascript"></script><![endif]-->

	<!--[if lt IE 7]>
	 <link rel="stylesheet" type="text/css" media="all" href="../css/ie6.css"/><![endif]-->
	</head>

	<body id="index" class="home" onload="init();">
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
					<li><a href="/bingle/ForumControlServlet?func=ini">交流区</a></li>
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
			<div class="left">
			<%
			HttpSession sessionR = request.getSession();
			UserDetailInfo result = (UserDetailInfo)sessionR.getAttribute("udi");
			int diseasenum = Integer.valueOf((String)request.getAttribute("diseasenum"));
			%>
				<h4><%=result.getUserDiseaseInfo().get(diseasenum).getDiseaseName() %>的药物</h4>
				<ul>
					<%
					for(int i = 0; i < result.getUserDiseaseInfo().get(diseasenum).getDrugName().size(); i++){	
						if(i == result.getUserDiseaseInfo().get(diseasenum).getDrugName().size() / 2){
							out.println("</ul><ul>");
						}
					%>
					<li><a href="#" class="item"><%=result.getUserDiseaseInfo().get(diseasenum).getDrugName().get(i) %></a><a href="/bingle/UpdateInfoControlServlet?type=deleteDiseaseDrug&diseasenum=<%=diseasenum %>&drugname=<%=result.getUserDiseaseInfo().get(diseasenum).getDrugName().get(i) %>"><img class="delete" src="/bingle/img/delete.png" alt="删除标签"></a></li>
					<%} %>					
				</ul>
				<p>找不到想要的标签?<a href="#">点击</a>添加新标签</p>
			</div>
			<div class="right">
				<h4>药物列表</h4>
				<ul>
				<%
				List<String> result1 = (List<String>) request.getAttribute("drug");
				for(int i = 0; i < result1.size(); i++){
					if(i == result1.size() / 2){
						out.println("</ul><ul>");
					}
				%>
					<li><a href="#" class="item"><%=result1.get(i) %></a><a href="/bingle/UpdateInfoControlServlet?type=addDiseaseDrug&diseasenum=<%=diseasenum %>&drugname=<%=result1.get(i) %>"><img class="delete" src="/bingle/img/add.png" alt="添加标签"></a></li>
				<%} %>
			</div>
		</section>
		<footer id="about" class="body">
			<p>blablabla</p>
		</footer>
		
	</body>
</html>	