<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>

<h1>RENTAL</h1>

<div class="table-responsive text-center">
	<table class="table table-hover">
		<thead>
			<tr>
				<th>도서번호</th>
				<th>도서명</th>
				<th>대여총계</th>
				<th>대여횟수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list }" var="rental">
				<tr>
					<td><c:out value="${rental.bookNo }" /></td>
					<td><c:out value="${rental.bookName }" /></td>
					<td><fmt:formatNumber value="${rental.totalPrice }"
							pattern="#,###" /></td>
					<td>﻿<fmt:formatNumber value="${rental.totalCount }"
							pattern="#,###" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<%@ include file="/WEB-INF/views/includes/footer.jsp"%>