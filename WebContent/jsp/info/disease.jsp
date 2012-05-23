<%@ page language="java" import="java.util.*,baseUse.searchData.UserDetailInfo" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<meta http-equiv="Content-Type" content="text/html;charset=gb2312">
	<title>disease</title>

	<link rel="stylesheet" href="/bingle/css/disease.css" type="text/css" />
	<script type="text/javascript" src="/bingle/script/inNav.js"></script>
	<script type="text/javascript" src="/bingle/script/accordian.pack.js"></script>
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
					<li><a href="/bingle/SearchControlServlet?searchType=patients">病友</a></li>
					<li><a href="/bingle/SearchControlServlet?searchType=diseases">病症</a></li>
					<li><a href="ForumControlServlet?func=ini">交流区</a></li>
					<li class="active"><a href="#">控制面板</a></li>
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
				<li><a href="/bingle/jsp/info/selfInfo.jsp">基本资料</a></li>
				<li><a href="/bingle/jsp/info/status.jsp">个人状态</a></li>
				<li><a href="#" class="active">疾病情况</a></li>
				<li><a href="/bingle/jsp/info/tag/jsp">管理标签</a></li>
			</ul>
		</nav>
		
		<section id="container" class="body">
			<br/>
			<div id="basic-accordian" ><!--Parent of the Accordion-->
				<div id="title">
				<div id="test1-header" class="accordion_headings header_highlight">${udi.userDiseaseInfo[0].diseaseName}</div>
				<%
					UserDetailInfo udi = (UserDetailInfo) request.getSession().getAttribute("udi");
					for(int i =1;i < udi.getUserDiseaseInfo().size();i++){
						out.println("<div id='test" + (i+1) +"-header' class='accordion_headings'>");
						out.println(udi.getUserDiseaseInfo().get(i).getDiseaseName()+"</div>");
					}
				%>
				</div>
				<div id="content">
				<%
				for(int i =0;i < udi.getUserDiseaseInfo().size();i++){
					out.println("<div id='test" + (i+1) +"-content'><div class='accordion_child'>");
					out.println("<h4>病症介绍</h4><br/><span id='name'>");
					out.println(udi.getUserDiseaseInfo().get(i).getDiseaseName() + "</span><br/><br/><hr/>");
					out.println("<h4>个人治疗情况<span class='alter'><a onclick='update();'>编辑提交</a></span></h4><br/>");
					out.println("<span id='text' contenteditable='true'>" + udi.getUserDiseaseInfo().get(i).getTreatmentIntro()+"</span><br/></div></div>");
				}
				%>
				</div>
			</div>
			<form id="form" action="/bingle/UpdateWikiControlServlet?func=disease" method="post">
			<input type="hidden" id="diseasename" name="diseasename">
			<input type="hidden" id="content" name="content">
			</form>
		</section>
		
		
		<footer id="about" class="body">
			<p>blablabla</p>
		</footer>
		
	</body>
</html>
