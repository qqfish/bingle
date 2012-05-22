var hidPosX;
var showPosX;
var curPosX;
var speed;
var dps;
var nowMouse;

function init()
{
	hidPosX = -110;
	showPosX = -10;
	curPosX = hidPosX;
	speed = 5;
	dps = 50;
	nowMouse = "off";
	document.getElementById("infoNav").style.left = curPosX+"px";
}

function showNav()
{
	if(curPosX < showPosX)
	{
		curPosX += speed;
		if(curPosX > showPosX)
			curPosX = showPosX;
		document.getElementById("infoNav").style.left = curPosX+"px";
		setTimeout('move()',1000/dps);
	}
}

function hidNav()
{
	if(curPosX > hidPosX)
	{
		curPosX -= speed;
		if(curPosX < hidPosX)
			curPosX = hidPosX;
		document.getElementById("infoNav").style.left = curPosX+"px";
		setTimeout('move()',1000/dps);
	}
}

function move()
{	
	if(nowMouse == "on" )
	{
		showNav();
	}
	else
	{
		hidNav();
	}
}

