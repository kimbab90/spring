<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table border="1">
		<thead>
		</thead>
		<tbody>
			<tr>
				<th>#번호</th>
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
				<td>${board.regdate }</td>
			</tr>
			<tr>
				<th>수정일</th>
				<td>${board.updatedate }</td>
			</tr>
		</tbody>
	</table>
	<button
		onclick="location.href='../register?bno=${board.bno }'">수정</button>
	<button onclick="deleteBoard()">삭제</button>
	<button onclick="location.href='../list'">뒤로</button>

	<script type="text/javascript">
	const boardBno = "${board.bno}";
	  
	function deleteBoard() {
	    fetch("http://localhost:8081/springTemplate/boards/delete/" + boardBno, {
	        method: 'DELETE',
	    })
	    .then(result => {
	    	console.log(result);
	        return result.text();
	    })
	    .then((result) => {
	    	const deleteResult = parseInt(result);
	        if (deleteResult > 0) {
	            alert('삭제 성공');
		    	location.href = '../list';
	        } else {
	            alert('삭제 실패');
	        }
	    })
	    .catch(error => {
	    	console.log(error);
	    });
	}
	</script>
</body>
</html>