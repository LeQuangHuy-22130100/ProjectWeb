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


@WebServlet(name = "UserControl", value = "/login")
public class UserControl extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService userService = new UserService();
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = null;
        try {
            user = userService.login(username,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        if(user == null){
        	//reset lại trang đăng nhập
            request.setAttribute("mess", "Sai tên đăng nhập hoặc mật khẩu");
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }else {
        	//đi đến trang home
            request.getRequestDispatcher("HomePage.jsp").forward(request, response);
        }
        
        try {
        	user = userService.signup(username, password);
        } catch (SQLException e) {
        	throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
        	throw new RuntimeException(e);
        }
        if(user == null) {
        	//quay về trang đăng nhập
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }else {
        	//được đăng ký và đi đến trang home
        	request.getRequestDispatcher("HomePage.jsp").forward(request, response);
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
