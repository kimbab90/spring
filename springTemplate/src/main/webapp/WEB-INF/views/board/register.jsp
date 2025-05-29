<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>

<form action="./register" method="post">
	<input type="number" name="bno"
		value="${empty board.bno ? 0 : board.bno }" hidden="true">
	<div class="row">
		<label class="form-label col-md-2">제목</label>
		<div class="col-md-6">
			<input class="form-control" type="text" name="title" value="${board.title }">
		</div>
	</div>
	<div class="row">
		<label class="form-label col-md-2">내용</label>
		<div class="col-md-6">
			<textarea class="form-control" name="content">${board.content }</textarea>
		</div>
	</div>

	<div class="row">
		<label class="form-label col-md-2">작성자</label>
		<div class="col-md-6">
			<input class="form-control" type="text" name="writer"
				value="${board.writer }">
		</div>
	</div>
	<button class="btn btn-primary" type="submit">저장</button>
	<button class="btn btn-info text-white" type="reset">초기화</button>
	<button class="btn btn-secondary" type="button" onclick="location.href='./list'">취소</button>
</form>

<%@ include file="/WEB-INF/views/includes/footer.jsp"%>