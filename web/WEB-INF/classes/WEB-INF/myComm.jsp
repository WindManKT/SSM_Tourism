<%--
  Created by IntelliJ IDEA.
  User: Nolose
  Date: 2019/12/20
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <title>About</title>
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

<%pageContext.setAttribute("myComm","active");%>
<%@include file="/WEB-INF/_head.jsp"%>

<!-- banner -->
<section class="banner_inner" id="home">
    <div class="banner_inner_overlay">
    </div>
</section>
<!-- //banner -->




<!-- tabs -->
    <div class="overlay-all py-5">
        <div class="container py-lg-5 py-sm-4">
            <h2 class="edu-exp-grids"> 我的订单</h2>
            <div class="edu-exp-grids">
                <div class="tab-main">
                    <c:forEach items="${requestScope.comms}" var="comm">
                    <h4 class="mt-md-4 mt-2">    姓名: ${comm.name} | 电话: ${comm.phone} | 目的地: ${comm.land} | 人数(大人:${comm.adults}人  小孩子:${comm.child}人) | 时间: ${comm.date}<br>
                    </h4><hr>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
<!-- tabs -->


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
