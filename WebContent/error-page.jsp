<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<style>
.banner {
	background-image: linear-gradient(rgba(0,0,0,0.75),rgba(0,0,0,0.75)),url(./IMG/error.jpg) !important;
}
</style>
<head>
<title>TodoList App - DatIT</title>
<link rel="stylesheet" href="CSS/style.css">
<meta charset="utf-8">
<link rel="icon" type="image/x-icon" href="IMG/favicon.svg">
<script src="https://kit.fontawesome.com/ae7c745789.js"
	crossorigin="anonymous"></script>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Be+Vietnam+Pro:wght@500&display=swap"
	rel="stylesheet">
</head>
<body>
	<div class="banner">
		<div class="navbar">
			<img src="IMG/list.png" class="logo"
				alt="https://www.flaticon.com/free-icons/list">
			<ul>
				<li><a href="/TodolistApp/home">TRANG CHỦ</a></li>
				<li><a href="/TodolistApp/list">QUẢN LÝ</a></li>
				<li><a href="/TodolistApp/into">GIỚI THIỆU</a></li>
			</ul>
		</div>
	</div>
	<div class="content">
		<h1>Huhu ! Hệ thống lỗi rồi...</h1>
		<p>Error Code: ${code_error}</p>
		<div>
			<a href="/TodolistApp/home">
				<button type="button">
					<span></span>Back To Home
				</button>
			</a>

		</div>
	</div>

</body>
</html>