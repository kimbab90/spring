package com.example.demo.web;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = SampleController.class)
public class SampleControllerTest {

	@Autowired
	MockMvc mvc;

//	@Test
//	public void hello() throws Exception {
//
//		mvc.perform(get("/hello"))
//		.andExpect(status().isOk())
//		.andDo(print());
//
//	}
	
	@Test
	public void helloDto() throws Exception {
		
		String name = "Ellen";
		int amount = 100;
		
		
		mvc.perform(get("/hello/dto")
				.param("name", name)
				.param("amount", String.valueOf(amount)))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.name", is(name)))
		.andExpect(jsonPath("$.amount", is(amount)))
		.andDo(print());
	}

}
