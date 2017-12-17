package login;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
import login.Login;
import util.DBUtil;
 
public class LoginDAO {
 
public String authenticateUser(Login loginBean)
{
 String userName = loginBean.getUserName();
 String password = loginBean.getPassword();
 
 Connection con = null;
 Statement statement = null;
 ResultSet resultSet = null;
 
 String userNameDB = "";
 String passwordDB = "";
 String roleDB = "";
 
 try
 {
 con = DBUtil.getConnection();
 statement = con.createStatement();
 resultSet = statement.executeQuery("select username,password,role from users");
 
 while(resultSet.next())
 {
 userNameDB = resultSet.getString("username");
 passwordDB = resultSet.getString("password");
 roleDB = resultSet.getString("role");
 
 if(userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("Admin"))
 return "Admin_Role";
 else if(userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("User"))
 return "User_Role";
 }
 }
 catch(SQLException e)
 {
 e.printStackTrace();
 }
 return "Invalid user credentials";
}
}