package com.company.book.service;

import java.util.List;

public interface BookService {

	public List<BookVO> getBookAll();
	
	public BookVO getBookOne(int bookNo);
	
	public int registerBook(BookVO book);
	
	public List<RentalTotalVO> getRentalTotal();
	
}
