package com.yedam.board.service;

import java.util.List;

import com.yedam.common.PageDTO;

public interface ReplyService {
	public int register(ReplyVO vo);

	public ReplyVO get(int rno);

	public int modify(ReplyVO vo);

	public int remove(int rno);

	public List<ReplyVO> getList(Criteria cri, int bno);

	public PageDTO getListPage(Criteria cri, int bno);
}