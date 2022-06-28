<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<title>Đăng Ký Thành Viên</title>
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
<body>
	<jsp:include page="Header.jsp"></jsp:include>
	<div id="input-form">
		<div class="container">
			<div class="row">
				<div class="col-md-4"></div>
				<div class="col-md-4 form-content" style="margin-top: 40px;border: 2px solid;border-radius: 6px">
					<h4 style="margin: 16px 0px;">Đăng ký thông tin</h4>
					<c:if test="${NOTIFY == 'SUCCESS'}">
						<div class="alert alert-success center" role="alert">
							<p>Đăng ký thành công. Vui lòng đăng nhập lại</p>
						</div>
					</c:if>
					<c:if test="${NOTIFY == 'FAIL'}">
						<div class="alert alert-danger center" role="alert">
							<p>Đăng ký thất bại</p>
						</div>
					</c:if>
					<form action="<%=request.getContextPath()%>\register" method="post">
						<div class="form-group">
							<label for="uname">Tên </label> <input type="text"
								class="form-control" id="name" placeholder="Tên" name="name"
								required minlength="3">
						</div>
						<div class="form-group">
							<label for="uname">Tài khoản</label> <input type="text"
								class="form-control" id="username" placeholder="Tài khoản"
								name="username" required minlength="8">
						</div>
						<div class="form-group">
							<label for="uname">Mật khẩu</label> <input type="password"
								class="form-control" id="pass" placeholder="Mật khẩu"
								name="pass" required minlength="8">
						</div>
						<button type="submit" class="btn btn-primary mb-3">Đăng
							ký</button>
					</form>
				</div>
				<div class="col-md-4"></div>
			</div>
		</div>
	</div>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>

</html>