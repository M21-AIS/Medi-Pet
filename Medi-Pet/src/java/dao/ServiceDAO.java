package dao;

import java.sql.*;
import java.util.*;

import bean.Service;
import util.DBUtil;
 
public class ServiceDAO {
 
    private Connection connection;
 
    public ServiceDAO() {
        connection = DBUtil.getConnection();
    }
 
    public void checkService(Service service) {
        try {
            PreparedStatement ps = connection.prepareStatement("select serviceNo from service where serviceNo = ?");
            ps.setInt(1, service.getServiceNo());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) // found
            {
                updateService(service);
            } else {
                addService(service);
            }
        } catch (Exception ex) {
            System.out.println("Error in check() -->" + ex.getMessage());
        } 
    }
    
    public void addService(Service service) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into service(serviceType, petType, status) values (?, ?, ?)");
            // Parameters start with 1
            preparedStatement.setString(1, service.getServiceType());
            preparedStatement.setString(2, service.getPetType());
            preparedStatement.setString(3, service.getStatus());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteService(int serviceNo) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from service where serviceNo=?");
            // Parameters start with 1
            preparedStatement.setInt(1, serviceNo);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateService(Service service) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update service set serviceType=?, petType=?, status=? where serviceNo=?");
            // Parameters start with 1
            preparedStatement.setString(1, service.getServiceType());
            preparedStatement.setString(2, service.getPetType());
            preparedStatement.setString(3, service.getStatus());
            preparedStatement.setInt(4, service.getServiceNo());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Service> getAllServices() {
        List<Service> services = new ArrayList<Service>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from service");
            while (rs.next()) {
                Service service = new Service();
                service.setServiceNo(rs.getInt("serviceNo"));
                service.setServiceType(rs.getString("serviceType"));
                service.setPetType(rs.getString("petType"));
                service.setStatus(rs.getString("status"));
                services.add(service);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return services;
    }

    public Service getServiceById(int serviceNo) {
        Service service = new Service();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from service where serviceNo=?");
            preparedStatement.setInt(1, serviceNo);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                service.setServiceNo(rs.getInt("serviceNo"));
                service.setServiceType(rs.getString("serviceType"));
                service.setPetType(rs.getString("petType"));
                service.setStatus(rs.getString("status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return service;
    }
}