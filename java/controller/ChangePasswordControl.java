package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.model.User;
import service.UserService;


@WebServlet(name = "/changePasswordControl", value = "/change_password")
public final class ChangePasswordControl extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String currentPassword = request.getParameter("currentPassword");
		String newPassword = request.getParameter("newPasswprd");
		String confirmPassword = request.getParameter("confirmPassword");
		
		if (!newPassword.equals(confirmPassword)) {
			request.setAttribute("mess", "Mật khẩu không khớp!");
			request.getRequestDispatcher("change_password.jsp").forward(request, response);
			return;
		}
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		if (user != null && user.getPassword().equals(currentPassword)) {
			UserService userService = new UserService();
			try {
				boolean success = userService.changePassword(user.getId(), newPassword);
				if (success) {
					request.setAttribute("mess", "Đổi mật khẩu thành công!");
					response.sendRedirect("HomePage.jsp");
					return;
				}
			} catch (SQLException | ClassNotFoundException e) {
				throw new RuntimeException(e);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("change_password.jsp").forward(request, response);
	}

}
