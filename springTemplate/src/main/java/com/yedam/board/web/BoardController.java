package com.yedam.board.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yedam.board.service.BoardService;
import com.yedam.board.service.BoardVO;
import com.yedam.board.service.Criteria;
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
@Controller
@RequestMapping("/boards")
public class BoardController {

	private final BoardService boardService;

//	@RequestMapping(value = "/boards", method = RequestMethod.GET)
//	@ResponseBody
//	public List<BoardVO> boards(BoardSearchVO search) {
//		List<BoardVO> list = boardService.getBoardSearch(search);
//		return list;
//	}

	/**
	 * 
	 * @param search 검색조건
	 * @param model
	 * @return 목록페이지
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getBoard(Criteria criteria, Model model) {

		List<BoardVO> list = boardService.getBoardSearch(criteria);
		model.addAttribute("list", list);

		int total = boardService.getTotalCount(criteria);
		model.addAttribute("pageMaker", new PageDTO(criteria, total));

		return "board/list";
	}

	@RequestMapping(value = "/board/{bno}", method = RequestMethod.GET)
	public String getBoard(@PathVariable(name = "bno") int bno, Model model) {
		BoardVO board = boardService.getBoardOne(bno);
		model.addAttribute("board", board);
		return "board/board";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String toRegister(@RequestParam(name = "bno", required = false, defaultValue = "0") int bno, Model model) {

		if (bno > 0) {
			BoardVO board = boardService.getBoardOne(bno);
			model.addAttribute("board", board);
		}

		return "board/register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String postBoard(BoardVO board, RedirectAttributes rttr) {

		int result = 0;
		int resultType = 0;

		if (board.getBno() > 0) {
			resultType = 1;
			result = boardService.putBoard(board);
		} else {
			result = boardService.postBoard(board);
		}

		rttr.addFlashAttribute("result", result);
		rttr.addFlashAttribute("resultType", resultType);
		rttr.addFlashAttribute("resultBno", board.getBno());

		return "redirect:./list";
	}

	@RequestMapping(value = "/delete/{bno}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResultVO deleteBoard(@PathVariable(name = "bno") int bno) {

		int queryResult = boardService.deleteBoard(bno);

		ResultVO result = new ResultVO();

		if (queryResult > 0) {
			result.setSuccess(true);
			result.setMessage("삭제 성공!");
		} else {
			result.setSuccess(false);
			result.setMessage("삭제 실패!");
		}

		return result;
	}

//	@RequestMapping(value = "/boards", method = RequestMethod.PUT)
//	@ResponseBody
//	public ResponseEntity<String> putBoard(@RequestBody BoardVO board) {
//
//		ResponseEntity<String> response;
//		int result = boardService.putBoard(board);
//		if (result > 0) {
//			response = new ResponseEntity<String>("success", HttpStatusCode.valueOf(200));
//		} else {
//			response = new ResponseEntity<String>("error", HttpStatusCode.valueOf(200));
//		}
//		
//		return response;
//	}

//	@RequestMapping(value = "/boards/{bno}", method = RequestMethod.DELETE)
//	@ResponseBody
//	public ResponseEntity<String> deleteBoard(@PathVariable(name = "bno") int bno) {
//
//		ResponseEntity<String> response;
//		int result = boardService.deleteBoard(bno);
//		if (result > 0) {
//			response = new ResponseEntity<String>("success", HttpStatusCode.valueOf(200));
//		} else {
//			response = new ResponseEntity<String>("error", HttpStatusCode.valueOf(200));
//		}
//		
//		return response;
//	}
}
