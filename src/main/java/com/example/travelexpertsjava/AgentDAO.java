package com.example.travelexpertsjava;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class AgentDAO extends AbstractDAO<Agent>{

    @Override
    public ObservableList<Agent> getAll() {
        ObservableList<Agent> agents = FXCollections.observableArrayList();
        try{
            Connection conn = DBConn.getConnection();
            PreparedStatement stmt = conn.prepareStatement("select * from Agents");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                agents.add(new Agent(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6),
                        rs.getString(7), rs.getInt(8)));
            }
            conn.close();
            return agents;
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Agent agt) {
        try{
            Connection conn = DBConn.getConnection();
            Statement stmt = conn.createStatement();

            String query = "update Agents set AgentId = ?, AgtFirstName = ?, AgtMiddleInitial = ?, AgtLastName = ?," +
                    " AgtBusPhone = ?, AgtEmail = ?, AgtPosition = ?, AgencyId = ? where agentID = ?";
            PreparedStatement updateAgent = conn.prepareStatement(query);
            updateAgent.setInt(1, agt.getAgentId());
            updateAgent.setString(2, agt.getAgtFirstName());
            updateAgent.setString(3, agt.getAgtMiddleInitial());
            updateAgent.setString(4, agt.getAgtLastName());
            updateAgent.setString(5, agt.getAgtBusPhone());
            updateAgent.setString(6, agt.getAgtEmail());
            updateAgent.setString(7, agt.getAgtPosition());
            updateAgent.setInt(8, agt.getAgencyId());
            updateAgent.setInt(9, agt.getAgentId());

            int rs = updateAgent.executeUpdate();
            conn.close();
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(Agent agt) {
        try{
            Connection conn = DBConn.getConnection();
            Statement stmt = conn.createStatement();

            String query = "insert into Agents (AgentId, AgtFirstName, AgtMiddleInitial, AgtLastName, " +
                    " AgtBusPhone, AgtEmail, AgtPosition, AgencyId) values (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement addAgent = conn.prepareStatement(query);
            addAgent.setInt(1, agt.getAgentId());
            addAgent.setString(2, agt.getAgtFirstName());
            addAgent.setString(3, agt.getAgtMiddleInitial());
            addAgent.setString(4, agt.getAgtLastName());
            addAgent.setString(5, agt.getAgtBusPhone());
            addAgent.setString(6, agt.getAgtEmail());
            addAgent.setString(7, agt.getAgtPosition());
            addAgent.setInt(8, agt.getAgencyId());

            int rs = addAgent.executeUpdate();
            System.out.println(rs);
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

            String query = "delete from Agents where AgentId = ? ";
            PreparedStatement deleteAgent = conn.prepareStatement(query);
            deleteAgent.setInt(1, index);

            int rs = deleteAgent.executeUpdate();
            System.out.println(rs);
            conn.close();
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
