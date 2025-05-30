package com.yedam.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.board.service.Criteria;
import com.yedam.board.service.ReplyVO;

public interface ReplyMapper {
	public int insert(ReplyVO vo);

	public ReplyVO read(int rno);

	public int delete(int rno);

	public int update(ReplyVO reply);

	public List<ReplyVO> getList(@Param("cri") Criteria cri, @Param("bno") int bno);

	public int getCountByBno(int bno);
}