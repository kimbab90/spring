<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Custom Login</h1>
	<form method="POST" action="./login">
		<div>
			<input type="text" name="username"> <input type="password"
				name="password">
		</div>
		<div>
			<button type="submit">로그인</button>
			<button type="reset">초기화</button>
		</div>
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token }">
	</form>
</body>
</html>
