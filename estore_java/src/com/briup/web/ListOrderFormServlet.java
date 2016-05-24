package com.briup.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.bean.Customer;
import com.briup.bean.OrderFrom;
import com.briup.service.IOrderFromService;
import com.briup.service.impl.OrderFromServiceImpl;
/**
 * 查找属于某个用户的所有订单
 * */
@WebServlet("/listOrderFormServlet")
public class ListOrderFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListOrderFormServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		//获取当前正在登录的用户
		Customer customer = 
				(Customer) session.getAttribute("customer");
		//当用户存在的时候
		if(customer!=null){
			IOrderFromService orderFromService = new OrderFromServiceImpl();
			//调用service方法查找所有订单
			List<OrderFrom> orderFroms = 
					orderFromService.findAllOrderFroms(customer.getId());
			request.setAttribute("orderFroms", orderFroms);
			request.getRequestDispatcher("listOrderForms.jsp").forward(request, response);
			
		}else{
		//当用户不存在，跳转到登录界面
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
