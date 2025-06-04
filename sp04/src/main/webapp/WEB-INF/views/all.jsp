<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>All</h1>

	<sec:authorize access="isAnonymous()">
		<a href="./customLogin">로그인</a>
	</sec:authorize>

	<sec:authorize access="isAuthenticated()">
		<p>
			<sec:authentication property="principal" />
		</p>
		<p>
			<sec:authentication property="principal.member" />
		</p>
		<p>
			<sec:authentication property="principal.member.userid" />
		</p>
		<p>
			<sec:authentication property="principal.member.authList" />
		</p>
		<form method='post' action="./logout">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
			<button>로그아웃</button>
		</form>
	</sec:authorize>

</body>
</html>