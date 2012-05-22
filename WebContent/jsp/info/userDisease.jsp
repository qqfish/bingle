<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="baseUse.searchData.UserDetailInfo"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html;charset=gb2312">
	<title>disease</title>

	<link rel="stylesheet" href="/bingle/css/userDisease.css" type="text/css" />
	<script type="text/javascript" src="/bingle/script/accordian.pack.js"></script>
	<script type="text/javascript" src="/bingle/script/inNav.js"></script>
	
	<!--[if IE]>
	 <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
	<!--[if lte IE 7]>
	 <script src="../js/IE8.js" type="text/javascript"></script><![endif]-->

	<!--[if lt IE 7]>
	 <link rel="stylesheet" type="text/css" media="all" href="../css/ie6.css"/><![endif]-->
	</head>

	<body id="index" class="home" onload="init();new Accordian('basic-accordian',5,'header_highlight');">
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
				<li><a href="/bingle/UpdateInfoControlServlet?type=mainPage">基本资料</a></li>
				<li><a href="jsp/info/status.jsp">个人状态</a></li>
				<li><a href="/bingle/UpdateInfoControlServlet?type=disease" class="active">疾病情况</a></li>
				<li><a href="#">管理标签</a></li>
			</ul>
		</nav>
		
		<section id="container" class="body">
			<br/>
			<div id="basic-accordian" ><!--Parent of the Accordion-->
				<div id="title">
				<%
					HttpSession sessionR = request.getSession();
					UserDetailInfo result = (UserDetailInfo)sessionR.getAttribute("udi");
					for(int i = 0; result != null && i < result.getUserDiseaseInfo().size(); i++){
				%>
					<div id="<%=result.getUserDiseaseInfo().get(i).getDiseaseName() %>-header" class="accordion_headings header_highlight" ><%=result.getUserDiseaseInfo().get(i).getDiseaseName() %></div>
					<%} %>
					<div id="test2-header" class="accordion_headings" >发烧</div>
					<div id="test3-header" class="accordion_headings" >头痛</div>
					<div id="test4-header" class="accordion_headings" >胃病</div>
				</div>
				<div id="content">
					<%
						for(int i = 0; result != null && i < result.getUserDiseaseInfo().size(); i++){
					%>
					<div id="<%=result.getUserDiseaseInfo().get(i).getDiseaseName() %>-content">
						<div class="accordion_child">
							<h4>病症原因<span class="alter"><a href="#">编辑</a></span><h4/><br /><%=result.getUserDiseaseInfo().get(i).getReason() %><br/><br/>
							<h4>个人治疗情况<span class="alter"><a href="#">编辑</a></span><h4/><br /><%=result.getUserDiseaseInfo().get(i).getTreatmentIntro() %><br/>
							<h4>个人建议<span class="alter"><a href="#">编辑</a></span><h4/><br /><%=result.getUserDiseaseInfo().get(i).getTips() %><br/>
						</div>
					</div>
					<%} %>
					<div id="test2-content">
						<div class="accordion_child">
							<h4>病症介绍<span class="alter"><a href="#">编辑</a></span><h4/><br />封姓缝匠，病恶寒，遍身无汗，循背脊之筋骨疼痛不能转侧，脉浮紧。余诊之曰：此外邪袭于皮毛，故恶寒无汗，况脉浮紧，证属麻黄，而项背强痛，因邪气已侵及背输经络，比之麻黄证更进一层，宜治以葛根汤。<br/>
							葛根五钱麻黄三钱桂枝二钱白芍三钱甘草二钱生姜四片红枣四枚方意系借葛根之升提，达水液至皮肤，更佐麻黄之力，推运至毛孔之外。两解肌表，虽与桂枝二麻黄一汤同意，而用却不同。服后顷刻，觉背内微热，再服，背汗遂出，次及周身，安睡一宵，病遂告差。<br/><br/>
							<h4>个人治疗情况<span class="alter"><a href="#">编辑</a></span><h4/><br />封姓缝匠，病恶寒，遍身无汗，循背脊之筋骨疼痛不能转侧，脉浮紧。余诊之曰：此外邪袭于皮毛，故恶寒无汗，况脉浮紧，证属麻黄，而项背强痛，因邪气已侵及背输经络，比之麻黄证更进一层，宜治以葛根汤。<br/>
							葛根五钱麻黄三钱桂枝二钱白芍三钱甘草二钱生姜四片红枣四枚方意系借葛根之升提，达水液至皮肤，更佐麻黄之力，推运至毛孔之外。两解肌表，虽与桂枝二麻黄一汤同意，而用却不同。服后顷刻，觉背内微热，再服，背汗遂出，次及周身，安睡一宵，病遂告差。<br/>
						</div>
					</div>
					<div id="test3-content">
						<div class="accordion_child">
							<h4>病症介绍<span class="alter"><a href="#">编辑</a></span><h4/><br />封姓缝匠，病恶寒，遍身无汗，循背脊之筋骨疼痛不能转侧，脉浮紧。余诊之曰：此外邪袭于皮毛，故恶寒无汗，况脉浮紧，证属麻黄，而项背强痛，因邪气已侵及背输经络，比之麻黄证更进一层，宜治以葛根汤。<br/>
							葛根五钱麻黄三钱桂枝二钱白芍三钱甘草二钱生姜四片红枣四枚方意系借葛根之升提，达水液至皮肤，更佐麻黄之力，推运至毛孔之外。两解肌表，虽与桂枝二麻黄一汤同意，而用却不同。服后顷刻，觉背内微热，再服，背汗遂出，次及周身，安睡一宵，病遂告差。<br/><br/>
							<h4>个人治疗情况<span class="alter"><a href="#">编辑</a></span><h4/><br />封姓缝匠，病恶寒，遍身无汗，循背脊之筋骨疼痛不能转侧，脉浮紧。余诊之曰：此外邪袭于皮毛，故恶寒无汗，况脉浮紧，证属麻黄，而项背强痛，因邪气已侵及背输经络，比之麻黄证更进一层，宜治以葛根汤。<br/>
							葛根五钱麻黄三钱桂枝二钱白芍三钱甘草二钱生姜四片红枣四枚方意系借葛根之升提，达水液至皮肤，更佐麻黄之力，推运至毛孔之外。两解肌表，虽与桂枝二麻黄一汤同意，而用却不同。服后顷刻，觉背内微热，再服，背汗遂出，次及周身，安睡一宵，病遂告差。<br/>
						</div>
					</div>
					<div id="test4-content">
						<div class="accordion_child">
							<h4>病症介绍<span class="alter"><a href="#">编辑</a></span><h4/><br />封姓缝匠，病恶寒，遍身无汗，循背脊之筋骨疼痛不能转侧，脉浮紧。余诊之曰：此外邪袭于皮毛，故恶寒无汗，况脉浮紧，证属麻黄，而项背强痛，因邪气已侵及背输经络，比之麻黄证更进一层，宜治以葛根汤。<br/>
							葛根五钱麻黄三钱桂枝二钱白芍三钱甘草二钱生姜四片红枣四枚方意系借葛根之升提，达水液至皮肤，更佐麻黄之力，推运至毛孔之外。两解肌表，虽与桂枝二麻黄一汤同意，而用却不同。服后顷刻，觉背内微热，再服，背汗遂出，次及周身，安睡一宵，病遂告差。<br/><br/>
							<h4>个人治疗情况<span class="alter"><a href="#">编辑</a></span><h4/><br />封姓缝匠，病恶寒，遍身无汗，循背脊之筋骨疼痛不能转侧，脉浮紧。余诊之曰：此外邪袭于皮毛，故恶寒无汗，况脉浮紧，证属麻黄，而项背强痛，因邪气已侵及背输经络，比之麻黄证更进一层，宜治以葛根汤。<br/>
							葛根五钱麻黄三钱桂枝二钱白芍三钱甘草二钱生姜四片红枣四枚方意系借葛根之升提，达水液至皮肤，更佐麻黄之力，推运至毛孔之外。两解肌表，虽与桂枝二麻黄一汤同意，而用却不同。服后顷刻，觉背内微热，再服，背汗遂出，次及周身，安睡一宵，病遂告差。<br/>
						</div>
					</div>
				</div>
			</div>
		</section>
		
		<footer id="about" class="body">
			<p>blablabla</p>
		</footer>
		
	</body>
</html>
			