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
		$('#top_right').html('欢迎您:<p style="font-size: 24px;">'+usrName+'</p><a><p id="log_out">登出</P></a>');
		
		$("textarea").removeAttr("readonly");
	}
	
	$('#log_out').click(log_outAction);
});

/*
 * 登出控制器
 */
function log_outAction() {
	delCookie("userId");
	delCookie("userName");
	delCookie("token");
	window.location.reload();
}