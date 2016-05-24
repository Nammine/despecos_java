package com.wxy.web;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wxy.bean.Cart;
import com.wxy.bean.Customer;
import com.wxy.bean.OrderForm;
import com.wxy.bean.OrderLine;
import com.wxy.common.HL;
import com.wxy.service.IOrderFormService;
import com.wxy.service.IOrderLineService;
import com.wxy.service.impl.OrderFormServiceImpl;
import com.wxy.service.impl.OrderLineServiceImpl;

/**
 * Servlet implementation class SubmitOrderServlet
 */
@WebServlet("/submitOrderServlet")
public class SubmitOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitOrderServlet() {
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
	    HttpSession session=request.getSession();
	    Cart cart=(Cart) session.getAttribute("cart");
	    Customer customer=(Customer) session.getAttribute("customer");
	    OrderForm OrderForm=new OrderForm();
	    OrderForm.setId(HL.getId());
	    OrderForm.setCustomerId(customer.getId());
	    OrderForm.setCost(cart.getCost());
	    OrderForm.setOrderDate(new Date());
	    IOrderFormService OrderFormService=new OrderFormServiceImpl();
	    OrderFormService.addOrderForm(OrderForm);
	    IOrderLineService orderLineService=new OrderLineServiceImpl();
	    List<OrderLine> orderlines=cart.getOrderLines();
	    for(int i=0;i<orderlines.size();i++){
	    	OrderLine orderline=orderlines.get(i);
	    	orderline.setId(HL.getId());
	    	orderline.setOrderFormId(OrderForm.getId());
	    	orderLineService.addOrderLine(orderline);
	    }
	    request.getRequestDispatcher("listOrderFormServlet").forward(request, response);
	}

}
