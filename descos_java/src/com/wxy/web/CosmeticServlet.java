package com.wxy.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wxy.bean.Cosmetic;
import com.wxy.service.ICosmeticService;
import com.wxy.service.impl.CosmeticServiceImpl;

/**
 * Servlet implementation class CosmeticServlet
 */
@WebServlet("/cosmeticServlet")
public class CosmeticServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CosmeticServlet() {
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
		ICosmeticService cosmeticService = new CosmeticServiceImpl();
		List<Cosmetic> cosmetics = cosmeticService.listAllCosmetics();
		HttpSession session = request.getSession();
		session.setAttribute("cosmetics", cosmetics);
		request.getRequestDispatcher("listCosmetics.jsp").forward(request, response);
	}

}
