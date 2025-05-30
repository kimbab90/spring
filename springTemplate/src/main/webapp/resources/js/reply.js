/**
 * 
 */

function getReply(pageNum = 1) {

	const url = 'http://localhost:8081/springTemplate/board/' + boardBno + '/replies?pageNum=' + pageNum;

	fetch(url, {
		method: 'GET',
	})
		.then(result => {
			console.log(result);
			return result.json();
		})
		.then(result => {
			console.log(result);
			drawReply(result.replyList);
			drawPage(result.pageMaker);
		})
		.catch(error => {
			console.log(error);
		})
		.finally(() => {
		})
};

function drawReply(replies = []) {
	$('#replyBody').html('');

	replies.forEach((reply, index) => {

		console.log(reply);

		let tr = $('<tr>' +
			'<td>' + reply.rno + '</td>' +
			'<td>' + reply.reply + '</td>' +
			'<td>' + reply.replyer + '</td>' +
			'<td>' + reply.replyDate + '</td>' +
			'<td>' + reply.updateDate + '</td>' +
			'<td><button class="btn btn-warning text-white" onclick="modifyReply(' + reply.rno + ')">수정</button>' +
			'<button class="btn btn-danger ms-2" onclick="removeReply(' + reply.rno + ')">삭제</button></td>' +
			'</tr>')

		$('#replyBody').append($(tr));
	});
};

function drawPage(pageMaker = {}) {
	
  const $nav = $('#replyPageNav');
  const $ul = $('<ul class="pagination"></ul>');
  
  if (pageMaker.prev) {
    $ul.append(`<li class="page-item"><a class="page-link" href="#" data-page="${pageMaker.startPage - 1}">Previous</a></li>`);
  }

  for (let i = pageMaker.startPage; i <= pageMaker.endPage; i++) {
    const active = pageMaker.pageNum === i ? 'active' : '';
    $ul.append(`<li class="page-item ${active}"><a class="page-link" href="#" data-page="${i}">${i}</a></li>`);
  }

  if (pageMaker.next) {
    $ul.append(`<li class="page-item"><a class="page-link" href="#" data-page="${pageMaker.endPage + 1}">Next</a></li>`);
  }

  $nav.html($ul);
  
  // 페이지 클릭 이벤트 바인딩
  $nav.find('a.page-link').on('click', function(e) {
    e.preventDefault();
    const selectedPage = $(this).data('page');
    getReply(selectedPage);
  });

}

function modifyReply(rno) {

};

function removeReply(rno) {

	showLoading();

	const url = 'http://localhost:8081/springTemplate/board/' + boardBno + '/replies/' + rno;

	fetch(url, {
		method: 'DELETE',
	})
		.then(result => {
			console.log(result);
			return result.json();
		})
		.then(result => {
			console.log(result);

			if (result.success) {
				alert(result.message);
				getReply();
			} else {
				alert(result.message);
			}

		})
		.catch(error => {
			console.log(error);
		})
		.finally(() => {
			hideLoading();
		})
};

$('#registerReplyBtn').on('click', () => {
	let reply = $('#reply').val();
	let replyer = $('#replyer').val();

	if (reply && replyer) {
		showLoading();

		const url = 'http://localhost:8081/springTemplate/board/' + boardBno + '/replies';

		let param = {
			bno: boardBno,
			reply: reply,
			replyer: replyer,
		};

		fetch(url, {
			method: 'POST',
			body: JSON.stringify(param),
			headers: {
				"Content-Type": "application/json",
			},
		})
			.then(result => {
				console.log(result);
				return result.json();
			})
			.then(result => {
				console.log(result);

				if (result.success) {
					alert(result.message);

					$('#reply').val('');
					$('#replyer').val('');

					getReply();
				} else {
					alert(result.message);
				}

			})
			.catch(error => {
				console.log(error);
			})
			.finally(() => {
				hideLoading();
			})
	} else {
		alert('댓글과 작성자를 모두 입력하세요');
	}
});