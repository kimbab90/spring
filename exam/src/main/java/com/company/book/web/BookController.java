package com.company.book.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.book.service.BookService;
import com.company.book.service.BookVO;
import com.company.book.service.RentalTotalVO;
import com.company.book.service.ResultVO;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping("/")
	private String home() {
		return "home";
	}

	// 도서 목록 조회 페이지
	@GetMapping("/list")
	private String list(Model model) {
		List<BookVO> list = bookService.getBookAll();
		model.addAttribute("list", list);
		return "book/list";
	}

	// 도서 조회 페이지
	@GetMapping("/list/{bookNo}")
	private String book(@PathVariable(name = "bookNo") int bookNo, Model model) {
		BookVO book = bookService.getBookOne(bookNo);
		model.addAttribute("book", book);
		return "book/book";
	}

	// 도서 등록 페이지
	@GetMapping("/register")
	private String register() {
		return "book/register";
	}

	// 도서 등록 처리
	@PostMapping("/register")
	@ResponseBody
	private ResultVO register(@RequestBody BookVO book) {
		
		ResultVO result = new ResultVO();
		
		int row = bookService.registerBook(book);
		
		if (row > 0) {
			result.setSuccess(true);
		} else {
			result.setSuccess(false);
		}
		
		return result;
	}

	// 대여 조회 페이지
	@GetMapping("/rental")
	private String rental(Model model) {
		List<RentalTotalVO> list = bookService.getRentalTotal();
		model.addAttribute("list", list);
		return "book/rental";
	}

}
