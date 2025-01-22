package DAO.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import DAO.db.DBConnect;
import DAO.model.*;

public class userDAO {
	static Statement stmt;
    static {
        try {
            stmt = DBConnect.get();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    ResultSet rs;

    public User login(String username, String password) throws ClassNotFoundException, SQLException {
        User user = null;
        String query =  "SELECT * FROM users_table\n" +
                        "WHERE `Name` = ? \n" +
                        "AND `Password` = ?";

        try (
                Connection con = DBConnect.get().getConnection();
                PreparedStatement pstmt = con.prepareStatement(query)
        ) {
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    user = new User();
                    user.setId(rs.getInt(1));
                    user.setName(rs.getString(2));
                    user.setPassword(rs.getString(3));
                    user.setEmail(rs.getString(4));
                    user.setPhone(rs.getString(5));
                    user.setAddress(rs.getString(6));
                    user.setIsAdmin(rs.getInt(7));
                }
            }
        }
        return user;
    }
    
    public User signup(String username, String password) throws ClassNotFoundException, SQLException {
    	User user = null;
		String query = "INSERT INTO users_table(Name, Password, isAdmin, isClient)\n" + 
						"VALUES (?, ?, 0, 1)\n";
		 try (
	                Connection con = DBConnect.get().getConnection();
	                PreparedStatement pstmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)
	     ) {
	         pstmt.setString(1, username);
	         pstmt.setString(2, password);
	         pstmt.executeUpdate();
	            
	         try (ResultSet rs = pstmt.getGeneratedKeys()) {
	        	 if (rs.next()) {
	        		 user = new User();
	                 user.setId(rs.getInt(1));
	                 user.setName(username);
	                 user.setPassword(password);
	                 user.setIsAdmin(0);
	        	 }
	         }
	     }
		 return user;
    }
    
    public boolean changePassword(int id, String newPassword) throws SQLException, ClassNotFoundException {
    	String query = "UPDATE users_table SET Password = ? WHERE ID = ?";
    	try (
	    			Connection con = DBConnect.get().getConnection();
	    			PreparedStatement pstmt = con.prepareStatement(query)
    	) {
    		pstmt.setString(1, newPassword);
    		pstmt.setInt(2, id);
    		
    		int rowsAffected = pstmt.executeUpdate();
    		return rowsAffected > 0;
    	}
    }
    
    public boolean isExistedEmail(String email) throws SQLException, ClassNotFoundException {
    	String query = "SELECT COUNT(*) FROM users_table WHERE Email = ?";
    	try (
    				Connection con = DBConnect.get().getConnection();
    				PreparedStatement pstmt = con.prepareStatement(query)
    	) {
    		pstmt.setString(1, email);
    		try (ResultSet rs = pstmt.executeQuery()) {
    			if (rs.next()) {
    				return rs.getInt(1) > 0;
    			}
    		}
    	}
    	return false;
	}
    
    public boolean resetPassword(String email, String newPassword) throws SQLException, ClassNotFoundException {
    	String query = "UPDATE users_table SET Password = ? WHERE Email = ?";
    	try (
    				Connection con = DBConnect.get().getConnection();
    				PreparedStatement pstmt = con.prepareStatement(query)
    	) {
    		pstmt.setString(1, newPassword);
    		pstmt.setString(2, email);
    		
    		int rowsAffected = pstmt.executeUpdate();
    		return rowsAffected > 0;
    	}
	}

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        userDAO userDAO = new userDAO();
        User users = userDAO.login("Nguyễn Văn A", "123");
        System.out.println(users);
    }

}
