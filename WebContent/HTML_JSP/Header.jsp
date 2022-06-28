<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header>
	<div id="header" style="font-family: 'Be Vietnam Pro', sans-serif;">
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarTogglerDemo01"
				aria-controls="navbarTogglerDemo01" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarTogglerDemo01">
				<a class="navbar-brand" href="<%=request.getContextPath()%>/home">
					Todo-List </a>
				<ul class="navbar-nav navbar-collapse justify-content-end">
					<c:if test="${sessionScope.username == null}">
						<li class="nav-item active"><a class="nav-link"
							href="<%=request.getContextPath()%>/login">Đăng nhập</a></li>
						<li class="nav-item"><a class="nav-link"
							href="<%=request.getContextPath()%>/register">Đăng ký</a></li>
					</c:if>
					<c:if test="${sessionScope.username != null}">
						<li class="nav-item active"><a class="nav-link" href="#">Xin
								chào ${sessionScope.name}</a></li>
						<li class="nav-item"><a class="nav-link"
							href="<%=request.getContextPath()%>/logout">Đăng xuất</a></li>
					</c:if>
				</ul>
			</div>
		</nav>
	</div>
</header>