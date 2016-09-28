/*
	用于登陆注册账户
	js/user.js
*/

/*状态*/
var SUCCESS=0;
var ERROR=1;

/*自动触发*/
$(function() {
	console.log('注册页面');
	
	var usrName = getCookie("userName");
	if (usrName!=null && usrName.length>0) {
		$('#top_right').html('欢迎您:<p style="font-size: 24px;">'+usrName+'</p>');
		$('#denglu').empty();
		$("textarea").removeAttr("readonly");
	}
	
	$('#loginbtn').click(loginAction);
});


//登录控制器
function loginAction() {
	console.log("login click");
//	检查表单数据的正确性,将表单数据发送到服务器,
//	利用Callback处理返回结果,如果成功就跳转到登录主页,若果失显示错误消息
	var name = $('#txtName').val();
	var password = $('#txtPwd').val();
	
	//获得了正确数据
	var data = {"name":name,"password":password};
	console.log(data);
	
	$.ajax({
		url:"account/login.sya",
		method:'post',
		dataType:"JSON",
		data:data,
		success:function(result){
//			console.log(result);
			if (result.state==SUCCESS) {
				var user = result.data;
				SetCookie("userId", user.id);
				SetCookie("userName", user.name);
				
				window.location.href="send.html";
			}else {
				alert(result.message);
			}
		}
	});
}

