package com.wxy.web;
/**
 * 
 */
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wxy.bean.Cart;
import com.wxy.bean.OrderLine;

/**
 * Servlet implementation class AddToCart
 */
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
		String cosmeticId = request.getParameter("cosmeticId");
		System.out.println(cosmeticId+"-------");
		if(cosmeticId == null){
			
		}else{
			//获取购物车
			Cart cart = (Cart) session.getAttribute("cart");
			//将cosmeticID转换为int类型
			int id = Integer.parseInt(cosmeticId);
			cart.add(id);
			//进行跳转
			request.getRequestDispatcher("shopcart.jsp").forward(request, response);

		}
	}

}