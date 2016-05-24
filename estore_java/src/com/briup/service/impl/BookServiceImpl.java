package com.briup.service.impl;

import java.util.List;

import com.briup.bean.Book;
import com.briup.dao.BookDao;
import com.briup.service.IBookService;

public class BookServiceImpl implements IBookService{
	/**
	 * 
	 * */
	@Override
	public List<Book> listAllBooks() {
		//创建一个bookDao对象
		BookDao bookDao = new BookDao();
		List<Book> list = bookDao.findAllBooks();
		return list;
	}
	/**
	 * 查找一本书的相信信息
	 * */
	@Override
	public Book findBookDetail(int bookId) {
		//创建dao对象，调用dao层方法
		BookDao bookDao = new BookDao();
		Book book = bookDao.findBookById(bookId);
		return book;
	}

}
