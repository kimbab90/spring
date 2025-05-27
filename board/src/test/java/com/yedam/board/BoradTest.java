package com.yedam.board;

import java.util.ArrayList;
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
	
//	@Test
	public void insert() {
		int queryResult = 0;
		
		for (int i = 0; i < 5; i++) {
			
			BoardVO board = BoardVO.builder()
					.title("제목" + (i+1))
					.content("내용" + (i+1))
					.writer("저자" + (i+1))
					.build();
			
			queryResult = mapper.insertBoard(board);
			
			System.out.println(queryResult);
			
		}
		
	}

	@Test
	public void test() {
		
		// 전체 조회
		
		int queryResult = 0;
		
		List<BoardVO> list = mapper.selectBoardAll();
		
		list.forEach(item -> System.out.println(item.toString()));
		

		// 단건 조회
		
		BoardVO board = mapper.selectBoardOne(1);
		
		System.out.println(board.toString());
		
		// 수정
		
		board.setTitle("제목수정");
		board.setContent("내용수정");
		
		queryResult = mapper.updateBoard(board);
		
		System.out.println(queryResult);
		
		board = mapper.selectBoardOne(1);
		
		System.out.println(board.toString());
		
		// 검색
		
		List<Integer> bnos = new ArrayList<Integer>();
		
		bnos.add(1);
		bnos.add(5);
		
		BoardSearchVO search = BoardSearchVO.builder()
//				.writer("5")
				.bnos(bnos)
				.build();
		
		list = mapper.selecBoardSearch(search);

		list.forEach(item -> System.out.println(item.toString()));
	}
}
