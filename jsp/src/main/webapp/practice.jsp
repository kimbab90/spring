<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	request.setAttribute("username", "Kim");
	session.setAttribute("username", "Park");
	request.setAttribute("list", Arrays.asList("MON", "TUE", "WED"));
	%>
	username : ${username}
	<br> session username : ${sessionScope.username }
	<br> parameter : ${param.age }
	<%=request.getParameter("age")%><br> parameter : ${params.age }
	<%=request.getParameterValues("age")%><br> header :
	${header["user-agent"]}
	<%=request.getHeader("user-agent")%><br> ip :
	${pageContext.request.remoteAddr }
	<%=request.getRemoteAddr()%><br>

	<!--<c:forEach items="${list }" var="day">
		<h1>${day }</h1>
	</c:forEach> -->
</body>
</html>