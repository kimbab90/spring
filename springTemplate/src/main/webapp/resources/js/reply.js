/**
 * 
 */

let selectedRno = 0;
let isEdit = false;

function getReply(pageNum = 1) {

	const url = 'http://localhost:8081/springTemplate/board/' + boardBno + '/replies?pageNum=' + pageNum;

	fetch(url, {
		method: 'GET',
	})
		.then(result => {
			return result.json();
		})
		.then(result => {
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

	resetReplyForm();

	$('#replyBody').html('');

	replies.forEach((reply, index) => {

		let tr = $('<tr>' +
			'<td>' + reply.rno + '</td>' +
			'<td class="w-50">' + reply.reply + '</td>' +
			'<td>' + reply.replyer + '</td>' +
			'<td>' + reply.replyDate + '</td>' +
			'<td>' + reply.updateDate + '</td>' +
			'<td>' + '<button class="btn btn-danger ms-2" onclick="removeReply(event,' + reply.rno + ')">삭제</button></td>' +
			'</tr>')

		$('#replyBody').append($(tr));
	});

	$('#replyBody').on('click', 'tr', function() {

		$('#replyBody tr').removeClass('table-active');

		$(this).addClass('table-active');

		isEdit = true;
		$('#registerReplyBtn').text('수정');

		$('#rnoInput').val($(this).find('td').eq(0).text());
		$('#replyInput').val($(this).find('td').eq(1).text());
		$('#replyerInput').val($(this).find('td').eq(2).text());

	});
};

function drawPage(pageMaker = {}) {

	const $nav = $('#replyPageNav');
	const $ul = $('<ul class="pagination"></ul>');

	if (pageMaker.prev) {
		$ul.append(`<li class="page-item"><a class="page-link" href="#" data-page="${pageMaker.startPage - 1}">Previous</a></li>`);
	}

	for (let i = pageMaker.startPage; i <= pageMaker.endPage; i++) {
		const active = pageMaker.cri.pageNum === i ? 'active' : '';
		$ul.append(`<li class="page-item ${active}"><a class="page-link" href="#" data-page="${i}">${i}</a></li>`);
	}

	if (pageMaker.next) {
		$ul.append(`<li class="page-item"><a class="page-link" href="#" data-page="${pageMaker.endPage + 1}">Next</a></li>`);
	}

	$nav.html($ul);

	$nav.find('a.page-link').on('click', function(e) {
		e.preventDefault();
		const selectedPage = $(this).data('page');
		getReply(selectedPage);
	});

}

function removeReply(event, rno) {
	event.stopPropagation(); 

	showLoading();

	const url = 'http://localhost:8081/springTemplate/board/' + boardBno + '/replies/' + rno;

	fetch(url, {
		method: 'DELETE',
	})
		.then(result => result.json())
		.then(result => {
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
	let rno = $('#rnoInput');
	let reply = $('#replyInput');
	let replyer = $('#replyerInput');

	if (!reply || !replyer) {
		alert('댓글과 작성자를 모두 입력하세요');
	} else {
		showLoading();

		const url = 'http://localhost:8081/springTemplate/board/' + boardBno + '/replies';

		let param = {
			rno: rno.val() ? rno.val() : 0,
			bno: boardBno,
			reply: reply.val(),
			replyer: replyer.val(),
		};

		fetch(url, {
			method: isEdit ? 'PUT' : 'POST',
			body: JSON.stringify(param),
			headers: {
				"Content-Type": "application/json",
			},
		})
			.then(result => result.json())
			.then(result => {
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
	}
});

function resetReplyForm() {
	$('#replyRno').val('');
	$('#replyInput').val('');
	$('#replyerInput').val('');
	$('#registerReplyBtn').text('등록');
	isEdit = false;
	$('#replyBody tr').removeClass('table-active');
}

