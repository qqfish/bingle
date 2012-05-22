$(function(){
			$(".xing1 ul li").mouseover(function(){
				$(".xing_chen1").css("width",$(this).text()*28+"px");
				switch($(this).text()){
				case "1":$(".xing_show1 span").text("煎熬");break;
				case "2":$(".xing_show1 span").text("难受");break;
				case "3":$(".xing_show1 span").text("微恙");break;
				case "4":$(".xing_show1 span").text("一般");break;
				case "5":$(".xing_show1 span").text("极佳");break;
				default:$(".xing_show1 span").text("暂无");}
			})
			$(".xing1").mouseleave(function(){
				if($(".xing_show1").attr("rate")==""){
					$(".xing_chen1").css("width","0px");
					$(".xing_show1 span").text("暂无");
				}
				else{
					$(".xing_chen1").css("width",$(".xing_show1").attr("rate")*28+"px");
					$(".xing_show1 span").text($(".xing_show1").attr("rate"));
				}
			})
			$(".xing1 ul li").click(function(){
				window.location.href = "UpdateInfoControlServlet?func=body&rate=" + $(".xing_show1").text();
			})
		})
$(function(){
			$(".xing ul li").mouseover(function(){
				$(".xing_chen").css("width",$(this).text()*28+"px");
				switch($(this).text()){
				case "1":$(".xing_show span").text("煎熬");break;
				case "2":$(".xing_show span").text("难受");break;
				case "3":$(".xing_show span").text("微恙");break;
				case "4":$(".xing_show span").text("一般");break;
				case "5":$(".xing_show span").text("极佳");break;
				default:$(".xing_show span").text("暂无");}
			})
			$(".xing").mouseleave(function(){
				if($(".xing_show").attr("rate")==""){
					$(".xing_chen").css("width","0px");
					$(".xing_show span").text("暂无");
				}
				else{
					$(".xing_chen").css("width",$(".xing_show").attr("rate")*28+"px");
					$(".xing_show span").text($(".xing_show").attr("rate"));
				}
			})
			$(".xing ul li").click(function(){
				window.location.href = "UpdateInfoControlServlet?func=mind&rate=" + $(".xing_show").text();
			})
		})
		
function update(){
	window.location.href="UpdateInfoControlServlet?func=update&age=" + document.getElementById("age").value
		+ "&gender=" + document.getElementById("gender").value + "&email=" + document.getElementById("email").value
		+ "&address=" + document.getElementById("address").value;
}