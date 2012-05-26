<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html;charset=gb2312">
	<title>tags</title>

	<link rel="stylesheet" href="/bingle/css/tags.css" type="text/css" />
	
	<script type="text/javascript" src="/bingle/script/inNav.js"></script>
	<script type="text/javascript" src="/bingle/script/jquery.js"></script>
	<script type="text/javascript" src="/bingle/script/table.js"></script>
	
	<!--[if IE]>
	 <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
	<!--[if lte IE 7]>
	 <script src="../js/IE8.js" type="text/javascript"></script><![endif]-->

	<!--[if lt IE 7]>
	 <link rel="stylesheet" type="text/css" media="all" href="../css/ie6.css"/><![endif]-->
	</head>

	<body id="index" class="home" onload="init();">
		<header id="banner" class="body">
			<h1><img src="img/logo.jpg"/></h1>			
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
				<li><a href="/bingle/jsp/info/disease.jsp">疾病情况</a></li>
				<li><a href="#" class="active">管理标签</a></li>
			</ul>
		</nav>
		
		<section id="container" class="body">
			<br/>
			<form method="post" name="addform">
				<table id="table">
				<tr>
					<th>现有标签</th>
					<th></th>
					<th>标签列表</th>
				</tr>
				<tr>
					<th colspan=3><input type="search" id="taginput"></th>
				</tr>	
					<tr>
						<td class="left">
							<select multiple id="tagl1" name="list1" size="12" ondblclick="moveOption(document.addform.list1, document.addform.list2)">
								<option value="感冒">感冒</option>
								<option value="发烧">发烧</option>
								<option value="头痛">头痛</option>
								<option value="胃病">胃病</option>
								<option value="感冒">感冒</option>
								<option value="发烧">发烧</option>
								<option value="头痛">头痛</option>
								<option value="胃病">胃病</option>
								<option value="感冒">感冒</option>
								<option value="发烧">发烧</option>
								<option value="头痛">头痛</option>
								<option value="胃病">胃病</option>
								<option value="感冒">感冒</option>
								<option value="发烧">发烧</option>
								<option value="头痛">头痛</option>
								<option value="胃病">胃病</option>
							</select>
						</td>
						<td class="middle">
							<input type="button" value=">>" onClick="moveOption(document.addform.list1, document.addform.list2)"><br><br>
							<input type="button" value="<<" onClick="moveOption(document.addform.list2, document.addform.list1)">
						</td>
						<td class="right">
							<select multiple name="list2" size="12" ondblclick="moveOption(document.addform.list2, document.addform.list1)">
							</select>
						</td>
					</tr>
				</table>
			</form>
			<p id="alter">找不到想要的标签?<a href="#">点击</a>添加新标签</p>
		</section>
		<footer id="about" class="body">
			<p>blablabla</p>
		</footer>
		
	</body>
</html>
		