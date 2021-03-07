package repositories.repository_toy.rep_btoys;

import data.Interface.IManager;
import entites.toy.boytoys.BoyToys;
import entites.toy.girlsboys.GirlToys;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class RepositoryBoyToys implements IRepositoryBoyToys{
    private IManager iManager;

    public RepositoryBoyToys(IManager iManager) {
        this.iManager = iManager;
    }
    @Override
    public ArrayList<BoyToys> ShowAllBoyToys() { // to show all toys for boys
        Connection connection;
        try {
            connection = iManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM toys WHERE department_of_toys = 1");
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<BoyToys> toys = new ArrayList<>();
            BoyToys toy;
            while (resultSet.next()) {
                toy = new BoyToys(
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
    public ArrayList<BoyToys> ShowBoyToysByName(String name) { // to show toys for boys by name
        Connection connection;
        try {
            connection = iManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM toys WHERE department_of_toys = 1 AND name like'%"+name+"%'");
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<BoyToys> toys = new ArrayList<>();
            BoyToys toy;
            while (resultSet.next()) {
                toy = new BoyToys(
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
    public boolean AddBoyToys(BoyToys boyToys) { // to add toy for boys
        Connection connection;
        try {
            connection = iManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO toys(name,price,manufacturer,quantity,department_of_toys) VALUES(?,?,?,?,1)");
            preparedStatement.setString(1, boyToys.getName());
            preparedStatement.setInt(2, boyToys.getPrice());
            preparedStatement.setString(3, boyToys.getManufacturer());
            preparedStatement.setInt(4, boyToys.getQuantity());

            preparedStatement.execute();
            return true;


        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
