<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'tag.jsp' starting page</title>
	<script src="/bingle/script/tag.js" charset="utf-8"></script>
	<link rel="stylesheet" href="/bingle/css/tips.css" type="text/css" />
	
  </head>
  <body>
  	<% String s = request.getParameter("tagname"); 
  	out.println("<script>getTagname('"+ s +"')</script>");
  	%>
    <section class="container">
		<h3 id="title"></h3>
		<span id="alter"><a href="javascript:void(0)" onclick="updateTag();">编辑提交</a></span>
		<hr class="line">
		<p id="text" contenteditable="true"></p>
		<hr class="line">
		<ul id="tag" class="itemBox">
			<li class="tip"><span>近义标签:<span></li>
		</ul>
		<form id="form" action="UpdateWikiControlServlet?func=tag" method="post">
			<input type="hidden" id="tagname" name="tagname">
			<input type="hidden" id="content" name="content">
		</form>
		</section>
  </body>
</html>
