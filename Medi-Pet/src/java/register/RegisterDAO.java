/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package register;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import register.Register;
import util.DBUtil;
 
public class RegisterDAO {
 
 public String registerUser(Register register)
 {
 String fullName = register.getFullName();
 String email = register.getEmail();
 String userName = register.getUserName();
 String password = register.getPassword();
 String role = register.getRole();
 
 Connection con = null;
 PreparedStatement preparedStatement = null;
 
 try
 {
 con = DBUtil.getConnection();
 String query = "insert into users(id,fullname,email,username,password,role) values (null,?,?,?,?,?)"; //Insert user details into the table 'USERS'
 preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
 preparedStatement.setString(1, fullName);
 preparedStatement.setString(2, email);
 preparedStatement.setString(3, userName);
 preparedStatement.setString(4, password);
 preparedStatement.setString(5, role);

 
 int i= preparedStatement.executeUpdate();
 
 if (i!=0)  //Just to ensure data has been inserted into the database
 return "SUCCESS"; 
 }
 catch(SQLException e)
 {
 e.printStackTrace();
 }
 
 return "Oops.. Something went wrong there..!";  // On failure, send a message from here.
 }
 
}