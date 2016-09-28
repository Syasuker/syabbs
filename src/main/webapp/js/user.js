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
	$('#start').click(registAction);
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
				SetCookie("userNick", user.nick);
				
				window.location.href="send.html";
			}else {
				alert(result.message);
			}
		}
	});
}




/*注册控制器*/
function registAction() {
	var name = $('#user').val();
	var password = $('#i1').val();
	var repeat_password = $('#i2').val();
	var mobile = $('#phone').val();
	console.log(name);
	console.log(password);
	console.log(repeat_password);
	console.log(mobile);
	$.ajax({
		url:'account/regist.sya',
		method:'post',
		dataType:"JSON",
		data:{"name":name,"password":password,"mobile":mobile},
		success:function(result){
//			console.log(result);//接收服务器返回的数据
			if (result.state==SUCCESS) {
				alert('注册成功');
				window.location.href="page.html";
				//清空登录成功后输入的账户昵称
//				$('input[type=text],input[type=password]').val('');
				//填充注册用户名到登录窗口
//				$('#count').val(result.data.name);
//				$('#password').focus();//移动输入焦点到选择器password输入框		jQuery 事件 - focus() 方法
//				$('#back').click();
			}else {
//				alert(result.message);
//				$('#regist_username').addClass("error").next().show().html('<span>'+result.message+'</span>');
//				$('#warning_1>span').html(result.message).parent().show();
				alert(result.message);
			}
		}
	});
}