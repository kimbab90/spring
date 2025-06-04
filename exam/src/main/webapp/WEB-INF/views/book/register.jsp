<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>

<h1>REGISTER</h1>

<div class="row mb-2">
	<label class="form-label col-md-2">도서명</label>
	<div class="col-md-6">
		<input class="form-control" type="text" name="bookName">
	</div>
</div>

<div class="row mb-2">
	<label class="form-label col-md-2">도서표지</label>
	<div class="col-md-3">
		<input class="form-control" type="text" name="bookCoverimg">
	</div>
</div>

<div class="row mb-2">
	<label class="form-label col-md-2">출판일자</label>
	<div class="col-md-3">
		<input class="form-control" type="date" name="bookDate">
	</div>
</div>

<div class="row mb-2">
	<label class="form-label col-md-2">금액</label>
	<div class="col-md-3">
		<input class="form-control" type="number" name="bookPrice">
	</div>
</div>

<div class="row mb-2">
	<label class="form-label col-md-2">출판사</label>
	<div class="col-md-3">
		<input class="form-control" type="text" name="bookPublisher">
	</div>
</div>

<div class="row mb-2">
	<label class="form-label col-md-2">도서소개</label>
	<div class="col-md-6">
		<textarea class="form-control" name="bookInfo" rows="" cols=""></textarea>
	</div>
</div>

<button class="btn btn-primary" onclick="register()">등록</button>

<script>
	function register() {
		
		let bookNameInput = $('input[name="bookName"]');
		
		if (!bookNameInput.val()) {
		 	alert('도서명이 없습니다');
		 	bookNameInput.focus();
		 	return;
		} else {
			
			let param = {
					bookName: bookNameInput.val(),
					bookCoverimg: $('input[name="bookCoverimg"]').val(),
					bookDate: $('input[name="bookDate"]').val(),
					bookPrice: $('input[name="bookPrice"]').val(),
					bookPublisher: $('input[name="bookPublisher"]').val(),
					bookInfo: $('textarea[name="bookInfo"]').val(),
				};
			
			fetch('./register', {
				method: 'POST',
				body: JSON.stringify(param),
				headers: {
					"Content-Type": "application/json",
				},
			})
				.then(result => result.json())
				.then(result => {
					if (result) {
						alert('도서가 등록되었습니다');
						
						location.href = './list';
					} else {
						alert('도서 등록 중 오류가 발생했습니다');
					}
				})
				.catch(error => {
					console.log(error);
				})
		}
	}
</script>

<%@ include file="/WEB-INF/views/includes/footer.jsp"%>