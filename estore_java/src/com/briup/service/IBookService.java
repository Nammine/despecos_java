package com.briup.service;

import java.util.List;

import com.briup.bean.Book;

public interface IBookService {
	/**
	 * 列出所有的书籍
	 * */
	List<Book> listAllBooks();
	/**
	 * 根据书的id来查找的书
	 * */
	Book findBookDetail(int bookId);

}
