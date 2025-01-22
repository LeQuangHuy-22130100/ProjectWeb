package service;

import java.sql.SQLException;

import javax.mail.MessagingException;

import DAO.dao.userDAO;
import DAO.model.User;

public class UserService {
	static userDAO userDAO = new userDAO();
	private EmailService emailService = new EmailService();
	private OTPStorage otpStorage = new OTPStorage();

    public User login(String username, String password) throws SQLException, ClassNotFoundException {
        return userDAO.login(username,password);
    }
    
    public User signup(String username, String password) throws SQLException, ClassNotFoundException {
    	return userDAO.signup(username, password);
    }
    
    public boolean changePassword(int id, String newPassword) throws SQLException, ClassNotFoundException {
		return userDAO.changePassword(id, newPassword);
	}
    
    public boolean isExistedEmail(String email) throws SQLException, ClassNotFoundException {
    	return userDAO.isExistedEmail(email);
    }
    
    public boolean resetPassword(String email, String newPassword) throws SQLException, ClassNotFoundException {
    	return userDAO.resetPassword(email, newPassword);
    }
    
    public boolean sendOTP(String email) throws SQLException, ClassNotFoundException, MessagingException {
        if (userDAO.isExistedEmail(email)) {
            String otp = emailService.generateOTP();
            otpStorage.saveOTP(email, otp);
            return emailService.sendOTPEmail(email, otp);
        }
        return false;
    }

	public boolean verifyOTP(String email, String otp) {
		return otpStorage.verifyOTP(email, otp);
	}

}
