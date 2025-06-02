<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>

<div class="row py-2">
	<div class="col-md-8">
		<form id="searchForm" action="./list" method="get">
			<div class="row">
				<div class="col-md-4">
					<select class="form-select" name="type">
						<option value="">--</option>
						<option value="L">이름</option>
					</select>
				</div>
				<div class="col-md-4">
					<input class="form-control" type="text" name="keyword"
						value="${pageMaker.cri.keyword}" />
				</div>
				<div class="col-md-4">
					<button class="btn btn-outline-primary">Search</button>
				</div>
			</div>
			<input type="hidden" name="pageNum"
				value="${empty pageMaker.cri.pageNum ? 1 : pageMaker.cri.pageNum}" />
			<input type="hidden" name="amount"
				value="${empty pageMaker.cri.amount ? 10 : pageMaker.cri.amount}" />
		</form>
	</div>

	<div class="col-md-4 text-end">
		<button class="btn btn-primary text-white" onclick="toRegister()">등록</button>
	</div>

</div>

<div class="table-responsive">
	<table class="table table-striped table-hover">
		<thead>
			<tr>
				<th>#번호</th>
				<th>이름</th>
				<th>이메일</th>
				<th>고용일자</th>
				<th>급여</th>
				<th>직종</th>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>
	<my:page page="${pageMaker}"></my:page>
</div>

<script src="/springTemplate/resources/js/empList.js"></script>

<%@ include file="/WEB-INF/views/includes/footer.jsp"%>
