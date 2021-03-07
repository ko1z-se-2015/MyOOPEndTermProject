package repositories.repository_toy;

import data.Interface.IManager;
import entites.toy.superclass_toy.Toy;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class RepositoryToy implements IRepositoryToy {
    private IManager iManager;

    public RepositoryToy(IManager connection) {
        this.iManager = connection;
    }

    @Override
    public ArrayList<Toy> ShowAllToys() { // to show all toys
        Connection connection;
        try {
            connection = iManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM toys");
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<Toy> toys = new ArrayList<>();
            Toy toy;
            while (resultSet.next()) {
                toy = new Toy(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("price"),
                        resultSet.getString("manufacturer"),
                        resultSet.getInt("quantity")
                );
                toys.add(toy);
            }
            return toys;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Toy> ShowToysByName(String name) { // to show toys by name
        Connection connection;
        try {
            connection = iManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM toys WHERE name like '%"+name+"%'");
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<Toy> toys = new ArrayList<>();
            Toy toy;
            while (resultSet.next()) {
                toy = new Toy(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("price"),
                        resultSet.getString("manufacturer"),
                        resultSet.getInt("quantity")
                );
                toys.add(toy);
            }
            return toys;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Toy ShowToyByID(int id) { // to show toy by id
        Connection connection;
        try {
            connection = iManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM toys WHERE id ="+id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Toy toy = new Toy();
            if (resultSet.next()) {
                toy = new Toy(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("price"),
                        resultSet.getString("manufacturer"),
                        resultSet.getInt("quantity")
                );
            }
            return toy;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean RemoveToyByID(int id) { // to remove toy by id
       Connection connection;
       try {
           connection = iManager.getConnection();
           PreparedStatement preparedStatement = connection.prepareStatement("DELETE  FROM toys WHERE id ="+id);
           preparedStatement.execute();
           return true;
       }catch (Exception e){
           e.printStackTrace();
       }
        return false;
    }
}
