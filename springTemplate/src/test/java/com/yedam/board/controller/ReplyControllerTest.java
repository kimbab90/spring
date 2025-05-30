package com.yedam.board.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yedam.board.service.ReplyVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@TestInstance(Lifecycle.PER_CLASS)
// Test for Controller
@WebAppConfiguration
@ExtendWith(SpringExtension.class)
@ContextConfiguration({ "file:src/main/resources/spring/*-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
public class ReplyControllerTest {

	@Setter(onMethod_ = { @Autowired })
	private WebApplicationContext ctx;

	private MockMvc mockMvc;

	@BeforeAll
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}

	@Test
	public void testList() throws Exception {
		ReplyVO reply = new ReplyVO();
		reply.setBno(160);
		reply.setReply("마이콜");
		reply.setReplyer("댓글작성");
		String jsonStr = new ObjectMapper().writeValueAsString(reply);

		mockMvc.perform(MockMvcRequestBuilders
				.post("/board/160/replies")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(jsonStr))
		.andDo(print());
//		.andExpect(status().is(200))
//		.andReturn().getResponse().getContentAsString();
//		.andDo(print());
	}
}