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
	<h1>Admin</h1>

	<button id="logout" onclick="logout()">logout</button>

	<script>
	
		let csrfToken = "${_csrf}";
		
		function logout() {
		    const csrfToken = '${_csrf.token}';
		    const csrfParam = '${_csrf.parameterName}'; // 일반적으로 '_csrf'

		    const params = new URLSearchParams();
		    params.append(csrfParam, csrfToken);

		    fetch('/sp04/logout', {
		        method: 'POST',
		        headers: {
		            'Content-Type': 'application/x-www-form-urlencoded'
		        },
		        body: params
		    }).then(res => {
				console.log(res);
		    });
		}
	</script>
</body>
</html>