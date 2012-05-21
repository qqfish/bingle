function show(){
if(document.getElementById("window").style.display == "none")
	document.getElementById("window").style.display = "block";
else
	document.getElementById("window").style.display = "none";
}

function scroll(){
	document.getElementById("panel").style.right =0;
	document.getElementById("panel").style.bottom = 0;
}

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
            	var json = eval("("+xhr.responseText+")")
                document.getElementById('data')  
                          .innerHTML = json.messages;
            }  
        }  
    };  
    xhr.open('GET', 'BTalkControlServlet?timestamp='  
                          + new Date().getTime());  
    xhr.send(null);
}