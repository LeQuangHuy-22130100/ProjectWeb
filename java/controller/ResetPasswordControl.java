package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.model.User;
import service.UserService;

/**
 * Servlet implementation class ResetPasswordControl
 */
@WebServlet(name = "/ResetPasswordControl", value = "/reset_password")
public class ResetPasswordControl extends HttpServlet {
	private UserService userService = new UserService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getSession().getAttribute("username").toString();
        String currentPassword = request.getParameter("currentPassword");
        String newPassword = request.getParameter("newPassword");
        String confirmPassword = request.getParameter("confirmPassword");

        try {
            if (!newPassword.equals(confirmPassword)) {
                request.setAttribute("mess", "Mật khẩu mới không khớp");
                request.getRequestDispatcher("reset_password.jsp").forward(request, response);
                return;
            }

            User user = userService.resetPassword(username, currentPassword, newPassword);
            
            if (user != null) {
                response.sendRedirect("HomePage.jsp");
            } else {
                request.setAttribute("mess", "Mật khẩu hiện tại không chính xác");
                request.getRequestDispatcher("reset_password.jsp").forward(request, response);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            request.setAttribute("mess", "Có lỗi xảy ra");
            request.getRequestDispatcher("reset_password.jsp").forward(request, response);
        }
	}

}
