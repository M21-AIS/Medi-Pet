/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package register;

/**
 *
 * @author User
 */
public class Register {
 
 private int id;
 private String fullName;
 private String email;
 private String userName;
 private String password;
 private String role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
 
    public String getUserName() {
    return userName;
    }
    public void setUserName(String userName) {
    this.userName = userName;
    }
    public String getPassword() {
    return password;
    }
    public void setPassword(String password) {
    this.password = password;
    }
    public void setFullName(String fullName) {
    this.fullName = fullName;
    }
    public String getFullName() {
    return fullName;
    }
    public void setEmail(String email) {
    this.email = email;
    }
    public String getEmail() {
    return email;
    }
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
   
}
