<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Đăng Ký Thành Viên</title>
<link rel="icon" type="image/x-icon" href="./IMG/favicon.svg">
<meta charset="utf-8">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/style.css">
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
	<div class="container col-md-5">
		<div class="card marg-top" style="margin-top: 40px">
			<div class="card-body">
				<c:if test="${task != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${task == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${task != null}">Chỉnh sửa công việc</c:if>
						<c:if test="${task == null}">Thêm mới công việc</c:if>
					</h2>
				</caption>
				
				<c:if test="${task != null}">
					<input type="hidden" name="id" value="<c:out value='${task.id}' />" />
				</c:if>
				
				<fieldset class="form-group">
					<label>Title</label> <input type="text"
						value="<c:out value='${task.title}' />" class="form-control"
						name="title" required="required" minlength="5">
				</fieldset>
				

				<fieldset class="form-group">
					<label>Decription</label> <input type="text"
						value="<c:out value='${task.description}' />" class="form-control"
						name="description" minlength="5">
				</fieldset>

				<fieldset class="form-group">
					<label>Status</label> <select class="form-control" name="status">
						<option value="false">In Progress</option>
						<option value="true">Complete</option>
					</select>
				</fieldset>

				<fieldset class="form-group">
					<label>Target Date</label> <input type="date"
						value="<c:out value='${task.target_time}'/>" class="form-control"
						name="target_time" required="required">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>