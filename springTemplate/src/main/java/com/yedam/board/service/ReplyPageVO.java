package com.yedam.board.service;

import java.util.List;

import com.yedam.common.PageDTO;

import lombok.Data;

@Data
public class ReplyPageVO {

	private List<ReplyVO> replyList;
	private PageDTO pageMaker;
}
