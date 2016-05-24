package com.briup.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.bean.Cart;


@WebServlet("/addToCart")
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddToCart() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		//获取参数
		String bookId = request.getParameter("bookId");
		if(bookId == null){
			
		}else{
			//获取购物车
			Cart cart = (Cart) session.getAttribute("cart");
			//将BookID转换为int类型
			int id = Integer.parseInt(bookId);
			cart.add(id);
			//进行跳转
			request.getRequestDispatcher("shopcart.jsp").forward(request, response);
		}
	}

}
