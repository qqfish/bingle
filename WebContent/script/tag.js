var XMLHttpReq = false;      

function createXMLHttpRequest(){
	if(window.XMLHttpRequest) {
		try{
			XMLHttpReq = new XMLHttpRequest();
		}catch(e){}
	}
	else if (window.ActiveXObject) {
		try {
			XMLHttpReq = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			try {
				XMLHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {}
		}
	}
}

function sendRequest(url) {
	createXMLHttpRequest();
	XMLHttpReq.open("GET", url, true); 
	XMLHttpReq.onreadystatechange = processResponse;
	XMLHttpReq.send(null); 
}

function processResponse() {
	//alert(XMLHttpReq.readyState + " " + XMLHttpReq.status);
	if (XMLHttpReq.readyState == 4) {
		if (XMLHttpReq.status == 200) {
			var json = eval("("+XMLHttpReq.responseText+")");
			document.getElementById("title").innerHTML = json.tagname;
			document.getElementById("text").innerHTML = json.intro;
			for(var i=0;i<json.altername.length;i++){
				var li= document.createElement("li");
				li.className = "item";
				li.innerHTML = "<a href='#'>"+json.altername[i]+"</a>";
				document.getElementById("tag").appendChild(li);
			}
		} else {
			window.alert("页面有错误");
		}
	}
}

function getTagname(tagname){
	sendRequest("UpdateWikiControlServlet?tagname="+tagname);
}

function updateTag(){
	document.getElementById("tagname").value = document.getElementById("title").innerHTML;
	document.getElementById("content").value = document.getElementById("text").innerHTML;
	document.getElementById("form").submit();
}