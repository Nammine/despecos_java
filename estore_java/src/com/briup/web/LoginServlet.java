package com.briup.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.bean.Cart;
import com.briup.bean.Customer;
import com.briup.service.ICustomerService;
import com.briup.service.impl.CustomerServiceImpl;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//获取session
		HttpSession session = request.getSession();
		
		//获取前台页面的参数
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		//调用service方法
		ICustomerService customerService = new CustomerServiceImpl();
		Customer customer = 
				customerService.login(name, password);
		//如果用户登录成功
		if(customer != null ){
			Cart cart = new Cart();
			//向session里面放值(购物车，用户信息)
			session.setAttribute("cart", cart);
			session.setAttribute("customer", customer);
			//获取分发器
			RequestDispatcher rd = 
					request.getRequestDispatcher("bookServlet");
			//进行跳转
			rd.forward(request, response);
		}else{
			//重定向跳转
			response.sendRedirect("login.jsp");
		}
		
		
	}

}
