package com.company.book;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.company.book.mapper.BookMapper;
import com.company.book.service.BookVO;

import lombok.Setter;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/resources/spring/*-context.xml")
public class BookMapperTest {

	@Setter(onMethod_ = @Autowired)
	private BookMapper bookMapper;

	@Test
	public void test() {

		List<BookVO> list = bookMapper.selectBookAll();
		assertNotNull(list);

	}
}
