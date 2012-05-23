function getMessages() {  
	var xhr;  
    if(window.XMLHttpRequest) {  
        xhr = new XMLHttpRequest();  
    }  
    else if(window.ActiveXObject) {  
        xhr = new ActiveXObject('Microsoft.XMLHTTP');  
    }  
    xhr.onreadystatechange = function() {  
        if(xhr.readyState === 4) {  
            if(xhr.status === 200) {
            	var json = eval("("+xhr.responseText+")");
            	for(var i=0;i<json.messages.length;i++){
            		ChatShow();
            		document.getElementById("name").innerHTML = json.messages[i][2];
            		document.getElementById("ChatContent")
            			.innerHTML += "<strong>" + json.messages[i][2] + "&nbsp" + json.messages[i][1] 
            				+ "</strong><br>" + json.messages[i][0] + "<br/>";
            	}
            }  
        }  
    };  
    xhr.open("GET", "BTalkControlServlet?get=message",true);  
    xhr.send(null);
}
function getFriendList() {  
    var xhr;  
    if(window.XMLHttpRequest) {  
        xhr = new XMLHttpRequest();  
    }  
    else if(window.ActiveXObject) {  
        xhr = new ActiveXObject('Microsoft.XMLHTTP');  
    }  
    xhr.onreadystatechange = function() {  
        if(xhr.readyState === 4) {  
            if(xhr.status === 200) {
                document.getElementById("sideBarContentsInner")  
                          .innerHTML += xhr.responseText;
            }
        }  
    };  
    xhr.open("POST", "BTalkControlServlet?func=friend",true);  
    xhr.send(null);
}
function ChatSend(){
	var xhr;  
	var o = document.getElementById("ChatValue");
	   if (o.value.length>0){
		   document.getElementById("ChatContent").innerHTML += "<strong>我&nbsp"+ (new Date()) +"</strong>"+o.value+"<br/>";
		   o.value='';
		   if(window.XMLHttpRequest) {  
		      xhr = new XMLHttpRequest();  
		   }
		   else if(window.ActiveXObject) {  
		      xhr = new ActiveXObject('Microsoft.XMLHTTP');  
		   }
		   alert(document.getElementById("name").innerHTML);
		   xhr.open("POST", "BTalkControlServlet?func=send&name=" + document.getElementById("name").innerHTML + "&content=" + o.value,true);  
		   xhr.send(null);
	   }
}
function show(){
	alert(this.innerHTML);
	document.getElementById("name").innerHTML = this.innerHTML;
	ChatShow();
}
window.onload = getMessages();getFriendList();