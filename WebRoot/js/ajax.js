
function sendRequest() {

	// 初始化请求对象
	createXmlHttpRequest();
	if (xmlHttpReq == null) {
		alert("您的浏览器不支持AJAX！");
		return;
	}
	
	var nick_name=document.getElementById("username").value;
	var msg_content=document.getElementById("content").value;
	
	//若昵称或寄语为空则提示并退出函数
	if(nick_name==""){
		alert("昵称不能为空！");
		return;
	}else if(msg_content==""){
		alert("寄语不能为空！");
		return;
	}
	//定义发送请求的目标URL
	var url = "MessageServlet.do";

	//准备好要发送的数据   形式为：“请求参数名=请求参数值”
	var postdata = "nick_name=" + nick_name + "&msg_content=" + msg_content;
	
	//取得与服务器的链接
	//发送post请求
	xmlHttpReq.open("POST", url, true);
	//设置请求头
	xmlHttpReq.setRequestHeader("Content-Type",
			"application/x-www-form-urlencoded");
	//指定xmlHttpReq状态改变时的处理函数
	xmlHttpReq.onreadystatechange = showResponse;
	xmlHttpReq.send(postdata);

	document.getElementById("username").value="";
	document.getElementById("content").value="";
}

/* 创建Request对象 */
function createXmlHttpRequest() {

	if (window.XMLHttpRequest) {
		// chrome,firefox,opera
		xmlHttpReq = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		// Internet Explorer
		try {
			xmlHttpReq = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			xmlHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
		}
	}
}

function sendEmptyRerquest() {

	// 初始化请求对象
	createXmlHttpRequest();
	// 定义发送请求的目标URL
	var url = "MessageServlet.do";
	// 发送POST请求
	xmlHttpReq.open("POST", url, true);
	xmlHttpReq.setRequestHeader("Content-Type",
			"application/x-www-form-urllencoded");
	xmlHttpReq.onreadystatechange = showResponse;
	xmlHttpReq.send(null);
}

function showResponse() {
	
	if (xmlHttpReq.readyState == 4 && xmlHttpReq.status == 200) {
		
		var text=xmlHttpReq.responseText;
		
		//将返回的html片段写入界面
		document.getElementById('main').innerHTML = text;//xmlHttpReq.responseText;
		//调用jquery，使新加入的paper能够排版
		wishRand();
	}
}





