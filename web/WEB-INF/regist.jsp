<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
	<title>Booking</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta charset="utf-8">
	<meta name="keywords" content="" />

	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.2.js"></script>

	<script>
		addEventListener("load", function () {
			setTimeout(hideURLbar, 0);
		}, false);

		function hideURLbar() {
			window.scrollTo(0, 1);
		}

		$(function () {
			//验证码刷新
			$("#img").click(function () {
				var time = new Date().getTime();
				//点击图片，更新图片
				$("#img").attr("src","${pageContext.request.contextPath}/user/Verify.action?time="+time);
			});
		})
	</script>

	<!-- css files -->
	<link href="${pageContext.request.contextPath}/css/bootstrap.css" rel='stylesheet' type='text/css' /><!-- bootstrap css -->
	<link href="${pageContext.request.contextPath}/css/style.css" rel='stylesheet' type='text/css' /><!-- custom css -->
	<link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet"><!-- fontawesome css -->
	<!-- //css files -->

	<!-- google fonts -->
	<link href="http://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">
	<link href="http://fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
	<!-- //google fonts -->

</head>
<body>

<%pageContext.setAttribute("regist","active");%>
<%@include file="/WEB-INF/_head.jsp"%>

<!-- banner -->
<section class="banner_inner" id="home">
	<div class="banner_inner_overlay">
	</div>
</section>
<!-- //banner -->


<!-- Booking -->
<div class="container py-lg-5 py-sm-4">
	<span style="color: #dc3545">${msg}</span>
	<h2 class="heading text-capitalize text-center mb-lg-5 mb-4"><a href="#">注册</a>/<a href="${pageContext.request.contextPath}/login.action">登录</a></h2>

	<form action="/user/regist.action" method="post" class="row">
		<div class="col-sm-6 form-group contact-forms">
			<input type="text" name="username" class="form-control" placeholder="请输入您的用户名" required="" value="${param.username}">
		</div>
		<div class="col-sm-6 form-group contact-forms">
			<input type="email" name="email" class="form-control" placeholder="请输入您的邮箱" required="" value="${param.email}">
		</div>
		<div class="col-sm-6 form-group contact-forms">
			<input type="password" name="password" class="form-control" placeholder="请输入您的密码" required="">
		</div>
		<div class="col-sm-6 form-group contact-forms">
			<input type="password" name="password2" class="form-control" placeholder="请确认您的密码" required="">
		</div>
		<div class="col-sm-6 form-group contact-forms">
			<input type="text" name="vcode" class="form-control" placeholder="请输入验证码" required="">
		</div>
		<div class="col-sm-6 form-group contact-forms">
			<img id="img" src="${pageContext.request.contextPath}/user/Verify.action">
		</div>

			<button style="width: 60%; margin-left:auto;margin-right:auto;"  class="btn btn-block sent-butnn">注册</button>
	</form>
</div>
<!-- //Booking -->


<%@include file="/WEB-INF/_foot.jsp"%>

<!-- move top -->
<div class="move-top text-right">
	<a href="#home" class="move-top">
		<span class="fa fa-angle-up  mb-3" aria-hidden="true"></span>
	</a>
</div>
<!-- move top -->


</body>
</html>