package com.briup.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.bean.Book;
import com.briup.service.IBookService;
import com.briup.service.impl.BookServiceImpl;

@WebServlet("/bookDetail")
public class BookDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BookDetail() {
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//修改编码
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//获取前台页面提交过来的参数,并进行转换
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		//寻找bookId对应的书的详细信息
		IBookService bookService = new BookServiceImpl();
		
		Book book = bookService.findBookDetail(bookId);
		//展示给用户,放到requestScope
		request.setAttribute("book", book);
		//跳转到指定的界面
		  //获取分发器
		RequestDispatcher rd = 
				request.getRequestDispatcher("productDetail.jsp");
		//实现页面的跳转
		rd.forward(request, response);
		
	}

}
