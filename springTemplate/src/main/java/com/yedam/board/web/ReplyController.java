package com.yedam.board.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.board.service.Criteria;
import com.yedam.board.service.ReplyPageVO;
import com.yedam.board.service.ReplyService;
import com.yedam.board.service.ReplyVO;
import com.yedam.board.service.ResultVO;
import com.yedam.common.PageDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 게시글관리 작성자 | 작성일자 | 수정내용 김민식 | 2025-05-28 | 최초 등록
 * 
 * 
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/board/{bno}/replies")
public class ReplyController {

	final ReplyService replyService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<ReplyPageVO> getReply(Criteria cri, @PathVariable("bno") int bno) {
		cri.setAmount(5);
		ReplyPageVO rp = new ReplyPageVO();
		List<ReplyVO> list = replyService.getList(cri, bno);
		PageDTO page = replyService.getListPage(cri, bno);
		rp.setReplyList(list);
		rp.setPageMaker(page);
		return ResponseEntity.status(HttpStatus.OK).body(rp);
	}

	@RequestMapping(value = "/{rno}", method = RequestMethod.GET)
	public ResponseEntity<ReplyVO> getReplyOne(@PathVariable int rno) {
		ReplyVO reply = replyService.get(rno);
		return ResponseEntity.status(HttpStatus.OK).body(reply);
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<ResultVO> postReply(@RequestBody ReplyVO reply) {

		ResultVO result = new ResultVO();

		int queryResult = replyService.register(reply);

		result.setSuccess(queryResult > 0);
		result.setMessage(queryResult > 0 ? "성공" : "실패");

		return ResponseEntity.status(HttpStatus.OK).body(result);
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public ResponseEntity<ResultVO> updateReply(@RequestBody ReplyVO reply) {

		ResultVO result = new ResultVO();

		int queryResult = replyService.modify(reply);

		result.setSuccess(queryResult > 0);
		result.setMessage(queryResult > 0 ? "성공" : "실패");

		return ResponseEntity.status(HttpStatus.OK).body(result);

	}

	@RequestMapping(value = "/{rno}", method = RequestMethod.DELETE)
	public ResponseEntity<ResultVO> deleteReply(@PathVariable(name = "rno") int rno) {

		ResultVO result = new ResultVO();

		int queryResult = replyService.remove(rno);

		result.setSuccess(queryResult > 0);
		result.setMessage(queryResult > 0 ? "성공" : "실패");

		return ResponseEntity.status(HttpStatus.OK).body(result);
	}

}
