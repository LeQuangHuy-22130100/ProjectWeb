package vn.edu.hcmuaf.fit.project.Service;

import vn.edu.hcmuaf.fit.project.DAO.dao.userDAO;
import vn.edu.hcmuaf.fit.project.DAO.model.User;

import java.sql.SQLException;

public class UserService {
    static userDAO userDao = new userDAO();

    public User login(String username, String password) throws SQLException, ClassNotFoundException {
        return userDao.login(username,password);
    }

    public void Signin(String username, String password) throws SQLException, ClassNotFoundException {
        userDao.signin(username,password);
    }

    public User checkUser(String username) throws SQLException, ClassNotFoundException {
        return userDao.checkUser(username);
    }

    public User checkPower(String isAdmin) throws SQLException, ClassNotFoundException {
        return userDao.checkPower(isAdmin);
    }

}
