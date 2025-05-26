package com.yedam.board;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.board.mapper.BoardMapper;
import com.yedam.board.model.BoardSearchVO;
import com.yedam.board.model.BoardVO;

import lombok.Setter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/datasource-context.xml",
		"classpath:/spring/mybatis-context.xml" })
public class BoradTest {
	
	@Setter(onMethod_ = { @Autowired })
	private BoardMapper mapper;


	@Test
	public void test() {
		
		int queryResult = 0;
		
//		BoardVO board = BoardVO.builder()
//				.title("제목2")
//				.content("내용2")
//				.writer("이순신")
//				.build();
//		
//		queryResult = mapper.insertBoard(board);
//		
//		System.out.println(queryResult);
		
		List<BoardVO> list = mapper.selectBoardAll();
		
		list.forEach(item -> System.out.println(item.toString()));
		
		
		
		BoardVO board = mapper.selectBoardOne(1);
		
		System.out.println(board.toString());
		
		
		
		board.setTitle("제목수정");
		board.setContent("내용수정");
		
		queryResult = mapper.updateBoard(board);
		
		board = mapper.selectBoardOne(1);
		
		System.out.println(board.toString());
		
		
		
		BoardSearchVO search = BoardSearchVO.builder()
				.writer("이순신")
				.build();
		
		list = mapper.selecBoardSearch(search);

		list.forEach(item -> System.out.println(item.toString()));
	}
}
