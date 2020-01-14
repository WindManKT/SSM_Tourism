<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
<title>Booking</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="utf-8">
<meta name="keywords" content="" />

    <script>
        addEventListener("load", function () {
            setTimeout(hideURLbar, 0);
        }, false);

        function hideURLbar() {
            window.scrollTo(0, 1);
        }
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

<%pageContext.setAttribute("booking","active");%>
<%@include file="/WEB-INF/_head.jsp"%>

<!-- banner -->
<section class="banner_inner" id="home">
	<div class="banner_inner_overlay">
	</div>
</section>
<!-- //banner -->


<!-- Booking -->
<section class="contact py-5">
	<div class="container py-lg-5 py-sm-4">
		<h2 class="heading text-capitalize text-c7 x't'c'xenter mb-lg-5 mb-4"> Book Your Tour</h2>
		<span style="color: #dc3545">${msg}</span>
		<div class="contact-grids">
			<div class="row">
				<div class="col-lg-7 contact-left-form">
					<form action="${pageContext.request.contextPath}/Order/Commander.action" method="post" class="row">
						<div class="col-sm-6 form-group contact-forms">
							<input type="text" readonly   unselectable="on" name="land" class="form-control" placeholder="未选择" value="${requestScope.land==null?param.land:requestScope.land}" required="">
						</div>
						<div class="col-sm-6 form-group contact-forms">
							<a  class="btn btn-success" href="${pageContext.request.contextPath}/packages.action">选择景点</a>
						</div>
						<div class="col-sm-6 form-group contact-forms">
							<input type="text" class="form-control" name="name" value="${param.name}" placeholder="姓名" required="">
						</div>
						<div class="col-sm-6 form-group contact-forms">
							<input type="text" class="form-control" name="phone" value="${param.phone}" placeholder="手机" required="">
						</div>
						<div class="col-sm-6 form-group contact-forms">
							<select name="adults" class="form-control" id="adults">
								<option value="1">1位大人</option>
								<option value="2">2位大人</option>
								<option value="3">3位大人</option>
								<option value="4">4位大人</option>
								<option value="5">5个以上</option>
							</select>
						</div>
						<div class="col-sm-6 form-group contact-forms">
							<select name="child" class="form-control" id="kids">
								<option value="0">0个小孩</option>
								<option value="1">1个小孩</option>
								<option value="2">2个小孩</option>
								<option value="3">3个小孩</option>
								<option value="4">4个小孩</option>
								<option value="5">5个以上</option>
							</select>
						</div>

						<div class="col-sm-12 form-group contact-forms">
							<input type="date" name="date" class="form-control" value="${param.date}" placeholder="Date" required="">
						</div>
						<div class="col-md-12 booking-button">
							<button class="btn btn-block sent-butnn">立即预定</button>
						</div>
					</form>
				</div>
				<div class="col-lg-5 contact-right pl-lg-5">
				
					<div class="image-tour position-relative">
						<img src="images/banner1.jpg" alt="" class="img-fluid" />
						<p><span class="fa fa-tags"></span> <span>20$ - 15% off</span></p>
					</div>
					
					<h4>Tour Description</h4>
					<p class="mt-3">Duis nisi sapien, elementum finibus ferme ntum ed eget, aliquet et leo. Mauris hendrerit vel ex.
					vitae luctus massa. Phas ellus sed aliquam leo et dolor. Vestibulum ullamcorper massa eut sed fringilla.</p>
					
				</div>
			</div>
		</div>
	</div>
</section>
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