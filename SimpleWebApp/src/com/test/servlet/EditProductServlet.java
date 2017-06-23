package com.test.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.bean.Product;
import com.test.utils.DBUtils;
import com.test.utils.MyUtils;

/**
 * Servlet implementation class EditProductServlet
 */
@WebServlet("/editProduct")
public class EditProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Connection connection = MyUtils.getStoredConnection(request);
		String code = request.getParameter("code");
		Product product = null;
		String errorString = null;
		try {
			product = DBUtils.findProduct(connection, code);
		} catch (SQLException e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}
		
		
		request.setAttribute("product", product);
		request.setAttribute("errorString", errorString);
		
		
		RequestDispatcher dispatch = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/editProductView.jsp");
		dispatch.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
