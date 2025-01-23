package DAO.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DAO.db.DBConnect;
import DAO.model.User;

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
    
	public User resetPassword(String username, String currentPassword, String newPassword) throws SQLException, ClassNotFoundException {
		User user = null;
	    String checkQuery = "SELECT * FROM users_table WHERE Name = ? AND Password = ?";
	    String updateQuery = "UPDATE users_table SET Password = ? WHERE Name = ?";
	    
	    try (Connection con = DBConnect.get().getConnection()) {
	        // First, verify current credentials
	        try (PreparedStatement checkStmt = con.prepareStatement(checkQuery)) {
	            checkStmt.setString(1, username);
	            checkStmt.setString(2, currentPassword);
	            try (ResultSet rs = checkStmt.executeQuery()) {
	                if (!rs.next()) {
	                    return null; // Current password is incorrect
	                }
	            }
	        }
	        
	        // Update password
	        try (PreparedStatement updateStmt = con.prepareStatement(updateQuery)) {
	            updateStmt.setString(1, newPassword);
	            updateStmt.setString(2, username);
	            int rowsAffected = updateStmt.executeUpdate();
	            
	            if (rowsAffected > 0) {
	                user = new User();
	                user.setName(username);
	                user.setPassword(newPassword);
	            }
	        }
	    }
	    return user;
	}


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        userDAO userDAO = new userDAO();
        User users = userDAO.login("Nguyễn Văn A", "123");
        System.out.println(users);
    }

}
