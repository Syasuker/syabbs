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
	
	//首先刷新验证码
	flushCodeImg();
	//点击刷新验证码
	$('.getimgcode').click(function(){
		/*使用class选择器同步更新所有的验证码图片*/
		console.log('点击刷新验证码');
		flushCodeImg();
	});
	
	//焦点离开获取校验验证码
	$('#login_code').blur(function(){
		console.log('验证验证码');
		_this = $(this);
		var code = _this.val();
		console.log(code);
		
		$('#login_msg').children().removeClass('alert-success');
		$('#login_msg').children().addClass('alert-danger');
		
		var url = baseUrl+"/account/checkCode.sya?code="+code;
		
		$.getJSON(url,function(result) {
			if (result.state==SUCCESS) {
				console.log('验证码成');
//				console.log(_this.parent());
				_this.parent().removeClass('has-error');
				_this.parent().addClass('has-success');
				
				$('#login_msg').addClass('hidden');
				
			}else {
				console.log('验证码败');
//				console.log(_this.parent());
				_this.parent().removeClass('has-success');
				_this.parent().addClass('has-error');
				$('#login_msg').removeClass('hidden');
				$('#login_msg').children().html(result.message);
				flushCodeImg();
			}
		});
	});
	
	$('#signin').click(signinAction);
	$('#login').click(loginAction);
});


/*验证码刷新方法*/
function flushCodeImg(){
	/*相对路径是相对于localhost/name/	*/
	var url = baseUrl+'/account/code.sya?'+Math.random();
	$('.getimgcode').attr('src',url);
}



//登录控制器
function loginAction() {
	console.log("login click");
//	检查表单数据的正确性,将表单数据发送到服务器,
//	利用Callback处理返回结果,如果成功就跳转到登录主页,若果失显示错误消息
	var name = $('#login_usr').val();
	var pwd = $('#login_pwd').val();
	var code = $('#login_code').val();
	
	//验证用户名规则
	var nameReg = /^\w{2,10}$/;
	//密码验证规则
	var pwdReg = /^\w{6,10}$/;
	
	
	$('#login_usr').parent().removeClass('has-error');
	if (!nameReg.test(name)) {
		$('#login_msg').removeClass('hidden');
		$('#login_msg').children().html('用户名或密码错误');
		$('#login_usr').parent().addClass('has-error');
		return false;
	}
	
	$('#login_pwd').parent().removeClass('has-error');
	if (!pwdReg.test(pwd)) {
		$('#login_msg').removeClass('hidden');
		$('#login_msg').children().html('用户名或密码错误');
		$('#login_usr').parent().addClass('has-error');
		return false;
	}
	
	$('#login_code').parent().removeClass('has-error');
	if (''==code) {
		$('#login_msg').removeClass('hidden');
		$('#login_msg').children().html('验证码不能为空');
		$('#login_usr').parent().addClass('has-error');
		return false;
	}
	
	
	//获得了正确数据
	var data = {"name":name,"password":pwd,"code":code};
	console.log(data);
	
	$.ajax({
		url:baseUrl+"/account/login.sya",
		method:'post',
		dataType:"JSON",
		data:data,
		success:function(result){
//			console.log(result);
			if (result.state==SUCCESS) {
				var user = result.data;
				addCookie("userId", user.id,CookieTime,CookiePath);
				addCookie("userName", user.name,CookieTime,CookiePath);
				/*跳转页面*/
				window.location.href=baseUrl+"/list.html?"+new Date().getTime();
			}else {
				$('#login_msg').removeClass('hidden');
				$('#login_msg').children().html(result.message);
				flushCodeImg();
			}
		}
	});
	
}

/*注册控制器*/
function signinAction(){
	var mobile = $('#mobile').val();
	var name = $('#signin_usr').val();
	var pwd = $('#signin_pwd').val();
	var repwd = $('#signin_repwd').val();
	var agree = $('#usr_agreement').is(':checked');
	
//	console.log(mobile);
//	console.log(name);
//	console.log(pwd);
//	console.log(repwd);
	
	//Js验证 用户协议
	if(!$('#usr_agreement').is(':checked')){
		console.log('请同意用户协议');
		$('#register_msg').removeClass('hidden');
		$('#register_msg').children().html('请勾选同意用户注册协议');
	}
	
	//手机号规则
	var mobile_reg=/^[1][358][0-9]{9}$/;
	//验证用户名规则
	var nameReg = /^\w{2,10}$/;
	//密码验证规则
	var pwdReg = /^\w{6,10}$/;
	
	$('#mobile').parent().removeClass('has-error');
	if (!mobile_reg.test(mobile)) {
		console.log('请输入11位的手机号');
		$('#register_msg').removeClass('hidden');
		$('#register_msg').children().html('请输入11位的手机号');
		$('#mobile').parent().addClass('has-error');
		return false;
	}
	
	$('#signin_usr').parent().removeClass('has-error');
	if (!nameReg.test(name)) {
		console.log('请输入2-10个英文字符的作为用户名');
		$('#register_msg').removeClass('hidden');
		$('#register_msg').children().html('请输入2-10个英文字符的作为用户名');
		$('#signin_usr').parent().addClass('has-error');
		return false;
	}
	
	$('#signin_pwd').parent().removeClass('has-error');
	if (!pwdReg.test(pwd)) {
		console.log('请输入6-10个英文字符的作为密码');
		$('#register_msg').removeClass('hidden');
		$('#register_msg').children().html('请输入6-10个英文字符的作为密码');
		$('#signin_pwd').parent().addClass('has-error');
		return false;
	}
	
	$('#signin_repwd').parent().removeClass('has-error');
	if (repwd!=pwd) {
		console.log('两次输入的密码不一致,请重新输入密码');
		$('#register_msg').removeClass('hidden');
		$('#register_msg').children().html('两次输入的密码不一致,请重新输入密码');
		$('#signin_repwd').parent().addClass('has-error');
		return false;
	}
	
	
	//验证通过
	$('#register_msg').addClass('hidden');
	//发送请求
	$.ajax({
		url:baseUrl+'/account/regist.sya',
		method:'post',
		dataType:'JSON',
		data:{"name":name,"password":pwd,"mobile":mobile,"repwd":repwd,"agree":agree},
		
		success:function(result){
			console.log(result);//接收服务器返回的数据
			if (result.state==SUCCESS) {
				//清理注册输入框
				$('input[type=text],input[type=password]').val('');
				
				//点击登录
				$('#to_login').click();
				
				//注册成功,请登录!
				$('#login_msg').removeClass('hidden');
				$('#login_msg').children().removeClass('alert-danger');
				$('#login_msg').children().addClass('alert-success');
				$('#login_msg').children().html('注册成功,请登录!');
				
				//填充用户名
				$('#login_usr').val(result.data.name);
				//将光标移动到密码框
				$('#login_pwd').focus();
				
				
			}else {
				$('#register_msg').removeClass('hidden');
				$('#register_msg').children().html(result.message);
			}
		}
	});
	
}

