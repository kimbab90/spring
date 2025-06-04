package com.company.book.service;

import lombok.Data;

@Data
public class RentalTotalVO {
	
	private int bookNo;
	private String bookName;
	private int totalPrice;
	private int totalCount;
	
}
