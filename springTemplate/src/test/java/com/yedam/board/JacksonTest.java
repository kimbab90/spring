package com.yedam.board;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yedam.board.mapper.ReplyMapper;
import com.yedam.sample.web.SampleVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@ExtendWith(SpringExtension.class) 
@ContextConfiguration("file:src/main/resources/spring/*-context.xml")
public class JacksonTest {
	
	@Setter(onMethod_ = { @Autowired })
	private ReplyMapper replyMapper;
	
	@Test
	public void test() throws JsonProcessingException {
		SampleVO sample = new SampleVO(10, "길동", "홍");
		
		ObjectMapper mapper = new ObjectMapper();
		
		String str = mapper.writeValueAsString(sample);
		
		log.info(str);
		
		String json = "{\"mno\":10,\"firstName\":\"길동\",\"lastName\":\"홍\"}";
		
		SampleVO result = mapper.readValue(json, SampleVO.class);
		
		log.info(result);
				
	}

}
