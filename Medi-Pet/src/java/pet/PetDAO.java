package pet;

import java.sql.*;
import java.util.*;

import pet.Pet;
import util.DBUtil;
 
public class PetDAO {
 
    private Connection connection;
 
    public PetDAO() {
        connection = DBUtil.getConnection();
    }
 
    public void checkPet(Pet pet) {
        try {
            PreparedStatement ps = connection.prepareStatement("select petid from pet where petid = ?");
            ps.setInt(1, pet.getPetid());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) // found
            {
                updatePet(pet);
            } else {
                addPet(pet);
            }
        } catch (Exception ex) {
            System.out.println("Error in check() -->" + ex.getMessage());
        } 
    }
    
    public void addPet(Pet pet) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into pet(name,dob,sex,breed,fullname) values (?, ?, ?, ?, ? )");
            // Parameters start with 1
            preparedStatement.setString(1, pet.getName());
            preparedStatement.setString(2, pet.getDob());
            preparedStatement.setString(3, pet.getSex());
            preparedStatement.setString(4, pet.getBreed());
            preparedStatement.setString(5, pet.getFullname());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePet(int petId) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from pet where petid=?");
            // Parameters start with 1
            preparedStatement.setInt(1, petId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePet(Pet pet) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update pet set name=?, dob=?, sex=?, breed=?, fullname=? where petid=?");
            // Parameters start with 1
            preparedStatement.setString(1, pet.getName());
            preparedStatement.setString(2, pet.getDob());
            preparedStatement.setString(3, pet.getSex());
            preparedStatement.setString(4, pet.getBreed());
            preparedStatement.setString(5, pet.getFullname());
            preparedStatement.setInt(6, pet.getPetid());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Pet> getAllPets() {
        List<Pet> pets = new ArrayList<Pet>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from pet");
            while (rs.next()) {
                Pet pet = new Pet();
                pet.setPetid(rs.getInt("petid"));
                pet.setName(rs.getString("name"));
                pet.setDob(rs.getString("dob"));
                pet.setSex(rs.getString("sex"));
                pet.setBreed(rs.getString("breed"));
                pet.setFullname(rs.getString("fullname"));
                pets.add(pet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pets;
    }

    public Pet getPetById(int petId) {
        Pet pet = new Pet();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from pet where petid=?");
            preparedStatement.setInt(1, petId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                pet.setPetid(rs.getInt("petid"));
                pet.setName(rs.getString("name"));
                pet.setDob(rs.getString("dob"));
                pet.setSex(rs.getString("sex"));
                pet.setBreed(rs.getString("breed"));
                pet.setFullname(rs.getString("fullname"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pet;
    }
}