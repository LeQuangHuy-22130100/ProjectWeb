package service;

import java.sql.SQLException;

import DAO.dao.userDAO;
import DAO.model.User;

public class UserService {
	static userDAO userDAO = new userDAO();

    public User login(String username, String password) throws SQLException, ClassNotFoundException {
        return userDAO.login(username,password);
    }
    
    public User signup(String username, String password) throws SQLException, ClassNotFoundException {
    	return userDAO.signup(username, password);
    }
    
    public boolean changePassword(int id, String newPassword) throws SQLException, ClassNotFoundException {
		return userDAO.changePassword(id, newPassword);
	}

}
