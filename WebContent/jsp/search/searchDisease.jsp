<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
	<title>ËÑË÷½á¹û</title>

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
			<h1><img herf="#" src="../img/logo.jpg"></h1>
						
			<nav>
				<ul>
					<li class="active"><a href="#">²¡ÓÑ</a></li>
					<li><a href="#">²¡Ö¢</a></li>
					<li><a href="forum.htm">½»Á÷Çø</a></li>
				</ul>
				<form action="#" id="search" method="get">
					<input type="search" id="search_word" placeholder="Search this site">
					<input type="submit" value="²éÕÒ²¡ÓÑ" class="search-btn" name="subBtn">
					<input type="submit" value="²éÕÒ²¡Ö¢" class="search-btn" name="subBtn">
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
