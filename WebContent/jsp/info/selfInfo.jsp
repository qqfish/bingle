<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html;charset=gb2312">
	<title>个人资料</title>

	<link rel="stylesheet" href="/bingle/css/selfInfo.css" type="text/css" />
	<link rel="stylesheet" href="/bingle/css/star.css" type="text/css" />
	<link rel="stylesheet" href="/bingle/css/talk.css" type="text/css" />
	<script type="text/javascript" src="/bingle/script/jquery.js"></script>
	<script type="text/javascript" src="/bingle/script/inNav.js"></script>
	<script type="text/javascript" src="/bingle/script/star.js"></script>
	<script type="text/javascript" src="/bingle/script/talk.js"></script>
	
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
				<li><a href="#" class="active">基本资料</a></li>
				<li><a href="/bingle/jsp/info/status.jsp">个人状态</a></li>
				<li><a href="/bingle/jsp/info/disease.jsp">疾病情况</a></li>
				<li><a href="#">管理标签</a></li>
			</ul>
		</nav>
		
		<section id="container" class="body">
			<h3>欢迎，${udi.username }!&nbsp&nbsp&nbsp记录您的状态吧!</h3>
			<table>
			<tr><th>身体状况</th>
			<td><div class="dengji1">
						<div class="xing1">
						<ul>
						<li rate="1">1</li>
						<li rate="2">2</li>
						<li rate="3">3</li>
						<li rate="4">4</li>
						<li rate="5">5</li>
						</ul>
						<div class="xing_chen1"></div>
						</div>
						</div>
				</td>
				<td><div class="xing_show1" rate=""><span>暂无</span></div>
				</td>
			</tr>
			<tr><th>心理状况</th>
			<td><div class="dengji">
						<div class="xing">
						<ul>
						<li rate="1">1</li>
						<li rate="2">2</li>
						<li rate="3">3</li>
						<li rate="4">4</li>
						<li rate="5">5</li>
						</ul>
						<div class="xing_chen"></div>
						</div>
						</div>
				</td>
				<td><div class="xing_show" rate=""><span>暂无</span></div>
				</td>
			</tr>
			</table>
			
			<table>
				<tr>
					<th>用户名</th>
					<td>${udi.username}</td>
				</tr>
				<tr>
					<th>用户群</th>
					<td>${udi.groupname}</td>
				</tr>
				<tr>
					<th>年龄</th>
					<td  id="age" contenteditable="true">${udi.age}</td>
				</tr>
				<tr>
					<th>性别</th>
					<td  id="gender" contenteditable="true">${udi.gender?"女":"男"}</td>
				</tr>
				<tr>
					<th>email</th>
					<td  id="email" contenteditable="true">${udi.email}</td>
				</tr>
				<tr>
					<th>address</th>
					<td  id="address" contenteditable="true">${udi.address}</td>
				</tr>
				<tr>
					<td colspan=2><a href="#" onclick="update();"><span>提交</span></a></td>
				</tr>
			</table>
			<table>
				<tr>
					<th>现有疾病</th>
					<td>${udi.userDiseaseInfo[0].diseaseName }</td>
				</tr>
				<tr>
					<td colspan=2>${udi.userDiseaseInfo[0].treatmentIntro }</td>
				</tr>
			</table>
		</section>
		
		<% if(request.getSession().getAttribute("login").equals("1")){
				out.println("<div id='panel' class='panel'>");
				out.println("<article id='window' class='window' style='display: none;'>");
				out.println("<header>");
				out.println("	<span class='title'>好友</span>");
				out.println("	<span id='bts'>");
	            out.println("		<label class='bu' id='tomin' title='最小化' onclick='show();'>-</label>");
				out.println("	</span>");
				out.println("</header>");
				out.println("<section>");
				out.println("	<article class='online-users'>");
				out.println("		<section>");
				out.println("			<ul class='user'></ul>");
				out.println("		</section>");
				out.println("	</article>");
				out.println("</section>");
				out.println("</article>");
				out.println("<a class='button' onclick='show();''>好友列表	</a></div>");
			}
		%>

		<footer id="about" class="body">
			<p>blablabla</p>

		</footer>
		
	</body>