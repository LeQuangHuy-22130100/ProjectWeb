package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.UserService;

@WebServlet(name = "/PasswordRecoveryControl", value = "/forgot_password")
public class PasswordRecoveryControl extends HttpServlet {
	private UserService userService = new UserService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        
        try {
            switch(action) {
                case "sendOTP":
                    handleSendOTP(request, response, session);
                    break;
                case "verifyOTP":
                    handleVerifyOTP(request, response, session);
                    break;
                case "resetPassword":
                    handleResetPassword(request, response, session);
                    break;
                default:
                    out.print("Invalid action");
            }
        } catch (Exception e) {
            out.print("Error: " + e.getMessage());
            e.printStackTrace();
        }
	}
	
	private void handleSendOTP(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
		String email = request.getParameter("email");
	    String otp = generateOTP(); // Generate OTP here
	    PrintWriter out = response.getWriter();
	    
	    session.setAttribute("generatedOTP", otp);
	    session.setAttribute("userEmail", email);
	    
	    out.print("OTP sent successfully");
	}
	
	private void handleVerifyOTP(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
		String userOTP = request.getParameter("otp");
        String generatedOTP = (String) session.getAttribute("generatedOTP");
        PrintWriter out = response.getWriter();
        
        if (userOTP.equals(generatedOTP)) {
            out.print("OTP verified");
        } else {
            out.print("Invalid OTP");
        }
	}

	private void handleResetPassword(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, ClassNotFoundException, SQLException {
		String newPassword = request.getParameter("newPassword");
        String confirmPassword = request.getParameter("confirmPassword");
        String email = (String) session.getAttribute("userEmail");
        PrintWriter out = response.getWriter();
        
        if (!newPassword.equals(confirmPassword)) {
            out.print("Passwords do not match");
            return;
        }
        
        // Assuming you have a method to get username by email in UserService
        // This is a placeholder and should be implemented in your UserService
        String username = getUsernameByEmail(email);
        
        if (username == null) {
            out.print("User not found");
            return;
        }
        
        // Reset password
        // Note: In a real application, you would hash the password before storing
        userService.resetPassword(username, null, newPassword);
        
        out.print("Password reset successfully");
	}
	
	private String getUsernameByEmail(String email) {
        // TODO: Implement method to retrieve username by email
        // This would typically involve a database lookup
        return null;
    }

}
