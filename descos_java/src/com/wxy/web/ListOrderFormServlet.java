package com.wxy.web;
/**
 * ����ĳ���û��Ķ���
 */

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wxy.bean.Customer;
import com.wxy.bean.OrderForm;
import com.wxy.service.IOrderFormService;

import com.wxy.service.impl.OrderFormServiceImpl;


/**
 * Servlet implementation class ListorderFormservlet
 */
@WebServlet("/listOrderFormServlet")
public class ListOrderFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListOrderFormServlet() {
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
		Customer customer=(Customer) session.getAttribute("customer");
		if(customer!=null)
		{
			IOrderFormService orderFormservice=new OrderFormServiceImpl();
			List<OrderForm> orderForms=orderFormservice.findAllOrderFroms(customer.getId());
			request.setAttribute("orderForms", orderForms);
			request.getRequestDispatcher("listorderforms.jsp").forward(request,response);
		}
		else
		{
			request.getRequestDispatcher("home.html");
		}
	}

}
