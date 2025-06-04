package com.company.book.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.book.mapper.BookMapper;
import com.company.book.service.BookService;
import com.company.book.service.BookVO;
import com.company.book.service.RentalTotalVO;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookMapper bookMapper;

	@Override
	public List<BookVO> getBookAll() {
		return bookMapper.selectBookAll();
	}

	@Override
	public BookVO getBookOne(int bookNo) {
		return bookMapper.selectBookOne(bookNo);
	}

	@Override
	public int registerBook(BookVO book) {
		return bookMapper.insertBook(book);
	}

	@Override
	public List<RentalTotalVO> getRentalTotal() {
		return bookMapper.selectRentalTotal();
	}
}
