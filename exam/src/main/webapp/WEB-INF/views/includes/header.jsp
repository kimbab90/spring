<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Title</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.7.1.min.js"
	integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<nav class="navbar navbar-expand-lg bg-body-tertiary">
			<div class="container-fluid">
				<a class="navbar-brand" href="#">도서대여관리</a>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link"
							href="/exam/register">도서등록</a></li>
						<li class="nav-item"><a class="nav-link" href="/exam/list">도서목록조회</a></li>
						<li class="nav-item"><a class="nav-link" href="/exam/rental">대여현황조회</a></li>
						<li class="nav-item"><a class="nav-link" href="/exam">홈으로</a></li>
					</ul>
				</div>
			</div>
		</nav>
		<script>
			$(document).ready(function() {
				$('.nav-link').on('click', function(e) {
					if ($(this).hasClass('disabled'))
						return;

					$('.nav-link').removeClass('active');

					$(this).addClass('active');
				});
			});
		</script>