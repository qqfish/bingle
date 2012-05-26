<%@page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
	<title>查找病症</title>

	<link rel="stylesheet" href="/bingle/css/search.css" type="text/css" />
	<script type="text/javascript" src="script/jquery.js"></script>
	<script type="text/javascript" src="script/thickbox.js"></script>
<link rel="stylesheet" href="css/thickbox.css" type="text/css" media="screen" />

	<!--[if IE]>
	 <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
	<!--[if lte IE 7]>
	 <script src="../js/IE8.js" type="text/javascript"></script><![endif]-->

	<!--[if lt IE 7]>
	 <link rel="stylesheet" type="text/css" media="all" href="../css/ie6.css"/><![endif]-->
	</head>

	<body id="index" class="home">
		<header id="banner" class="body">
			<h1><img href="#" src="/bingle/img/logo.jpg"></h1>
						
			<nav>
				<ul>
					<li><a href="/bingle/SearchControlServlet?searchType=patients">病友</a></li>
					<li class="active"><a href="/bingle/SearchControlServlet?searchType=diseases">病症</a></li>
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
			<header id="search-list-header">
			</header>
			<table id="search-list-context" >
				<thead>
					<tr>
						<th>疾病名称</th>
						<th>标签</th>
					</tr>
				</thead>
				<tbody>
					${table}
				</tbody>
				<tfoot>
					<tr>
						<td>总计:${total }</td>
						<td>
							<nav class="pageNav">
								${nav}
							</nav>
						</td>
					</tr>
				</tfoot>
			</table>			
		</section>
		
		<footer id="about" class="body">
			<p>blablabla</p>
		</footer>
		
	</body>
</html>
