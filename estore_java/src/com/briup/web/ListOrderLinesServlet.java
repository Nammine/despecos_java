package com.briup.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.bean.Orderline;
import com.briup.service.IOrderLineService;
import com.briup.service.impl.OrderLineServiceImpl;
/**
 * 
 * 根据前台传过来的订单的Id,来查找所有属于该订单的订单项
 * */
@WebServlet("/listOrderLinesServlet")
public class ListOrderLinesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListOrderLinesServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//获取参数
		int orderFormId = Integer.parseInt(request.getParameter("orderFormId"));
		IOrderLineService orderLineService = new OrderLineServiceImpl();
		List<Orderline> orderLines = 
				orderLineService.findAllOrderlines(orderFormId);
		//将查找的信息放入到request范围
		request.setAttribute("orderLines", orderLines);
		//页面的跳转
		request.getRequestDispatcher("listOrderLines.jsp").forward(request, response);
		
	}

}
