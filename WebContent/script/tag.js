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
			var json = eval("("+ xmlhttp.responseText + ")");
			var text;
			text = "<table><tr><th>hh</th><td>"+json.intro+"</td></tr><tr><th></th><td><ul";
			for(var i =0;i<json.altername.length;i++)
				text += ("<li>" + json.altername[i] + "</li>");
			text+= "</ul></td></tr></table>";
			document.getElementById("content").innerinnerHTML = text;
		} else {
			window.alert("页面有错误");
		}
	}
}

function getTagname(tagname){
	sendRequest("UpdateWikiControlServlet?tagname="+tagname);
}