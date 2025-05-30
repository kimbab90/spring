<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>

<table class="table">
	<thead>
	</thead>
	<tbody>
		<tr>
			<th style="width: 100px;">#번호</th>
			<td>${board.bno }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${board.title }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${board.content }</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${board.writer }</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td><fmt:formatDate pattern="yyyy-MM-dd"
					value="${board.regdate }" /></td>
		</tr>
		<tr>
			<th>수정일</th>
			<td><fmt:formatDate pattern="yyyy-MM-dd"
					value="${board.updatedate }" /></td>
		</tr>
	</tbody>
</table>
<div>
	<button class="btn btn-warning text-white"
		onclick="location.href='../register?bno=${board.bno }'">수정</button>
	<button class="btn btn-danger" onclick="deleteBoard()">삭제</button>
	<button class="btn btn-secondary text-white"
		onclick="location.href='../list'">뒤로</button>
</div>

<div class="row g-3 align-items-center my-2">
	<div class="col-md-1">
		<label for="reply" class="col-form-label">댓글</label>
	</div>
	<div class="col-md-4">
		<input type="text" id="reply" name="reply" class="form-control">
	</div>

	<div class="col-md-1">
		<label for="replyer" class="col-form-label">작성자</label>
	</div>
	<div class="col-md-2">
		<input type="text" id="replyer" name="replyer" class="form-control">
	</div>
	<div class="col-auto">
		<button class="btn btn-primary text-white" id="registerReplyBtn">등록</button>
	</div>
</div>


<table class="table table-striped text-center align-middle">
	<thead>
		<tr>
			<th>순번</th>
			<th>내용</th>
			<th>작성자</th>
			<th>작성일자</th>
			<th>수정일자</th>
			<th></th>
		</tr>
	</thead>
	<tbody id="replyBody">
	</tbody>
</table>

<nav aria-label="Page navigation example" id="replyPageNav">
</nav>

<div id="loadingOverlay"
	class="position-fixed top-0 start-0 w-100 h-100 d-none bg-dark bg-opacity-50 d-flex justify-content-center align-items-center"
	style="z-index: 1050;">
	<div class="spinner-border text-light" role="status"
		style="width: 3rem; height: 3rem;">
		<span class="visually-hidden">Loading...</span>
	</div>
</div>

<script src="/springTemplate/resources/js/reply.js"></script>
<script type="text/javascript">
	const boardBno = `${board.bno}`;
	
	getReply();
	
	function deleteBoard() {
	    fetch(`http://localhost:8081/springTemplate/boards/delete/` + boardBno, {
	        method: 'DELETE',
	    })
	    .then(result => {
	    	console.log(result);
	        return result.json();
	    })
	    .then((result) => {
	        if (result.success) {
	            alert(result.message);
		    	location.href = '../list';
	        } else {
	            alert(result.message);
	        }
	    })
	    .catch(error => {
	    	console.log(error);
	    });
	}
	
	function showLoading() {
		$('#loadingOverlay').removeClass('d-none');
	}

	function hideLoading() {
		$('#loadingOverlay').addClass('d-none');
	}
	
	</script>
<%@ include file="/WEB-INF/views/includes/footer.jsp"%>