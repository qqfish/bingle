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
			checkUsernameCallback();     
		} else {
			window.alert("页面有错误");
		}
	}
}

var usernameFlag=false;
var passwordFlag1=false;
var passwordFlag2=false;
var emailFlag=false;

function checkUsername(){
	var valid = /^[a-zA-Z][a-zA-Z0-9_]{5,15}$/;
	var username=document.getElementById("username").value;
	var usernameMsg=document.getElementById("usernameMsg");
	if(username==""){
		usernameFlag=false;
		usernameMsg.innerHTML="<font color='red'>× 请填写用户名</font>";
		return false;
	}
	else if(!valid.test(username)){
		usernameFlag=false;
		usernameMsg.innerHTML="<font color='red'>× 格式不正确</font>";
		return false;
	}
	else{
		sendRequest("RegisterControlServlet?username="+encodeURI(username));
	}
}

function checkUsernameCallback(){
	var json= XMLHttpReq.responseText;
	json = json.substring(0,4);
	var usernameMsg=document.getElementById("usernameMsg");
	if(json == "true"){
		usernameFlag=false;
		usernameMsg.innerHTML="<font color='red'>× 用户名已存在</font>";
	}else{
		usernameFlag=true;
		usernameMsg.innerHTML="<font color='green'>√</font>";
	}
}

function validPassword(){
	var length = document.getElementById("password1").value.length;
	if(length < 6){
		passwordFlag1=false;
		document.getElementById("passwordMsg1").innerHTML="<font color='red'>× 密码过短</font>";
		return false;
	}
	else{
		passwordFlag1=true;
		document.getElementById("passwordMsg1").innerHTML="<font color='green'>√</font>";
		return true;
	}
}

function checkPassword(){
	if(document.getElementById("password2").value == ""){
		passwordFlag2=false;
		document.getElementById("passwordMsg2").innerHTML="<font color='red'>× 请输入密码</font>";
		return false;
	}
	else if(document.getElementById("password1").value == document.getElementById("password2").value){
		passwordFlag2=true;
		document.getElementById("passwordMsg2").innerHTML="<font color='green'>√</font>";
		return true;
	}
	else{
		passwordFlag2=false;
		document.getElementById("passwordMsg2").innerHTML="<font color='red'>× 密码不一致</font>";
		return false;
	}
}

function checkEmail(){
	var valid = /^(\w)+@(\w)+(\.(\w)+){1,2}$/;
	if(document.getElementById("email").value == ""){
		emailFlag=false;
		document.getElementById("emailMsg").innerHTML="<font color='red'>× 请输入邮箱</font>";
		return false;
	}
	else if(valid.test(document.getElementById("email").value)){
		emailFlag=true;
		document.getElementById("emailMsg").innerHTML="<font color='green'>√</font>";
		return true;
	}
	else{
		emailFlag=false;
		document.getElementById("emailMsg").innerHTML="<font color='red'>× 格式不正确</font>";
		return false;
	}
}

function check(){
	return usernameFlag && passwordFlag1 && passwordFlag2 && emailFlag;
}