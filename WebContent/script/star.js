var jq=jQuery.noConflict();
jq(function(){
			jq(".xing1 ul li").mouseover(function(){
				jq(".xing_chen1").css("width",jq(this).text()*28+"px");
				switch(jq(this).text()){
				case "1":jq(".xing_show1 span").text("煎熬");break;
				case "2":jq(".xing_show1 span").text("难受");break;
				case "3":jq(".xing_show1 span").text("微恙");break;
				case "4":jq(".xing_show1 span").text("一般");break;
				case "5":jq(".xing_show1 span").text("极佳");break;
				default:jq(".xing_show1 span").text("暂无");}
			})
			jq(".xing1").mouseleave(function(){
				if(jq(".xing_show1").attr("rate")==""){
					jq(".xing_chen1").css("width","0px");
					jq(".xing_show1 span").text("暂无");
				}
				else{
					jq(".xing_chen1").css("width",jq(".xing_show1").attr("rate")*28+"px");
					jq(".xing_show1 span").text(jq(".xing_show1").attr("rate"));
				}
			})
			jq(".xing1 ul li").click(function(){
				window.location.href = "UpdateInfoControlServlet?func=body&rate=" + jq(".xing_show1").text();
			})
		})
jq(function(){
			jq(".xing ul li").mouseover(function(){
				jq(".xing_chen").css("width",jq(this).text()*28+"px");
				switch(jq(this).text()){
				case "1":jq(".xing_show span").text("煎熬");break;
				case "2":jq(".xing_show span").text("难受");break;
				case "3":jq(".xing_show span").text("微恙");break;
				case "4":jq(".xing_show span").text("一般");break;
				case "5":jq(".xing_show span").text("极佳");break;
				default:jq(".xing_show span").text("暂无");}
			})
			jq(".xing").mouseleave(function(){
				if(jq(".xing_show").attr("rate")==""){
					jq(".xing_chen").css("width","0px");
					jq(".xing_show span").text("暂无");
				}
				else{
					jq(".xing_chen").css("width",jq(".xing_show").attr("rate")*28+"px");
					jq(".xing_show span").text(jq(".xing_show").attr("rate"));
				}
			})
			jq(".xing ul li").click(function(){
				window.location.href = "UpdateInfoControlServlet?func=mind&rate=" + jq(".xing_show").text();
			})
		})
		
function update(){
	window.location.href="UpdateInfoControlServlet?func=update&age=" + document.getElementById("age").value
		+ "&gender=" + document.getElementById("gender").value + "&email=" + document.getElementById("email").value
		+ "&address=" + document.getElementById("address").value;
}