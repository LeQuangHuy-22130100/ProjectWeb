package service;

import java.sql.SQLException;

import DAO.dao.userDAO;
import DAO.model.User;
import utils.OTPGenerator;

public class UserService {
	static userDAO userDAO = new userDAO();
	static EmailService emailService  = new EmailService();

    public User login(String username, String password) throws SQLException, ClassNotFoundException {
        return userDAO.login(username,password);
    }
    
    public User signup(String username, String password) throws SQLException, ClassNotFoundException {
    	return userDAO.signup(username, password);
    }
    
    public User resetPassword(String username, String currentPassword, String newPassword) throws SQLException, ClassNotFoundException {
    	return userDAO.resetPassword(username, currentPassword, newPassword);
    }
    
    public boolean emailPasswordRecovery(String email, String newPassword) throws SQLException, ClassNotFoundException {
    	return userDAO.emailPasswordRecovery(email, newPassword);
    }
    
    public String generateAndSendOTP(String email) throws SQLException, ClassNotFoundException {
        User user = userDAO.findByEmail(email);
        if (user == null) {
            return null;
        }
        
        String otp = OTPGenerator.generateOTP();
        emailService.sendOTP(email, otp);
        return otp;
    }
    
}
