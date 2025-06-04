<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>

<h1>BOOKLIST</h1>

<div class="table-responsive text-center">
	<table class="table table-hover">
		<thead>
			<tr>
				<th>도서번호</th>
				<th>도서명</th>
				<th>표지</th>
				<th>출판일자</th>
				<th>금액</th>
				<th>출판사</th>
				<th>도서소개</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list }" var="book">
				<tr>
					<td><c:out value="${book.bookNo }" /></td>
					<td><c:out value="${book.bookName }" /></td>
					<td><img style="width: 50px;"
						src="./resources/images/<c:out value="${book.bookCoverimg }" />"></td>
					<td><fmt:formatDate pattern="yyyy/MM/dd"
							value="${book.bookDate }" /></td>
					<td>﻿<fmt:formatNumber value="${book.bookPrice}"
							pattern="#,###" /></td>
					<td><c:out value="${book.bookPublisher }" /></td>
					<td><c:out value="${book.bookInfo }" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<div class="modal fade" id="myModal" tabindex="-1">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title" id="myModalLabel">Modal title</h4>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<div class="modal-body"></div>
			<div class="modal-footer">
				<button type="button" id="btnClose" class="btn btn-default"
					data-bs-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>

<script>
	$(document).ready(function() {

		let result = '${result}';
		let bookNo = '${bookNo}';

		console.log(result);
		console.log(bookNo);

		checkModal(result);

		function checkModal(result) {

			if (result === '') {
				return;
			}

			if (parseInt(result) > 0) {
				$(".modal-body").html(parseInt(bookNo) + " 번 도서가 등록되었습니다.");
			}

			const options = {
				backdrop : false,
				focus : false,
				keyboard : true
			}
			const myModal = document.getElementById('myModal')
			const myModalAlternative = new bootstrap.Modal('#myModal', options)
			myModalAlternative.show(myModal)
		}

	});
</script>

<%@ include file="/WEB-INF/views/includes/footer.jsp"%>