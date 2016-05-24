package com.briup.test;

import java.util.ArrayList;
import java.util.List;

import com.briup.bean.Book;

public class ListTest {
	public static void main(String[] args) {
		List<Book> list = new ArrayList<>();
		Book book1 = new Book();
		book1.setId(1);
		book1.setName("java");
		book1.setPrice(22);
		
		Book book2 = new Book();
		book2.setId(12);
		book2.setName("java2");
		book2.setPrice(223);
		
		list.add(book1);
		list.add(book2);
		
		System.out.println(list.size());
		for(int i =0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	}

	
}
