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
<button class="btn btn-warning text-white" onclick="location.href='../register?bno=${board.bno }'">수정</button>
<button class="btn btn-danger text-white" onclick="deleteBoard()">삭제</button>
<button class="btn btn-secondary text-white" onclick="location.href='../list'">뒤로</button>

<script type="text/javascript">
	const boardBno = "${board.bno}";
	  
	function deleteBoard() {
	    fetch("http://localhost:8081/springTemplate/boards/delete/" + boardBno, {
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
	</script>
<%@ include file="/WEB-INF/views/includes/footer.jsp"%>