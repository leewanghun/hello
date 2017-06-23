package com.test.servlet;

import java.io.IOException;
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
 * Servlet implementation class DoEditProductView
 */
@WebServlet("/doEditProduct")
public class DoEditProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoEditProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		String name = request.getParameter("name");
		float price = Float.parseFloat(request.getParameter("price"));
		Product product = new Product(code, name, price);
		String errorString = null;
		try {
			DBUtils.updateProduct(MyUtils.getStoredConnection(request), product);
		} catch (SQLException e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}
		
		request.setAttribute("errorString", errorString);
		request.setAttribute("product", product);

		// Nếu có lỗi forward sang trang edit
		if (errorString != null) {
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/editProductView.jsp");
			dispatcher.forward(request, response);
		}
		// Nếu mọi thứ tốt đẹp.
		// Redirect sang trang danh sách sản phẩm.
		else {
			response.sendRedirect(request.getContextPath() + "/productList");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
