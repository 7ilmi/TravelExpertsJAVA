package com.example.travelexpertsjava;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class CustomerDAO extends AbstractDAO<Customer>{

    @Override
    public ObservableList<Customer> getAll() {
        ObservableList<Customer> customers = FXCollections.observableArrayList();
        try{
            Connection conn = DBConn.getConnection();
            PreparedStatement stmt = conn.prepareStatement("select * from Customers");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                customers.add(new Customer(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),
                        rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11),
                        rs.getInt(12)));
            }
            conn.close();
            return customers;
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Customer cust) {
        try{
            Connection conn = DBConn.getConnection();
            Statement stmt = conn.createStatement();

            String query = "update Customers set CustomerId = ?, CustFirstName = ?, CustLastName = ?, CustAddress = ?," +
                    " CustCity = ?, CustProv = ?, CustPostal = ?, CustCountry = ?, CustHomePhone = ?, CustBusPhone = ?," +
                    " CustEmail = ?, AgentId = ? where CustomerID = ?";
            PreparedStatement updateCustomer = conn.prepareStatement(query);
            updateCustomer.setInt(1, cust.getCustomerId());
            updateCustomer.setString(2, cust.getCustFirstName());
            updateCustomer.setString(3, cust.getCustLastName());
            updateCustomer.setString(4, cust.getCustAddress());
            updateCustomer.setString(5, cust.getCustCity());
            updateCustomer.setString(6, cust.getCustProv());
            updateCustomer.setString(7, cust.getCustPostal());
            updateCustomer.setString(8, cust.getCustCountry());
            updateCustomer.setString(9, cust.getCustHomePhone());
            updateCustomer.setString(10, cust.getCustBusPhone());
            updateCustomer.setString(11, cust.getCustEmail());
            updateCustomer.setInt(12, cust.getAgentId());
            updateCustomer.setInt(13, cust.getCustomerId());

            int rs = updateCustomer.executeUpdate();
            conn.close();
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(Customer cust) {
        try{
            Connection conn = DBConn.getConnection();
            Statement stmt = conn.createStatement();

            String query = "insert into Customers (CustomerId, CustFirstName, CustLastName, CustAddress," +
                    " CustCity, CustProv, CustPostal, CustCountry, CustHomePhone, CustBusPhone," +
                    " CustEmail, AgentId) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement addCustomer = conn.prepareStatement(query);
            addCustomer.setInt(1, cust.getCustomerId());
            addCustomer.setString(2, cust.getCustFirstName());
            addCustomer.setString(3, cust.getCustLastName());
            addCustomer.setString(4, cust.getCustAddress());
            addCustomer.setString(5, cust.getCustCity());
            addCustomer.setString(6, cust.getCustProv());
            addCustomer.setString(7, cust.getCustPostal());
            addCustomer.setString(8, cust.getCustCountry());
            addCustomer.setString(9, cust.getCustHomePhone());
            addCustomer.setString(10, cust.getCustBusPhone());
            addCustomer.setString(11, cust.getCustEmail());
            addCustomer.setInt(12, cust.getAgentId());

            int rs = addCustomer.executeUpdate();
            conn.close();
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int index) {
        try{
            Connection conn = DBConn.getConnection();
            Statement stmt = conn.createStatement();

            String query = "delete from Customers where CustomerId = ? ";
            PreparedStatement deleteCustomer = conn.prepareStatement(query);
            deleteCustomer.setInt(1, index);

            int rs = deleteCustomer.executeUpdate();
            conn.close();
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
