/*
	用于登陆注册账户
	js/post.js
*/
//MVC分离业务

/* MODEL数据 */
var model = {
    post:{},
    user:{},
    comments:[]
};

/*自动触发*/
$(function() {
//	console.log('看帖回帖页面');
	//检查是否登录
	var flag = checkLog();
	if (flag==true) {
//		发帖按钮
		$('#send_comment').click(commentPostAction);
	}
	//自动加载贴子控制器
	loadPostAction();
});

/*回帖控制器*/
function commentPostAction() {
//	console.log('commentPostAction');
	var post = model.post;
	
	
	//使用myEditorAPI getContent获取内容
	var content = um.getContent();
	if (!um.hasContents()) {
		alert("回帖内容不能为空");
		return;
	}
	
	//body, postID, userID
	var data = {'postID':post.post_id,'userID':getCookie('userId'),'body':content};
	
	$.ajax({
		url:baseUrl+"/comment/send.sya",
		method : 'POST',
		dataType: 'JSON',
		data : data,
		success : function(result) {
			if (result.state==SUCCESS) {
				console.log('回帖成功');
				var lastComment = result.data;
//				console.log(lastComment);
				//清空编辑器
				um.setContent('');
				var ary = [lastComment];
				//将回帖的数据存入model
				model.comments = model.comments.concat(ary);
				//加载即时显示回帖方法
				paintComment();
			}else {
				alert(result.message);
			}
		}
	});
	
}
/*
				<div class="row show-grid">
					<div class="col-md-2">曹操 </br> 2016-11-15 16:40:46</div>
					<div class="col-md-10">
					</div>
				</div>
回帖VIEW 回帖直接显示到最后
TODO 设计回帖界面 目前构思是做一个table
*/
function paintComment() {
//	console.log('回帖刷写VIEW');
	//将刚刚回复的贴子添加到model回帖列表的最后
	var currentComment = model.comments[model.comments.length-1];
//	console.log(currentComment);
	var commentHTML = 
		             '<div class="row show-grid" comment_id="'+currentComment.id+'">'+
	                 '<div class="col-md-3"><strong>'+currentComment.user.name+' :</strong></br>'+currentComment.modifyTime+'</div>'+
	                 '<div class="col-md-9 comment_body">'+currentComment.body+'</div>'+
	                 '</div>';
	
	$('#comments').append(commentHTML);
}



/* js/post.js */
/*加载Post控制器方法*/
function loadPostAction() {
//	console.log('loadPostAction');
	if (result.state==SUCCESS) {
		//获取数据
		var post = result.data.post;
		var comments = result.data.comments;
		//
		var usr = post.user;
		//将输入存入model
		model.post = post;
		model.user = usr;
		model.comments = comments;
		//刷写贴子
//		paintPost();
		//刷写回帖列表
		paintComments();
	}else {
		alert(result.message);
	}

	
}

function paintComments() {
//	console.log('paintComments');
	//获取comment数组
	var comments = model.comments;
	var comments_HTML = $('#comments');
	comments_HTML.empty();
//	设计评论总数
	/*		<div id="comments_size"><h4 class="text-center">共有9条跟帖评论</h4></div>		*/
	comments_HTML.append(
			'<div id="comments_size"><h4 class="text-center">共有'+
								comments.length+'条跟帖评论</h4></div>');
	//循环取出
	for (var i = 0; i < comments.length; i++) {
		var comment = comments[i];
		var commentHTML = 
			'<div class="row show-grid" comment_id="'+comment.id+'">'+
			'<div class="col-md-3"><strong>'+comment.author+' :</strong></br>'+comment.modTime+'</div>'+
			'<div class="col-md-9 comment_body">'+comment.body+'</div>'+
			'</div>';

		comments_HTML.append(commentHTML);
	}

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

