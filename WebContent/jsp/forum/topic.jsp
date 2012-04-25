<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
	<head>
	<meta charset="gbk" />
	<title>Topic</title>

	<link rel="stylesheet" href="/bingle/css/topic.css" type="text/css" />

	<!--[if IE]>
	 <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
	<!--[if lte IE 7]>
	 <script src="js/IE8.js" type="text/javascript"></script><![endif]-->

	<!--[if lt IE 7]>
	 <link rel="stylesheet" type="text/css" media="all" href="css/ie6.css"/><![endif]-->
	</head>

	<body id="index" class="home">
		<header id="banner" class="body">
			<h1><a href="index.jsp"><img src="/bingle/img/logo.jpg"/></a></h1>
						
			<nav>
				<ul>
					<li><a href="search.jsp">病友</a></li>
					<li><a href="search.jsp">病症</a></li>
					<li class="active"><a href="#">交流区</a></li>
				</ul>
				<form action="#" id="search" method="get">
					<input type="search" id="search_word" placeholder="Search this site">
					<input type="submit" value="查找病友" class="search-btn" name="subBtn">
					<input type="submit" value="查找病症" class="search-btn" name="subBtn">
				</form>
			</nav>
		</header>
		<section id="container" class="body">
			<header class="forumHead">
				<div class="forumTitle">
					<a href="index.jsp">病了么</a>
					 - 
					<a href="#">病友论坛</a>
					 -
					<a href="#">感冒</a>
					 -
					<a href="#">XXXXXXXXXX</a>
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
				<input type="button" value="回复主题"/>
			</header>
			<article>
				<table class="content">
					<tr>
						<td class="number">查看:15000 | 回复:15000</th>
						<td class="title">XXXXXXXXXX</th>
					</tr>
					<tr class="text">
						<td class="left"><p class="name">感冒病友</p><hr></td>
						<td class="right"><p class="time">发表于: 2012-4-24 17:16<hr></p>在西双版纳有许多所谓的民俗风情村。比如西双版纳原始森林公园，就有一个爱伲部落。游客进入村寨以后，打扮得花枝招展的少女将游人热情地迎进二层竹楼，参观其民居。一名女子稍作介绍，一摆手，进来好几位女孩，不由分说把一个小葫芦样的幸运符戴到男士的脖子上，然后让你一起参加所谓的抢亲游戏。“婚礼”的一个重头戏，是“送入洞房”。不要以为洞房里真有那好事，可怜的、无辜的“新郎”都在那乖乖交钱呢。进了洞房，女孩就伸手向你要做嫁妆的钱。 
主婚人会说，爱伲姑娘给你戴幸运符的时候，如果你接受了，那就表示同意这门亲事了，如果反悔，就要把你在村口的大树上倒挂三天，还要给他们干三年苦力。游客稀里糊涂就被强拉入“洞房”，不把钱给够甭想出“洞房”。忍痛掏大洋把自己给赎回来吧，少则五六十，多则上百元。如果掏的是整的，这里的规矩是概不找零。如今民俗风情却往往成了民俗陷阱。从西双版纳回来的男女游客，大多有这样一个教训，那就是：“洞房不是随便进的”。<hr><p class="time">最后编辑时间: 2012-4-24 17:16</p></td>
					</tr>
					<tr class="text">
						<td class="left"><p class="name">阳痿病友</p><hr></td>
						<td class="right"><p class="time">发表于: 2012-4-24 17:16<hr></p>在西双版纳有许多所谓的民俗风情村。比如西双版纳原始森林公园，就有一个爱伲部落。游客进入村寨以后，打扮得花枝招展的少女将游人热情地迎进二层竹楼，参观其民居。一名女子稍作介绍，一摆手，进来好几位女孩，不由分说把一个小葫芦样的幸运符戴到男士的脖子上，然后让你一起参加所谓的抢亲游戏。“婚礼”的一个重头戏，是“送入洞房”。不要以为洞房里真有那好事，可怜的、无辜的“新郎”都在那乖乖交钱呢。进了洞房，女孩就伸手向你要做嫁妆的钱。 
主婚人会说，爱伲姑娘给你戴幸运符的时候，如果你接受了，那就表示同意这门亲事了，如果反悔，就要把你在村口的大树上倒挂三天，还要给他们干三年苦力。游客稀里糊涂就被强拉入“洞房”，不把钱给够甭想出“洞房”。忍痛掏大洋把自己给赎回来吧，少则五六十，多则上百元。如果掏的是整的，这里的规矩是概不找零。如今民俗风情却往往成了民俗陷阱。从西双版纳回来的男女游客，大多有这样一个教训，那就是：“洞房不是随便进的”。<hr><p class="time">最后编辑时间: 2012-4-24 17:16</p></td>
					</tr>
					<tr class="text">
						<td class="left"><p class="name">阳痿病友</p><hr></td>
						<td class="right"><p class="time">发表于: 2012-4-24 17:16<hr></p>在西双版纳有许多所谓的民俗风情村。比如西双版纳原始森林公园，就有一个爱伲部落。游客进入村寨以后，打扮得花枝招展的少女将游人热情地迎进二层竹楼，参观其民居。一名女子稍作介绍，一摆手，进来好几位女孩，不由分说把一个小葫芦样的幸运符戴到男士的脖子上，然后让你一起参加所谓的抢亲游戏。“婚礼”的一个重头戏，是“送入洞房”。不要以为洞房里真有那好事，可怜的、无辜的“新郎”都在那乖乖交钱呢。进了洞房，女孩就伸手向你要做嫁妆的钱。 
主婚人会说，爱伲姑娘给你戴幸运符的时候，如果你接受了，那就表示同意这门亲事了，如果反悔，就要把你在村口的大树上倒挂三天，还要给他们干三年苦力。游客稀里糊涂就被强拉入“洞房”，不把钱给够甭想出“洞房”。忍痛掏大洋把自己给赎回来吧，少则五六十，多则上百元。如果掏的是整的，这里的规矩是概不找零。如今民俗风情却往往成了民俗陷阱。从西双版纳回来的男女游客，大多有这样一个教训，那就是：“洞房不是随便进的”。<hr><p class="time">最后编辑时间: 2012-4-24 17:16</p></td>
					</tr>
					<tr class="text">
						<td class="left"><p class="name">阳痿病友</p><hr></td>
						<td class="right"><p class="time">发表于: 2012-4-24 17:16<hr></p>在西双版纳有许多所谓的民俗风情村。比如西双版纳原始森林公园，就有一个爱伲部落。游客进入村寨以后，打扮得花枝招展的少女将游人热情地迎进二层竹楼，参观其民居。一名女子稍作介绍，一摆手，进来好几位女孩，不由分说把一个小葫芦样的幸运符戴到男士的脖子上，然后让你一起参加所谓的抢亲游戏。“婚礼”的一个重头戏，是“送入洞房”。不要以为洞房里真有那好事，可怜的、无辜的“新郎”都在那乖乖交钱呢。进了洞房，女孩就伸手向你要做嫁妆的钱。 
主婚人会说，爱伲姑娘给你戴幸运符的时候，如果你接受了，那就表示同意这门亲事了，如果反悔，就要把你在村口的大树上倒挂三天，还要给他们干三年苦力。游客稀里糊涂就被强拉入“洞房”，不把钱给够甭想出“洞房”。忍痛掏大洋把自己给赎回来吧，少则五六十，多则上百元。如果掏的是整的，这里的规矩是概不找零。如今民俗风情却往往成了民俗陷阱。从西双版纳回来的男女游客，大多有这样一个教训，那就是：“洞房不是随便进的”。<hr><p class="time">最后编辑时间: 2012-4-24 17:16</p></td>
					</tr>
					<tr class="text">
						<td class="left"><p class="name">阳痿病友</p><hr></td>
						<td class="right"><p class="time">发表于: 2012-4-24 17:16<hr></p>在西双版纳有许多所谓的民俗风情村。比如西双版纳原始森林公园，就有一个爱伲部落。游客进入村寨以后，打扮得花枝招展的少女将游人热情地迎进二层竹楼，参观其民居。一名女子稍作介绍，一摆手，进来好几位女孩，不由分说把一个小葫芦样的幸运符戴到男士的脖子上，然后让你一起参加所谓的抢亲游戏。“婚礼”的一个重头戏，是“送入洞房”。不要以为洞房里真有那好事，可怜的、无辜的“新郎”都在那乖乖交钱呢。进了洞房，女孩就伸手向你要做嫁妆的钱。 
主婚人会说，爱伲姑娘给你戴幸运符的时候，如果你接受了，那就表示同意这门亲事了，如果反悔，就要把你在村口的大树上倒挂三天，还要给他们干三年苦力。游客稀里糊涂就被强拉入“洞房”，不把钱给够甭想出“洞房”。忍痛掏大洋把自己给赎回来吧，少则五六十，多则上百元。如果掏的是整的，这里的规矩是概不找零。如今民俗风情却往往成了民俗陷阱。从西双版纳回来的男女游客，大多有这样一个教训，那就是：“洞房不是随便进的”。<hr><p class="time">最后编辑时间: 2012-4-24 17:16</p></td>
					</tr>
					<tr class="text">
						<td class="left"><p class="name">阳痿病友</p><hr></td>
						<td class="right"><p class="time">发表于: 2012-4-24 17:16<hr></p>在西双版纳有许多所谓的民俗风情村。比如西双版纳原始森林公园，就有一个爱伲部落。游客进入村寨以后，打扮得花枝招展的少女将游人热情地迎进二层竹楼，参观其民居。一名女子稍作介绍，一摆手，进来好几位女孩，不由分说把一个小葫芦样的幸运符戴到男士的脖子上，然后让你一起参加所谓的抢亲游戏。“婚礼”的一个重头戏，是“送入洞房”。不要以为洞房里真有那好事，可怜的、无辜的“新郎”都在那乖乖交钱呢。进了洞房，女孩就伸手向你要做嫁妆的钱。 
主婚人会说，爱伲姑娘给你戴幸运符的时候，如果你接受了，那就表示同意这门亲事了，如果反悔，就要把你在村口的大树上倒挂三天，还要给他们干三年苦力。游客稀里糊涂就被强拉入“洞房”，不把钱给够甭想出“洞房”。忍痛掏大洋把自己给赎回来吧，少则五六十，多则上百元。如果掏的是整的，这里的规矩是概不找零。如今民俗风情却往往成了民俗陷阱。从西双版纳回来的男女游客，大多有这样一个教训，那就是：“洞房不是随便进的”。<hr><p class="time">最后编辑时间: 2012-4-24 17:16</p></td>
					</tr>
				</table>
			<article>
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
		</section>
		<footer id="about" class="body">
			<p>blablabla</p>
		</footer>
	</body>
</html>