package com.yedam.board;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.yedam.board.mapper.ReplyMapper;
import com.yedam.board.service.Criteria;
import com.yedam.board.service.ReplyVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@ExtendWith(SpringExtension.class) 
@ContextConfiguration("file:src/main/resources/spring/*-context.xml")
public class ReplyTest {
	
	@Setter(onMethod_ = { @Autowired })
	private ReplyMapper replyMapper;
	
//	@Test
	public void test() {
		ReplyVO vo = new ReplyVO();
		
		vo.setBno(160);
		vo.setReply("22");
		vo.setReplyer("r22");
		
		replyMapper.insert(vo);
	}
	
//	@Test
	public void test2() {
		Criteria cri = new Criteria();
		
		List<ReplyVO> list = replyMapper.getList(cri, 160);
		list.forEach(item -> {
			System.out.println(item);
		});
		
		ReplyVO reply = replyMapper.read(2);
		System.out.println(reply);
	}
	
//	@Test
	public void test3() {
		ReplyVO vo = new ReplyVO();
		
		vo.setRno(2);
		vo.setReply("33");
		
		replyMapper.update(vo);
		
		replyMapper.delete(3);
	}


}
