<%@page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>查找病友</title>

<link rel="stylesheet" href="/bingle/css/search.css" type="text/css" />

<!--[if IE]>
	 <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
<!--[if lte IE 7]>
	 <script src="../js/IE8.js" type="text/javascript"></script><![endif]-->

<!--[if lt IE 7]>
	 <link rel="stylesheet" type="text/css" media="all" href="../css/ie6.css"/><![endif]-->
</head>

<body id="index" class="home">
	<header id="banner" class="body">
		<h1>
			<img href="#" src="/bingle/img/logo.jpg">
		</h1>

		<nav>
			<ul>
				<li class="active"><a href="#">病友</a></li>
				<li><a href="#">病症</a></li>
				<li><a href="forum.htm">讨论区</a></li>
			</ul>
			<form action="#" id="search" method="get">
				<input type="search" id="keyword" placeholder="Search this site">
				<input type="submit" value="查找病友" class="search-btn" name="subBtn">
				<input type="submit" value="查找病症" class="search-btn" name="subBtn">
			</form>
		</nav>
	</header>
	<section id="container" class="body">
		<header id="search-list-header"> </header>
		<table id="search-list-context">
			<thead>
				<tr>
					<th>用户名</th>
					<th>性别</th>
					<th>年龄</th>
					<th>近期疾病</th>
					<th>标签</th>
				</tr>
			</thead>
			<tbody>
				${table }
			</tbody>
			<tfoot>
				<tr>
					<td>总计:${total }</td>
					<td></td>
					<td></td>
					<td></td>
					<td>
						<nav class="pageNav">
							${nav }
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
