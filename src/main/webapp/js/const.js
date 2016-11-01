/*	js/const.js */	
/*全局配置文件*/



//获取url地址根目录  当前taomcat下路径  
function getRootPath()  
{  
   var pathName = window.location.pathname.substring(1);  
   var webName = pathName == '' ? '' : pathName.substring(0, pathName.indexOf('/'));  
   return window.location.protocol + '//' + window.location.host + '/'+ webName;  
}  


//得到当前目录后并返回上一层目录    
function getImgPath()  
{  
   var pathName = window.location.pathname.substring(1);  
   var webName = pathName == '' ? '' : pathName.substring(0, pathName.indexOf('/'));  
   var urlpath= window.location.protocol + '//' + window.location.host + '/'+ webName;  
   return urlpath.substring(0,urlpath.lastIndexOf("/"));  
}  



//js获取项目根路径，如： http://localhost:8083/uimcardprj  
function getRootPath(){  
    //获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp  
    var curWwwPath=window.document.location.href;  
    //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp  
    var pathName=window.document.location.pathname;  
    var pos=curWwwPath.indexOf(pathName);  
    //获取主机地址，如： http://localhost:8083  
    var localhostPaht=curWwwPath.substring(0,pos);  
    //获取带"/"的项目名，如：/uimcardprj  
    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);  
    return(localhostPaht+projectName);  
}  

/*全局变量根目录*/
var baseUrl = getRootPath();

/*状态*/
var SUCCESS=0;
var ERROR=1;

/*Cookie变量*/
var CookiePath="/syabbs";
//默认三天3*24小时
var CookieTime=3*24;






//检查是否登录方法
function checkLog() {
	//TODO Cookie令牌验证
	var usrName = getCookie("userName");
	if (usrName!=null && usrName.length>0) {
		//用户已登录
		$('#usr').html(usrName+'<b class="caret"></b>');
		/* 登出按钮 */
		$('#log_out').click(log_outAction);
		return true;

	}else {
		/*若没有用户登录则点击跳转到登录页面*/
		/*删除下拉菜单*/
		$('#usr').next().remove();
		$('#usr').click(goto_loginAction);
		
		//修改发帖按钮跳转到登录界面
		$('#save_post').click(goto_loginAction);
		$('#save_post').html('请登录');
		//锁编辑框为不可编辑
		um.setDisabled();
		//隐藏编辑框
//		um.setHide();
		//隐藏整个发帖功能
//		$('#post').hide();
	}
}





/*删除Cookied的登出方法*/
function log_outAction() {
	delCookie("userId",CookiePath);
	delCookie("userName",CookiePath);
//	delCookie("token");
	window.location.reload();
}


/*跳转登录页面方法*/
function goto_loginAction() {
//	console.log('登录页面');
	window.location.href=baseUrl+"/signin.html";
}











