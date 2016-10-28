/*
帖子列表

js/list.js

*/

//MVC分离业务


/* MODEL数据 */
var model = {
//	假象板块点击修改listmodel中的板块值
    plateID:1,
    posts:[],
    user:{},
};


/*自动触发*/
$(function() {

	//检查是否登录
	var flag = checkLog();
	
	if (flag==true) {
//		发帖按钮
		$('#save_post').click(savePostAction);
	}
	
//	自动加载本版Post列表
	listPostAction();

});





//发帖控制器
//concat()	连接两个或更多的数组，并返回结果。
function savePostAction() {
//	console.log('sendPostAction');
    //获取标题
	var title = $('#input_post_title').val();
	title = $.trim(title);
	//使用myEditorAPI getContent获取内容
	var content = um.getContent();
//	console.log(title);
	if (title=="") {
//		console.log(title);
		console.log("标题不能为空");
	}
	var data = {'title':title,'body':content,'plate':model.plateID,'userID':getCookie('userId')};
	
	$.ajax({
		url : baseUrl+"/post/save.sya",
		method : 'POST',
		dataType:'JSON',
		data : data,
		success:function(result){
			if (result.state==SUCCESS) {
				console.log('保存成功!');
				var post = result.data;
				console.log(post);
				var ary = [{author:getCookie('userName'),body:post.body,id:post.post_id,modTime:post.lastModifyTime,plate:model.plateID,title:post.title}];
//				将返回的数据存入MODEL
				model.posts = ary.concat(model.posts);
				//刷写贴子列表
				paintPosts();
				//清空编辑器
				um.setContent('');
				$('#input_post_title').val("");
				
				
			}else {
//				错误弹窗
				alert(result.message);
			}
		}
	});
}






//贴子列表请求控制器
function listPostAction() {
//	console.log('listPostAction');
	var url = baseUrl+'/post/list.sya?plateID='+model.plateID
	//请求链接
	$.getJSON(url,function(result){
//		判断返回值
		if (result.state==SUCCESS) {
			var posts = result.data;
			//将获取到的贴子存入model;
			model.posts = posts;
			//调用VIEW方法刷写界面
			paintPosts();
		}else {
//			错误弹窗
			alert(result.message);
		}
	});
}

/*
   VIEW 将MODEL中的数据更新显示到界面上
<tr><!-- 最长34个英文字符 --><td><a>0123456789012345678901234567890123</a></td>
						<td class="hidden-xs"><a>Otto</a></td>
						<td class="hidden-xs">2016-10-19 15:07:26</td>
					</tr>

   
*/
function paintPosts(){
	//获取MODEL中的数据
	var posts = model.posts;
	var tbody = $('#posts');
	//清空tbody
	tbody.empty();
	
	var url = baseUrl+'/post/post.sya?PostID=';
	
	for (var i = 0; i < posts.length; i++) {
		var post = posts[i];
		//组装postList
		var tr = '<tr><td><a href="'+url+post.id+'">'+post.title+'</a></td>'+
		             '<td class="hidden-xs"><a>'+post.author+'</a></td>'+
		             '<td class="hidden-xs">'+post.modTime+'</td></tr>';
		//将tr追加到tbody内的队尾
		tbody.append(tr);
		
		
	}
}




