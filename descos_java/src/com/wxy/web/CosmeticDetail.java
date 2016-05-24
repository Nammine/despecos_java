package com.wxy.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wxy.bean.Cosmetic;
import com.wxy.service.ICosmeticService;
import com.wxy.service.impl.CosmeticServiceImpl;

/**
 * Servlet implementation class CosmeticDetail
 */
@WebServlet("/cosmeticDetail")
public class CosmeticDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CosmeticDetail() {
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
		int cosmeticId=Integer.parseInt(request.getParameter("cosmeticId"));
	    ICosmeticService cosmeticService=new CosmeticServiceImpl();
	    Cosmetic cosmetic=cosmeticService.findCosmeticDetail(cosmeticId);
	    request.setAttribute("cosmetic", cosmetic);
	    RequestDispatcher rd=request.getRequestDispatcher("productDetail.jsp");
	    rd.forward(request, response);
	}

}
