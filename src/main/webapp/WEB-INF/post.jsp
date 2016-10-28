<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Bootstrap -->
    <link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/post.css">
    <link rel="stylesheet" href="../css/list.css">
    <link rel="stylesheet" href="../css/const.css">
    <link rel="stylesheet" href="../css/sticky-footer.css" >
    <link rel="stylesheet" href="../css/navbar-static-top.css" >
    
    
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="http://cdn.bootcss.com/html5shiv/3.7.0/html5shiv.min.js"></script>
        <script src="http://cdn.bootcss.com/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
    
    <!-- 引入脚本 -->
<script type="text/javascript" src="../js/cookie_util.js"></script>
<script type="text/javascript" src="../bootstrap/js/jquery-1.11.3.js"></script>
<script type="text/javascript" src="../js/const.js"></script>
<script type="text/javascript" src="../js/post.js"></script>




<title>贴子&回复</title>
</head>
<body>
	<!-- 页眉 -->
	<div class="navbar navbar-default navbar-static-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="javascript:window.location.href=baseUrl;">SyaBBS</a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#about">About</a></li>
					<li><a href="#contact">Contact</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">Dropdown <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="#">Action</a></li>
							<li><a href="#">Another action</a></li>
							<li><a href="#">Something else here</a></li>
							<li class="divider"></li>
							<li class="dropdown-header">Nav header</li>
							<li><a href="#">Separated link</a></li>
							<li><a href="#">One more separated link</a></li>
						</ul></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="../navbar/index.html">Default</a></li>
					<li class=""><a href="index.html">Static top</a></li>
					<li class="dropdown">
					    <a id="usr" href="signin.html" class="dropdown-toggle" data-toggle="dropdown" style="font-weight: bold ;">登录</a>
					    <ul class="dropdown-menu">
							<li><a href="#">我的个人页面</a></li>
							<li class="divider"></li>
							<li class="dropdown-header"></li>
							<li><a id="setting" href="#">设置</a></li>
							<li><a id="log_out" href="#">登出</a></li>
						</ul>
					</li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</div>
	<!-- 页眉 -->

	<!-- 页面主体 -->
	<script type="text/javascript">
	    /* 返回的jsonResult数据 */
	    var result = ${jsonResult};
	</script>
	<div id="wrap">
		<!-- table-responsive -->
		<div id="bodyer" class="container">
			<div class="starter-template">
				<h1 id="title">hello world!Title</h1>
				<p class="lead">
					Use this document as a way to quickly start any new project.<br>
					All you get is this text and a mostly barebones HTML document.
				</p>
				<hr>
				<div id="content">贴子</div>
			</div>
			
			
			
			<!-- 翻页部分 -->
			<div>
				<ul class="pager">
					<li class="previous"><a href="#">&larr; 前一页</a></li>
					<ul class="pagination hidden-xs">
						<li class="disabled"><a href="#">&laquo;</a></li>
						<li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">5</a></li>
						<li><a href="#">&raquo;</a></li>
					</ul>
					<li class="next"><a href="#">后一页 &rarr;</a></li>
					</ul>
			</div>
			<!-- 翻页部分 -->

			<!-- 回帖部分 -->
			<div id="post">
				<aside class="side-right" id='third_side_right'>
					<div class="module" data-toggle="niceScroll">
						<div class="chat-contact">
							<div class="contact-body clear_margin">
								<!--- 标题 --->
								<!-- 
								<div class="row">
									<div class="col-xs-12">
										<input type="text" class="form-control" id="input_post_title"
											placeholder='标题...'>
									</div>
								</div>
								 -->
								<!--- 标题 --->
								<!--- 输入框 --->
								<div class="row">
									<div class="col-xs-12">
										<script type="text/plain" id="myEditor"
											style="width: 100%; height: 150px;">
										</script>
									</div>
								</div>
								<!--- 输入框 --->
								<!-- 发帖按钮 -->
								<div class="row">
									<div class="col-xs-12">
										<button type="button" class="btn btn-block btn-primary"
											id="save_post">回复帖子</button>
									</div>
								</div>
								<!-- 发帖按钮 -->
							</div>
						</div>
				</aside>
			</div>
			<!-- 回帖部分 -->
			
		</div>
	</div>
	<!-- 页面主体 -->
	



	<!-- 页脚 -->
	<div id="footer">
		<div class="container">
			<p class="text-muted">SyaBBS &copy Power By <a href="https://github.com/Syasuker/syabbs">Syasuker</a></p>
		</div>
	</div>
	<!-- 页脚 -->
	
	<!-- 引入Bootstrap框架 -->
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="../bootstrap/js/jquery-1.11.3.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="../bootstrap/js/bootstrap.min.js"></script>
    
        
    <!-- Ueditor编辑器CSS -->
	<link href="../css/umeditor.min.css" type="text/css" rel="stylesheet">
	<!-- Ueditor编辑器JS -->
	<script type="text/javascript" charset="utf-8" src="../js/ue/umeditor.config.js"></script>
	<script type="text/javascript" charset="utf-8" src="../js/ue/umeditor.min.js"></script>
	<script type="text/javascript" src="../js/ue/lang/zh-cn.js"></script>
	<script type="text/javascript">
		//实例化Ueditor编辑器
		var um = UM.getEditor('myEditor');
		//初始化内容使之可以被<p>包裹 
		um.setContent('');
	</script>    
</body>
</html>