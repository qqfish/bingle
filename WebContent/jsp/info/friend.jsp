<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html;charset=gb2312">
	<title>friends</title>

	<link rel="stylesheet" href="/bingle/css/friends.css" type="text/css" />
	<script type="text/javascript" src="bingle/script/inNav.js"></script>
	
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
				<li><a href="/bingle/jsp/info/selfInfo.jsp">基本资料</a></li>
				<li><a href="/bingle/jsp/info/status.jsp">个人状态</a></li>
				<li><a href="/bingle/jsp/info/diesase.jsp">疾病情况</a></li>
				<li><a href="#" class="active">好友管理</a></li>
			</ul>
		</nav>
		
		<section id="container" class="body">
			<div class="control">
				<ul>
					<li class="act"><img src="/bingle/img/friend.jpg"/><a href="#">好友列表</a></li>
					<li><img src="/bingle/img/add.jpg"/><a href="#">添加好友</a></li>
					<li><img src="/bingle/img/new.jpg"/><a href="#">好友请求</a></li>
				</ul>
			</div>
			<nav class="pageNav">
					<span class="disabled"><=</span>
					<span class="current">1</span>
					<a href="#">2</a>
					<a href="#">3</a>
					<a href="#">4</a>
					<span class="gap">...</span>
					<a href="#">20</a>
					<a href="#">21</a>
					<a href="#" class="nextPage">=></a>
			</nav>
			<div class="friendList">
				<h4 id="title"><a href="#">HAHA</a><span class="alter"><a href="#"><img src="img/delete.jpg" alt="删除好友"></a></span></h4>
				<br/>
				<p>HTML色彩代码网站提供一件有关于色彩方面的免费工具，来帮助您查找贵站中的 HTML色彩 。功能卓越的 HTML色彩表格工具和 HTML色彩提取利器让这个过程易如反掌。要想在您的网站上快速使用 HTML色彩 ，请查阅 “如何使用HTML色彩代码？” 。如果您愿意学习 HTML色彩代码中字符组合的真实意思，请查阅 “HTML色彩代码理论”部分。网络安全色彩指的是通用于任何操作系统中的颜色清单。如果您患有色盲症疾病，可以阅读 HTML色彩名称来克服由看不清颜色所带来的困扰。</p>
				<hr class="line">
				<br/>
				<h4 id="title"><a href="#">HAHA</a><span class="alter"><a href="#"><img src="img/delete.jpg" alt="删除好友"></a></span></h4>
				<br/>
				<p>HTML色彩代码网站提供一件有关于色彩方面的免费工具，来帮助您查找贵站中的 HTML色彩 。功能卓越的 HTML色彩表格工具和 HTML色彩提取利器让这个过程易如反掌。要想在您的网站上快速使用 HTML色彩 ，请查阅 “如何使用HTML色彩代码？” 。如果您愿意学习 HTML色彩代码中字符组合的真实意思，请查阅 “HTML色彩代码理论”部分。网络安全色彩指的是通用于任何操作系统中的颜色清单。如果您患有色盲症疾病，可以阅读 HTML色彩名称来克服由看不清颜色所带来的困扰。</p>
				<hr class="line">
				<br/>
				<h4 id="title"><a href="#">HAHA</a><span class="alter"><a href="#"><img src="img/delete.jpg" alt="删除好友"></a></span></h4>
				<br/>
				<p>HTML色彩代码网站提供一件有关于色彩方面的免费工具，来帮助您查找贵站中的 HTML色彩 。功能卓越的 HTML色彩表格工具和 HTML色彩提取利器让这个过程易如反掌。要想在您的网站上快速使用 HTML色彩 ，请查阅 “如何使用HTML色彩代码？” 。如果您愿意学习 HTML色彩代码中字符组合的真实意思，请查阅 “HTML色彩代码理论”部分。网络安全色彩指的是通用于任何操作系统中的颜色清单。如果您患有色盲症疾病，可以阅读 HTML色彩名称来克服由看不清颜色所带来的困扰。</p>
				<hr class="line">
				<br/>
				<h4 id="title"><a href="#">HAHA</a><span class="alter"><a href="#"><img src="img/delete.jpg" alt="删除好友"></a></span></h4>
				<br/>
				<p>HTML色彩代码网站提供一件有关于色彩方面的免费工具，来帮助您查找贵站中的 HTML色彩 。功能卓越的 HTML色彩表格工具和 HTML色彩提取利器让这个过程易如反掌。要想在您的网站上快速使用 HTML色彩 ，请查阅 “如何使用HTML色彩代码？” 。如果您愿意学习 HTML色彩代码中字符组合的真实意思，请查阅 “HTML色彩代码理论”部分。网络安全色彩指的是通用于任何操作系统中的颜色清单。如果您患有色盲症疾病，可以阅读 HTML色彩名称来克服由看不清颜色所带来的困扰。</p>
				<hr class="line">
				<br/>
				<h4 id="title"><a href="#">HAHA</a><span class="alter"><a href="#"><img src="img/delete.jpg" alt="删除好友"></a></span></h4>
				<br/>
				<p>HTML色彩代码网站提供一件有关于色彩方面的免费工具，来帮助您查找贵站中的 HTML色彩 。功能卓越的 HTML色彩表格工具和 HTML色彩提取利器让这个过程易如反掌。要想在您的网站上快速使用 HTML色彩 ，请查阅 “如何使用HTML色彩代码？” 。如果您愿意学习 HTML色彩代码中字符组合的真实意思，请查阅 “HTML色彩代码理论”部分。网络安全色彩指的是通用于任何操作系统中的颜色清单。如果您患有色盲症疾病，可以阅读 HTML色彩名称来克服由看不清颜色所带来的困扰。</p>
				<hr class="line">
				<br/>
				<h4 id="title"><a href="#">HAHA</a><span class="alter"><a href="#"><img src="img/delete.jpg" alt="删除好友"></a></span></h4>
				<br/>
				<p>HTML色彩代码网站提供一件有关于色彩方面的免费工具，来帮助您查找贵站中的 HTML色彩 。功能卓越的 HTML色彩表格工具和 HTML色彩提取利器让这个过程易如反掌。要想在您的网站上快速使用 HTML色彩 ，请查阅 “如何使用HTML色彩代码？” 。如果您愿意学习 HTML色彩代码中字符组合的真实意思，请查阅 “HTML色彩代码理论”部分。网络安全色彩指的是通用于任何操作系统中的颜色清单。如果您患有色盲症疾病，可以阅读 HTML色彩名称来克服由看不清颜色所带来的困扰。</p>
				<hr class="line">
				<br/>
				<h4 id="title"><a href="#">HAHA</a><span class="alter"><a href="#"><img src="img/delete.jpg" alt="删除好友"></a></span></h4>
				<br/>
				<p>HTML色彩代码网站提供一件有关于色彩方面的免费工具，来帮助您查找贵站中的 HTML色彩 。功能卓越的 HTML色彩表格工具和 HTML色彩提取利器让这个过程易如反掌。要想在您的网站上快速使用 HTML色彩 ，请查阅 “如何使用HTML色彩代码？” 。如果您愿意学习 HTML色彩代码中字符组合的真实意思，请查阅 “HTML色彩代码理论”部分。网络安全色彩指的是通用于任何操作系统中的颜色清单。如果您患有色盲症疾病，可以阅读 HTML色彩名称来克服由看不清颜色所带来的困扰。</p>
				<hr class="line">
				<br/>
				<h4 id="title"><a href="#">HAHA</a><span class="alter"><a href="#"><img src="img/delete.jpg" alt="删除好友"></a></span></h4>
				<br/>
				<p>HTML色彩代码网站提供一件有关于色彩方面的免费工具，来帮助您查找贵站中的 HTML色彩 。功能卓越的 HTML色彩表格工具和 HTML色彩提取利器让这个过程易如反掌。要想在您的网站上快速使用 HTML色彩 ，请查阅 “如何使用HTML色彩代码？” 。如果您愿意学习 HTML色彩代码中字符组合的真实意思，请查阅 “HTML色彩代码理论”部分。网络安全色彩指的是通用于任何操作系统中的颜色清单。如果您患有色盲症疾病，可以阅读 HTML色彩名称来克服由看不清颜色所带来的困扰。</p>
				<hr class="line">
				<br/>
				<h4 id="title"><a href="#">HAHA</a><span class="alter"><a href="#"><img src="img/delete.jpg" alt="删除好友"></a></span></h4>
				<br/>
				<p>HTML色彩代码网站提供一件有关于色彩方面的免费工具，来帮助您查找贵站中的 HTML色彩 。功能卓越的 HTML色彩表格工具和 HTML色彩提取利器让这个过程易如反掌。要想在您的网站上快速使用 HTML色彩 ，请查阅 “如何使用HTML色彩代码？” 。如果您愿意学习 HTML色彩代码中字符组合的真实意思，请查阅 “HTML色彩代码理论”部分。网络安全色彩指的是通用于任何操作系统中的颜色清单。如果您患有色盲症疾病，可以阅读 HTML色彩名称来克服由看不清颜色所带来的困扰。</p>
				<hr class="line">
			</div>
			<nav class="pageNav2">
					<span class="disabled"><=</span>
					<span class="current">1</span>
					<a href="#">2</a>
					<a href="#">3</a>
					<a href="#">4</a>
					<span class="gap">...</span>
					<a href="#">20</a>
					<a href="#">21</a>
					<a href="#" class="nextPage">=></a>
			</nav>
