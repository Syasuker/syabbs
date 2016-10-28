<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Bootstrap -->
    <link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css">
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
	    var data = ${jsonResult};
	</script>
	<div id="wrap">
		<!-- table-responsive -->
		<div id="bodyer" class="container">
			<div class="starter-template">
				<h1 id="title">ERROR, ${Emsg} </h1>
			</div>
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
</body>
</html>