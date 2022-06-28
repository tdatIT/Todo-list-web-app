<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<title>Đăng nhập</title>
<meta charset="utf-8">
<link rel="icon" type="image/x-icon" href="./IMG/favicon.svg">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
	crossorigin="anonymous">
<link rel="stylesheet" href="../style.css">
<script src="https://kit.fontawesome.com/ae7c745789.js"
	crossorigin="anonymous"></script>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Be+Vietnam+Pro:wght@500&display=swap"
	rel="stylesheet">
</head>

</head>

<body>
	<jsp:include page="Header.jsp"></jsp:include>
	<div id="input-form">
		<div class="container">
			<div class="row">
				<div class="col-md-4"></div>
				<div class="col-md-4 form-content" style="margin-top: 40px;border: 2px solid;border-radius: 6px">
					<h4 style="margin: 16px 0px;">Đăng nhập</h4>
					<c:if test="${NOTIFY=='FAIL'}">
						  <div class="alert alert-danger center" role="alert">
                        <p>Sai tài khoản hoặc mật khẩu !!!</p>
                     </div>
					</c:if>
					<form action="<%=request.getContextPath()%>/login" method="post">
						<div class="form-group">
							<label for="uname">Tài khoản</label> <input type="text"
								class="form-control" id="username" placeholder="Username"
								name="username" required>
						</div>
						<div class="form-group">
							<label for="uname">Mật khẩu</label> <input type="password"
								class="form-control" id="password" placeholder="Password"
								name="password" required>
						</div>
						<button type="submit" class="btn btn-primary mb-3">Đăng
							nhập</button>
					</form>
				</div>
				<div class="col-md-4"></div>
			</div>
		</div>
	</div>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>

</html>