/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointment;

import java.sql.*;
import java.util.*;

import appointment.Appointment;
import util.DBUtil;

public class AppointmentDAO {
 private Connection connection;
 
    public AppointmentDAO() {
        connection = DBUtil.getConnection();
    }
 
    public void checkApp (Appointment app) {
        try {
            PreparedStatement ps = connection.prepareStatement("select appNo from appointment where appNo = ?");
            ps.setString(1, app.getAppNo());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) // found
            {
                updateApp(app);
            } else {
                addApp(app);
            }
        } catch (Exception ex) {
            System.out.println("Error in check() -->" + ex.getMessage());
        } 
    }
    
    public void addApp(Appointment app) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into appointment(appNo,date,time,typeVacc,username,name) values (?, ?, ?, ?, ?, ? )");
            // Parameters start with 1
            preparedStatement.setString(1, app.getAppNo());
            preparedStatement.setString(2, app.getDate());
            preparedStatement.setString(3, app.getTime());
            preparedStatement.setString(4, app.getTypeVacc());
            preparedStatement.setString(5, app.getUsername());
            preparedStatement.setString(6, app.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteApp(String appNo) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from appointment where appNo=?");
            // Parameters start with 1
            preparedStatement.setString(1, appNo);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateApp (Appointment app) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update appointment set date=?,time=?, typeVacc=?, username=?, name=? where appNo=?");
            // Parameters start with 1
            preparedStatement.setString(1, app.getDate());
            preparedStatement.setString(2, app.getTime());
            preparedStatement.setString(3, app.getTypeVacc());
            preparedStatement.setString(4, app.getUsername());
            preparedStatement.setString(5, app.getName());
            preparedStatement.setString(6, app.getAppNo());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Appointment> getAllApp() {
        List<Appointment> apps = new ArrayList<Appointment>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from appointment");
            while (rs.next()) {
                Appointment app = new Appointment();
                app.setAppNo(rs.getString("appNo"));
                app.setDate(rs.getString("date"));
                app.setTime(rs.getString("time"));
                app.setTypeVacc(rs.getString("typeVacc"));
                app.setUsername(rs.getString("username"));
                app.setName(rs.getString("name"));          
                apps.add(app);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return apps;
    }

    public Appointment getAppByAppNo(String appNo) {
        Appointment app = new Appointment();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from appointment where appNo=?");
            preparedStatement.setString(1, appNo);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                app.setAppNo(rs.getString("appNo"));
                app.setDate(rs.getString("date"));
                app.setTime(rs.getString("time"));
                app.setTypeVacc(rs.getString("typeVacc"));
                app.setUsername(rs.getString("username"));
                app.setName(rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return app;
    }
}