/*
	用于登陆注册账户
	js/post.js
*/
//MVC分离业务

/* MODEL数据 */
var model = {
    post:{},
    user:{},
};

/*自动触发*/
$(function() {
//	console.log('看帖回帖页面');
	//检查是否登录
	var flag = checkLog();
	if (flag==true) {
//		发帖按钮
		$('#save_post').click(commentPostAction);
	}
	
//	自动触发加载Post孔子获取;
	loadPostAction();
});


function commentPostAction() {
	console.log('commentPostAction');
}








/*加载Post控制器方法*/
function loadPostAction() {
//	console.log('loadPostAction');
	//获取数据
	var post = result.data;
	var usr = post.user;
	//将输入存入model
	model.post = post;
	model.user = usr;
	//刷写贴子
	paintPost();
	
}


/*VIEW 刷写贴子方法*/
function paintPost() {
	//获取数据
	var post = model.post;
	var usr = model.user;
//	//抓取element
//	var title = $('#title');
//	var lead = $('.lead');
//	var content = $('#content');
	
//	title.empty();
//	lead.empty();
//	content.empty();
	
	$('#title').html('<h1 id="title">'+post.title+'</h1>');
	$('.lead').html('<p class="lead text-right"><strong>'+usr.name+'|</strong>'+post.lastModifyTime+'</p>');
	$('#content').html('<div id="content">'+post.body+'</div>');
}






