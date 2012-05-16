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
	if (XMLHttpReq.readyState == 4) {
		if (XMLHttpReq.status == 200) {
			var json = eval(xmlhttp.responseText);
			$(content).innerinnerHTML = json[0] + json[1] + json[2];
		} else {
			window.alert("页面有错误");
		}
	}
}

function getTagname(tagname){
	sendRequest("UpdateWikiControlServlet?tagname="+tagname);
}