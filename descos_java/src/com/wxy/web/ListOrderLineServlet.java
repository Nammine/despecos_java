package com.wxy.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wxy.bean.OrderLine;
import com.wxy.service.IOrderLineService;
import com.wxy.service.impl.OrderLineServiceImpl;

/**
 * Servlet implementation class ListOrderLineServlet
 */
@WebServlet("/listOrderLineServlet")
public class ListOrderLineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListOrderLineServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//获取参数
		int orderFormId = Integer.parseInt(request.getParameter("orderFormId"));
		IOrderLineService orderLineService = new OrderLineServiceImpl();
		List<OrderLine> orderLines = 
				orderLineService.findAllOrderlines(orderFormId);
		//将查找的信息放入到request范围
		request.setAttribute("orderLines", orderLines);
		//页面的跳转
		request.getRequestDispatcher("listOrderLines.jsp").forward(request, response);
	}

}
