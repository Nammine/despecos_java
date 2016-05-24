package com.briup.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.bean.Book;
import com.briup.service.IBookService;
import com.briup.service.impl.BookServiceImpl;

/**
 * 为用户提供所有的书的信息
 * */
@WebServlet("/bookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BookServlet() {
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		IBookService bookService = new BookServiceImpl();
		List<Book> books = bookService.listAllBooks();
		//获取session用来存储数据
		HttpSession session = request.getSession();
		session.setAttribute("books", books);
		//获取分发器并进行跳转
		request.getRequestDispatcher("listBooks.jsp").forward(request, response);
		
	}

}
