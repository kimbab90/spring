package com.yedam.board.mapper;

import java.util.List;

import com.yedam.board.model.BoardSearchVO;
import com.yedam.board.model.BoardVO;

public interface BoardMapper {

	List<BoardVO> selectBoardAll();
	
	List<BoardVO> selecBoardSearch(BoardSearchVO boardSearch);
	
	BoardVO selectBoardOne(int bno);
	
	int insertBoard(BoardVO board);
	
	int updateBoard(BoardVO board);
	
	int deleteBoard(BoardVO board);
	
}