<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table border="1">
		<thead>
			<tr>
				<th>#번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>수정일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list }" var="board">
				<tr onclick="location.href='./board/${board.bno }'">
					<td><c:out value="${board.bno }" /></td>
					<td><c:out value="${board.title }" /></td>
					<td><c:out value="${board.writer }" /></td>
					<td><c:out value="${board.regdate }" /></td>
					<td><c:out value="${board.updatedate }" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<button onclick="location.href='./register'">등록</button>

	<script>
	</script>
</body>
</html>

