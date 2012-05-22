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
            	alert(xhr.respnseText);
            	var json = eval("("+xhr.responseText+")");
            	for(var i=0;i<json.messages.length;i++){
            		ChatShow();
            		document.getElementById("ChatContent").innerHTML = json.messages[i] + "<br/>";
            	}
            }  
        }  
    };  
    xhr.open("GET", "BTalkControlServlet?get=message",true);  
    xhr.send(null);
    window.onload = getMessages();
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
    xhr.open("GET", "BTalkControlServlet?get=friend",true);  
    xhr.send(null);
}