package com.company.book.mapper;

import java.util.List;

import com.company.book.service.BookVO;
import com.company.book.service.RentalTotalVO;

public interface BookMapper {

	public List<BookVO> selectBookAll();
	
	public BookVO selectBookOne(int bookNo);
	
	public int insertBook(BookVO book);
	
	public List<RentalTotalVO> selectRentalTotal();

}
