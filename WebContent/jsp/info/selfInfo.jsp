<%@ page language="java" import="java.util.*,baseUse.searchData.UserDetailInfo" pageEncoding="utf-8"%>
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
	<link rel="stylesheet" href="/bingle/css/index.css" type="text/css" />
	<script type="text/javascript" src="/bingle/script/jquery.js"></script>
	<script type="text/javascript" src="/bingle/script/star.js"></script>
	<script type="text/javascript" src="/bingle/script/talk.js"></script>
	<script type="text/javascript" src="/bingle/script/prototype.js"></script>
	<script type="text/javascript" src="/bingle/script/effects.js"></script>
	<script type="text/javascript" src="/bingle/script/side-bar.js"></script>
	<script type="text/javascript" src="/bingle/script/chat.js"></script>
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
					<li><a href="/bingle/SearchControlServlet?searchType=patients">病友</a></li>
					<li><a href="/bingle/SearchControlServlet?searchType=diseases">病症</a></li>
					<li><a href="/bingle/ForumControlServlet?func=ini">交流区</a></li>
					<% if(request.getSession().getAttribute("login").equals("1"))
						out.println("<li class='active'><a href='jsp/info/selfInfo.jsp'>控制面板</a></li>");
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
				<li><a href="/bingle/UpdateInfoControlServlet?type=mainPage" class="active">基本资料</a></li>
				<li><a href="/bingle/jsp/info/status.jsp">个人状态</a></li>
				<li><a href="/bingle/UpdateInfoControlServlet?type=disease">疾病情况</a></li>
				<li><a href="/bingle/UpdateInfoControlServlet?type=normalTag" >管理标签</a></li>
			</ul>
		</nav>
		
		<section id="container" class="body">
			<h3>欢迎，${udi.username }!&nbsp&nbsp&nbsp记录您的状态吧!</h3>
			<table id="status">
			<tr id="b"><th>身体状况</th>
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
			<tr id="m"><th>心理状况</th>
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
			
			<%
		UserDetailInfo udi = (UserDetailInfo) request.getSession().getAttribute("udi");
		if((udi.getBodyStatus() % 10 != 0) && (udi.getMindStatus() % 10 != 0))
			out.println("<script>document.getElementById('status').style.display='none';</script>");
		else if(udi.getBodyStatus() % 10 != 0)
			out.println("<script>document.getElementById('b').style.display='none';</script>");
		else if(udi.getMindStatus() % 10 != 0)
			out.println("<script>document.getElementById('m').style.display='none';</script>");
		%>
			
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
					<td colspan=2><a href="#" onclick="baseUpdate();"><span>提交</span></a></td>
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
		
	<div id="main" class="dragclass" style="display:none;">
		<div id="ChatHead">
			<span id="name"></span>
			<a onclick="ChatClose();" ><img src="/bingle/img/close.gif" alt="关闭"/></a>
		</div>
		<div id="ChatBody">
			<div id="ChatContent"></div>
			<div id="ChatBtn">
				<textarea id="ChatValue" rows="4" style="width:335px"></textarea>
				<input type="image" src="/bingle/img/chat.gif" value="Chat" onclick="ChatAndSend();"/>
			</div>
		</div>
	</div>
		<div id="sideBar">
		<a id="sideBarTab"><img src="/bingle/img/slide-button.gif" alt="sideBar" title="friends" /></a>
		<div id="sideBarContents" style="display:none;">
			<div id="sideBarContentsInner">
				<h2>Friends</h2>
			</div>
		</div>
		</div>

		<footer id="about" class="body">
			<p>blablabla</p>

		</footer>
		
	</body>