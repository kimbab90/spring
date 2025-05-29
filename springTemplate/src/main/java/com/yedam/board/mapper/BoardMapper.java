package com.yedam.board.mapper;

import java.util.List;

import com.yedam.board.service.BoardVO;
import com.yedam.board.service.Criteria;

public interface BoardMapper {

	List<BoardVO> selectBoardAll();

	List<BoardVO> selecBoardSearch(Criteria criteria);

	int getTotalCount(Criteria criteria);

	BoardVO selectBoardOne(int bno);

	int insertBoard(BoardVO board);

	int updateBoard(BoardVO board);

	int deleteBoard(int bno);

}