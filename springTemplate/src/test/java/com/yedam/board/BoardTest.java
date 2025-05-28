package com.yedam.board;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.yedam.board.mapper.BoardMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@ExtendWith(SpringExtension.class) 
@ContextConfiguration("file:src/main/resources/spring/*-context.xml")
public class BoardTest {
	
	@Setter(onMethod_ = { @Autowired })
	private BoardMapper boardMapper;
	
	@Test
	public void test() {
		boardMapper.selectBoardAll().forEach(board -> log.info(board));
	}
}
