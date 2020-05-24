/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author ALaa
 */
public class CustomerDao implements Serializable{

    Connection con;

    public CustomerDao() {

        con = DbUtility.getConnection();
    }

    public List<Customer> getAllCustomer() {
        List<Customer> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM studyjsf.customer";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(new Customer(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("phone"),
                        rs.getString("address"),
                        rs.getString("city"),
                        rs.getString("state")
                ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public int addCustomer(Customer customer) {
        System.err.println("ay 7aga");
        int rowsInserted = 0;
        try {
            String sql = "INSERT INTO customer (name,phone,address,city,state)  VALUES (?,?,?,?,?);";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, customer.getName());
            stmt.setString(2, customer.getPhone());
            stmt.setString(3, customer.getAddress());
            stmt.setString(4, customer.getCity());
            stmt.setString(5, customer.getState());
            rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.err.println("A new customer was inserted successfully!");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rowsInserted;
    }

    public int updateCustomer(Customer customer) {
        int rowsUpdated = 0;
        try {
            String sql = "UPDATE customer SET name=?, phone=?, address=? ,address=? WHERE id=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, customer.getName());
            stmt.setString(2, customer.getPhone());
            stmt.setString(3, customer.getAddress());
            stmt.setString(4, customer.getCity());
            stmt.setInt(5, customer.getId());
            rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("A  customer was updated successfully!");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rowsUpdated;
    }

    public int deleteCustomer(int id) {
        int rowsDeleted = 0;
        try {
            String sql = "DELETE FROM customer WHERE id=?";

            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, id);

             rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A customer was deleted successfully!");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rowsDeleted;
    }

}
