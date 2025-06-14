package com.yedam.board.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yedam.board.mapper.BoardMapper;
import com.yedam.board.service.BoardService;
import com.yedam.board.service.BoardVO;
import com.yedam.board.service.Criteria;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

	final BoardMapper boardMapper;

	@Override
	public List<BoardVO> getBoardAll() {
		List<BoardVO> list = boardMapper.selectBoardAll();
		return list;
	}

	@Override
	public List<BoardVO> getBoardSearch(Criteria criteria) {
		
		List<BoardVO> list = boardMapper.selecBoardSearch(criteria);
//		List<BoardVO> list = boardMapper.selectBoardAll();
		
		return list;
	}

	@Override
	public int getTotalCount(Criteria criteria) {
		return boardMapper.getTotalCount(criteria);
	}
	
	@Override
	public BoardVO getBoardOne(int bno) {
		BoardVO board = boardMapper.selectBoardOne(bno);
		return board;
	}

	@Override
	public int postBoard(BoardVO board) {
		return boardMapper.insertBoard(board);
	}
	
	@Override
	public int putBoard(BoardVO board) {
		return boardMapper.updateBoard(board);
	}

	@Override
	public int deleteBoard(int bno) {
		return boardMapper.deleteBoard(bno);
	}

}
