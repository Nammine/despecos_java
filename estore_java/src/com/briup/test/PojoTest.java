package com.briup.test;

import com.briup.bean.Book;

public class PojoTest {
	public static void main(String[] args) {
		Book book = new Book();
		book.setId(1021);
		book.setName("birup");
		book.setPrice(23);
		book.setDescription("very good");
		int id = book.getId();
		System.out.println(id);
	}
}
