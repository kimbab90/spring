<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="./register" method="post">
		<input type="text" name="bno" value="${empty board.bno ? 0 : board.bno }" hidden="true">
		<label>제목</label>
		<input type="text" name="title" value="${board.title }">
		<br>
		<label>내용</label>
		<textarea name="content">${board.content }</textarea>
		<br>
		<label>작성자</label>
		<input type="text" name="writer" value="${board.writer }">
	<button type="submit">저장</button>
	</form>
	<button onclick="location.href='./list'">취소</button>
</body>
</html>