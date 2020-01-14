<%--
  Created by IntelliJ IDEA.
  User: Nolose
  Date: 2019/12/16
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- header -->
<script>
    function myFunction(){
        alert("⚠请先登录");
    }
</script>
<header>
    <div class="container">

        <!-- nav -->
        <nav class="py-md-4 py-3 d-lg-flex">
            <div id="logo">
                <h1 class="mt-md-0 mt-2"> <a href="${pageContext.request.contextPath}/index.action"><span class="fa fa-map-signs"></span> Grand Tour </a></h1>
            </div>
            <label for="drop" class="toggle"><span class="fa fa-bars"></span></label>
            <input type="checkbox" id="drop" />
            <ul class="menu ml-auto mt-1">
                <li class="${pageScope.index}"><a href="${pageContext.request.contextPath}/index.action">主页</a></li>
                <li class="${pageScope.about}"><a href="${pageContext.request.contextPath}/about.action">关于</a></li>
                <li class="${pageScope.services}"><a href="${pageContext.request.contextPath}/services.action">服务</a></li>
                <li class="${pageScope.packages}"><a href="${pageContext.request.contextPath}/packages.action">景点</a></li>

                <li class="${pageScope.myComm}"><a href="
                <c:if test="${sessionScope.user == null}">${pageContext.request.contextPath}/login.action</c:if>
                <c:if test="${sessionScope.user!=null}">${pageContext.request.contextPath}/myComm.action</c:if>
                "<c:if test="${sessionScope.user == null}">
                    onclick="myFunction()"
                </c:if>
                >我的订单</a></li>

                <li class="${pageScope.contact}"><a href="
                <c:if test="${sessionScope.user == null}">${pageContext.request.contextPath}/login.action</c:if>
                <c:if test="${sessionScope.user!=null}">${pageContext.request.contextPath}/contact.action</c:if>
                "
                <c:if test="${sessionScope.user == null}">onclick="myFunction()"</c:if>
                >联系我们</a></li>

                <li class="${pageScope.booking}"><a href="
                <c:if test="${sessionScope.user == null}">${pageContext.request.contextPath}/login.action</c:if>
                <c:if test="${sessionScope.user!=null}">${pageContext.request.contextPath}/booking.action</c:if>
                "
                <c:if test="${sessionScope.user == null}">
                   onclick="myFunction()"
                </c:if>

                >立即预定</a></li>

                <c:if test="${sessionScope.user == null}">
                    <li class="${pageScope.login}"><a href="${pageContext.request.contextPath}/login.action">登录</a></li>
                    <li class="${pageScope.regist}"><a href="${pageContext.request.contextPath}/regist.action">注册</a></li>
                </c:if>
                <c:if test="${sessionScope.user!=null}">
                    <li >欢迎${sessionScope.user.username}回来  </li>
                    <li ><a href="${pageContext.request.contextPath}/user/loginOut.action">注销</a></li>
                </c:if>
            </ul>

        </nav>
        <!-- //nav -->

    </div>
</header>
<!-- //header -->
