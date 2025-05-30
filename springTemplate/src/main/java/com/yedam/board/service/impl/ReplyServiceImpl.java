package com.yedam.board.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yedam.board.mapper.ReplyMapper;
import com.yedam.board.service.Criteria;
import com.yedam.board.service.ReplyService;
import com.yedam.board.service.ReplyVO;
import com.yedam.common.PageDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService {

	final ReplyMapper replyMapper;

	@Override
	public int register(ReplyVO vo) {
		return replyMapper.insert(vo);
	}

	@Override
	public ReplyVO get(int rno) {
		return replyMapper.read(rno);
	}

	@Override
	public int modify(ReplyVO vo) {
		return replyMapper.update(vo);
	}

	@Override
	public int remove(int rno) {
		return replyMapper.delete(rno);
	}

	@Override
	public List<ReplyVO> getList(Criteria cri, int bno) {
		return replyMapper.getList(cri, bno);
	}

	@Override
	public PageDTO getListPage(Criteria cri, int bno) {
		int count = replyMapper.getCountByBno(bno);
	
		return new PageDTO(cri, count);
	}
}
