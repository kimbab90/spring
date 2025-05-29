package com.yedam.board.service;

import java.util.List;

public interface BoardService {

	public List<BoardVO> getBoardAll();
	
	public List<BoardVO> getBoardSearch(Criteria criteria);
	
	public int getTotalCount(Criteria criteria);

	public BoardVO getBoardOne(int bno);
	
	public int postBoard(BoardVO board);
	
	public int putBoard(BoardVO board);
	
	public int deleteBoard(int bno);
}
