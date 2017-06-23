package com.test.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.bean.UserAccount;
import com.test.utils.MyUtils;

/**
 * Servlet implementation class userinfo
 */
@WebServlet(urlPatterns = { "/userInfo" })
public class userinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public userinfo() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		// Kiểm tra người dùng login chưa
		UserAccount loginedUser = MyUtils.getLoginedUser(session);

		// Chưa login.
		if (loginedUser == null) {
			// Chuyển hướng về trang login.
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		// Ghi thông tin vào request trước khi forward.
		request.setAttribute("user", loginedUser);

		// Đã login rồi thì chuyển tiếp sang /WEB-INF/views/userInfoView.jsp
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/userInfoView.jsp");
		dispatcher.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}