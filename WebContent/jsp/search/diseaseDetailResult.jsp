<!DOCTYPE html>
<%@ page language="java" %>
<%@ page import="baseUse.searchData.DiseaseDetailInfo"%>
<%@ page import="baseUse.searchData.UserShortInfo"%>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html;charset=gb2312">
	<title>Disease Detail Result</title>

	<link rel="stylesheet" href="css/diseaseDetailResult.css" type="text/css" />
	<script type="text/javascript" src="script/accordian.pack.js"></script>
	<script src="script/libraries/RGraph.common.core.js" ></script>
    <script src="script/libraries/RGraph.common.dynamic.js" ></script>
    <script src="script/libraries/RGraph.common.tooltips.js" ></script>
    <script src="script/libraries/RGraph.pie.js" ></script>
    <script src="script/libraries/RGraph.common.key.js" ></script>
    <script src="script/libraries/RGraph.common.effects.js" ></script>
	<script>
	function circle ()
    {
        // The data to be shown on the Pie chart
        var data = [<%        
        	DiseaseDetailInfo result = (DiseaseDetailInfo) request.getAttribute("result");
        	for(int i = 0; i <result.getDrugs().size(); i++){
        		out.print(result.getDrugs().get(i).getNum());
        		if(i != result.getDrugs().size() - 1)
        			out.print(",");
        	}
                    
        %>];
    
        // Create the Pie chart. The arguments are the canvas ID and the data to be shown.
        var pie = new RGraph.Pie('myPie', data);

        // Configure the chart to look as you want.
        pie.Set('chart.labels', [<%
        	for(int i = 0; i < result.getDrugs().size(); i++){
        		out.print("'" + result.getDrugs().get(i).getDrugname() + "'");
        		if(i != result.getDrugs().size() - 1)
        			out.print(",");
        	}
        %>]);
        pie.Set('chart.tooltips', [<%
                               	for(int i = 0; i < result.getDrugs().size(); i++){
                            		out.print("'" + result.getDrugs().get(i).getDrugname() + "(" + result.getDrugs().get(i).getNum() + ")'");
                            		if(i != result.getDrugs().size() - 1)
                            			out.print(",");
                            	}
                            %>]);
		pie.Set('chart.key', [<%
                               	for(int i = 0; i < result.getDrugs().size(); i++){
                            		out.print("'" + result.getDrugs().get(i).getDrugname() + "("+ result.getDrugs().get(i).getNum() + ")'");
                            		if(i != result.getDrugs().size() - 1)
                            			out.print(",");
                            	}
                            %>]);
        pie.Set('chart.linewidth', 5);
        pie.Set('chart.stroke', 'white');
        
        // Call the .Draw() chart to draw the Pie chart.
        pie.Draw();
    }
	</script>

	<!--[if IE]>
	 <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
	<!--[if lte IE 7]>
	 <script src="../js/IE8.js" type="text/javascript"></script><![endif]-->

	<!--[if lt IE 7]>
	 <link rel="stylesheet" type="text/css" media="all" href="../css/ie6.css"/><![endif]-->
	</head>

	<body id="index" class="home" onload="new Accordian('basic-accordian',5,'header_highlight');circle();">
		<header id="banner" class="body">
			<h1><img src="img/logo.jpg"/></h1>
			<nav>
				<ul>
					<li><a href="/bingle/SearchControlServlet?searchType=patients">病友</a></li>
					<li class="active"><a href="/bingle/SearchControlServlet?searchType=diseases">病症</a></li>
					<li><a href="ForumControlServlet?func=ini">交流区</a></li>
					<% if(request.getSession().getAttribute("login").equals("1"))
						out.println("<li><a href='jsp/info/selfInfo.jsp'>控制面板</a></li>");
					%>
				</ul>
				<form action="#" id="search" method="get">
					<input type="search" name="keyword" placeholder="Search this site">
					<input type="submit" value="patients" class="search-btn" name="searchType">
					<input type="submit" value="diseases" class="search-btn" name="searchType">
				</form>
			</nav>
		</header>
		<section id="container" class="body">
			<div class="left">
				<h3 class="title">${result.diseaseName}</h3>
				<span id="alter"><a href="#">编辑</a></span>
				<hr class="line">
				<p class="text">${result.diseaseIntro}</p>
				<br/>
				<h3 class="title">相关药物</h3>
				<hr class="line">
				<canvas id="myPie" width="600" height="300">[No canvas support]</canvas>
			</div>
			<div class="right">
				<div id="basic-accordian" >
					<div id="test-header" class="accordion_headings header_highlight" >推荐病友</div>
					<div id="test-content">
						<div class="accordion_child">
						推荐病友列表
						</div>
					</div>
					
					<%
					for(int i = 0; i < result.getUserOfThis().size() && i < 10; i++){
					%>
					<div id="test<%=i+1 %>-header" class="accordion_headings" ><%=result.getUserOfThis().get(i).getUsername() %></div>
					<div id="test<%=i+1 %>-content">
						<div class="accordion_child">
						年龄：<%=result.getUserOfThis().get(i).getAge() %><br/>
						性别：<%if(result.getUserOfThis().get(i).getGender())
									out.print("女");
						else
							out.print("男");
							%>
						<br />
						<a href="/bingle/SearchControlServlet?username=<%=result.getUserOfThis().get(i).getUsername() %>">详细资料</a>
						</div>
					</div>
					<%} %>
					
					<div id="test2-header" class="accordion_headings" >Addison</div>
					<div id="test2-content">
						<div class="accordion_child">
						 年龄：１８<br/>
						 性别：男 <br/>
						 <a href="#">详细资料</a>
						</div>
					</div>
					
					<div id="test3-header" class="accordion_headings" >Baird</div>
					<div id="test3-content">
						<div class="accordion_child">
						Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Nunc ligula nisl, egestas non, pharetra vel, scelerisque accumsan, lacus. Proin nibh. Aenean dapibus. 
						</div>
					</div>
					
					<div id="test4-header" class="accordion_headings" >Bird</div>
					<div id="test4-content">
						<div class="accordion_child">
						Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Nunc ligula nisl, egestas non, pharetra vel, scelerisque accumsan, lacus. Proin nibh. Aenean dapibus. 
						</div>
					</div>
					
					<div id="test5-header" class="accordion_headings" >BigFace</div>
					<div id="test5-content">
						<div class="accordion_child">
						Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Nunc ligula nisl, egestas non, pharetra vel, scelerisque accumsan, lacus. Proin nibh. Aenean dapibus. 
						</div>
					</div>
					
					<div id="test6-header" class="accordion_headings" >BigBird</div>
					<div id="test6-content">
						<div class="accordion_child">
						Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Nunc ligula nisl, egestas non, pharetra vel, scelerisque accumsan, lacus. Proin nibh. Aenean dapibus. 
						</div>
					</div>
					
					<div id="test7-header" class="accordion_headings" >Small</div>
					<div id="test7-content">
						<div class="accordion_child">
						Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Nunc ligula nisl, egestas non, pharetra vel, scelerisque accumsan, lacus. Proin nibh. Aenean dapibus. 
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