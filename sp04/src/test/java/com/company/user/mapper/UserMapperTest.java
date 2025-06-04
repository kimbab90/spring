package com.company.user.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.company.user.service.MemberVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/resources/spring/*-context.xml")
public class UserMapperTest {

	@Setter(onMethod_ = { @Autowired })
	private MemberMapper mapper;
	
	@Test
	public void test() {
		
		MemberVO member = mapper.read("user");
		log.info(member);
		assertEquals(member.getUserid(), "user");
	}

}
