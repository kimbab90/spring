<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${serverTime }
	<!-- 상대 경로 -->
	<img src="../images/forKimchi.png" />
	<!-- 절대 경로 -->
	<img src="/sp00/images/forKimchi.png" />
	<!-- 절대 경로 -->
	<img src="<c:url value="/images/forKimchi.png"/>" />
</body>
</html>