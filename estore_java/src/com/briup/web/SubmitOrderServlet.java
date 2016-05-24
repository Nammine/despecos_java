package com.briup.web;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.bean.Cart;
import com.briup.bean.Customer;
import com.briup.bean.OrderFrom;
import com.briup.bean.Orderline;
import com.briup.common.HL;
import com.briup.service.IOrderFromService;
import com.briup.service.IOrderLineService;
import com.briup.service.impl.OrderFromServiceImpl;
import com.briup.service.impl.OrderLineServiceImpl;

@WebServlet("/submitOrderServlet")
public class SubmitOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SubmitOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	/**
	 * 提交订单，将订单，订单项，分别插入到对应的数据库表中
	 * */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//获取购物车以及用户信息
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		Customer customer = (Customer) session.getAttribute("customer");
		
		OrderFrom orderFrom = new OrderFrom();
		orderFrom.setId(HL.getId());
		orderFrom.setCustomerid(customer.getId());
		orderFrom.setCost(cart.getCost());
		orderFrom.setOrderdate(new Date());
		//调用service,执行插入操作
		IOrderFromService orderFromService = new OrderFromServiceImpl();
		orderFromService.addOrderFrom(orderFrom);
		IOrderLineService orderLineService = new OrderLineServiceImpl();
		
		//取出所有订单项,遍历，然后插入到数据库中
		List<Orderline> orderlines = cart.getOrderLines();
		for(int i=0;i<orderlines.size(); i++){
			Orderline orderline = orderlines.get(i);
			orderline.setId(HL.getId());
			orderline.setOrderFromId(orderFrom.getId());
			orderLineService.addOrderLine(orderline);
		}
		//清空购物车
		Cart nullCart = new Cart();
		session.setAttribute("cart", nullCart );
		//跳转到显示该用户所有订单的页面
		request.getRequestDispatcher("listOrderFormServlet").forward(request, response);
	}

}
