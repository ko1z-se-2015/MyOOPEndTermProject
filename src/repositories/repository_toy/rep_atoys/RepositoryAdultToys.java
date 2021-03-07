package repositories.repository_toy.rep_atoys;

import data.Interface.IManager;
import entites.toy.adulttoys.AdultToys;
import entites.toy.boytoys.BoyToys;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class RepositoryAdultToys implements IRepositoryAdultToys{
    private IManager iManager;

    public RepositoryAdultToys(IManager iManager) {
        this.iManager = iManager;
    }
    @Override
    public ArrayList<AdultToys> ShowAllAdultToys() { // to show all toys for adults
        Connection connection;
        try {
            connection = iManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM toys WHERE department_of_toys = 3");
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<AdultToys> toys = new ArrayList<>();
            AdultToys toy;
            while (resultSet.next()) {
                toy = new AdultToys(
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
    public ArrayList<AdultToys> ShowAdultToysByName(String name) { // to show toys for adults by name
        Connection connection;
        try {
            connection = iManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM toys WHERE department_of_toys = 3 AND name like'%"+name+"%'");
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<AdultToys> toys = new ArrayList<>();
            AdultToys toy;
            while (resultSet.next()) {
                toy = new AdultToys(
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
    public boolean AddAdultToys(AdultToys adultToys) { // to add toy for adults
        Connection connection;
        try {
            connection = iManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO toys(name,price,manufacturer,quantity,department_of_toys) VALUES(?,?,?,?,3)");
            preparedStatement.setString(1, adultToys.getName());
            preparedStatement.setInt(2, adultToys.getPrice());
            preparedStatement.setString(3, adultToys.getManufacturer());
            preparedStatement.setInt(4, adultToys.getQuantity());

            preparedStatement.execute();
            return true;


        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
