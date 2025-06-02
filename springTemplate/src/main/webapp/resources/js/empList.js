/**
 * 
 */

$(document).ready(
	function() {

		const searchForm = $("#searchForm");

		function getEmployeeList() {

			const params = new URLSearchParams();
			let type = $('input[name="type"]').val();
			let keyword = $('input[name="keyword"]').val();
			let pageNum = $('input[name="pageNum"]').val();
			
			if (type) params.append('type', type);
			if (keyword) params.append('keyword', keyword);
			params.append('keyword', pageNum);

			//fetch('http://localhost:8081/springTemplate/employees/getList', {
			//	method: 'GET',
			//})
		}



		// 등록 페이지 이동
		function toRegister() {
			location.href = './register';
		}

		// 검색 조건 유지
		$('[name="type"]').val('${pageMaker.cri.type}');

		// 검색 처리
		$("#searchForm button").on("click", function(e) {
			if (!searchForm.find("option:selected").val()) {
				alert("검색종류를 선택하세요");
				return false;
			}

			if (!searchForm.find("input[name='keyword']").val()) {
				alert("키워드를 입력하세요");
				return false;
			}

			searchForm.find("input[name='pageNum']").val("1");
			e.preventDefault();
			searchForm.submit();
		});

		// 페이징 active 처리
		$(".pagination a").on(
			"click",
			function(e) {
				e.preventDefault();
				searchForm.find("input[name='pageNum']").val(
					$(this).attr("href"));
				searchForm.submit();
			});
	});