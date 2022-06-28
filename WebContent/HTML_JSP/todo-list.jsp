<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Todo list - DatIT</title>
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
	<div class="row" style="margin-top: 50px">
		<div class="container">
			<h3 class="text-center">Quản lý công việc</h3>
			<hr>
			<div class="container text-left">
				<c:if test="${sessionScope.username != null}">
					<h4>Danh sách công việc của ${sessionScope.username}!</h4>
				</c:if>
				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Thêm</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Tên việc</th>
						<th>Thời gian</th>
						<th>Trạng thái</th>
						<th>Chức năng</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (task task: tasks) {  -->
					<c:forEach var="task" items="${tasks}">
						<tr>
							<td><c:out value="${task.title}" /></td>
							<td><c:out value="${task.target_time}" /></td>
							<td><c:out value="${task.status}" /></td>
							<td><a href="edit?id=<c:out value='${task.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out value='${task.id}' />">Delete</a></td>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>

	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>