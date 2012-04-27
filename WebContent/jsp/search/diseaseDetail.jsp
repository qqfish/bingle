<%@page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=GBK">
<title>疾病信息</title>

<link rel="stylesheet" href="/bingle/css/selfInfo.css" type="text/css" />
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
		<h1>
			<a><img src="/bingle/img/logo.jpg" /></a>
		</h1>

		<nav>
			<ul>
				<li><a href="search.htm">病友</a></li>
				<li><a href="search.htm">病症</a></li>
				<li><a href="forum.htm">讨论区</a></li>
				<li class="active"><a href="#">控制面板</a></li>
			</ul>
			<form action="/bingle/SearchControlServlet" id="search" method="get">
				<input type="search" name="keyword" placeholder="Search this site">
				<input type="submit" value="patients" class="search-btn"
					name="searchType"> <input type="submit" value="diseases"
					class="search-btn" name="searchType">
			</form>
		</nav>
	</header>

	<nav id="infoNav" class="body" onmouseover='nowMouse="on";move();'
		onmouseout='nowMouse="off";move();'>
		<ul>
			<li><a href="#" class="active">基本资料</a></li>
			<li><a href="#">个人状态</a></li>
			<li><a href="#">疾病情况</a></li>
			<li><a href="#">治疗过程</a></li>
			<li><a href="#">管理标签</a></li>
		</ul>
	</nav>

	<section id="container" class="body">
		<h3>»ù±¾×ÊÁÏ</h3>
	</section>

	<footer id="about" class="body">
		<p>blablabla</p>
	</footer>

</body>