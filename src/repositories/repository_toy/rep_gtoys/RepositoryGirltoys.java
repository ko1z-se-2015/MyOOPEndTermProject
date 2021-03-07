package repositories.repository_toy.rep_gtoys;

import data.Interface.IManager;
import entites.toy.girlsboys.GirlToys;
import entites.toy.superclass_toy.Toy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class RepositoryGirltoys implements IRepositoryGirlToys {
    private IManager iManager;

    public RepositoryGirltoys(IManager iManager) {
        this.iManager = iManager;
    }

    @Override
    public ArrayList<GirlToys> ShowAllGirlToys() { // to show all toys for girls
        Connection connection;
        try {
            connection = iManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM toys WHERE department_of_toys = 2");
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<GirlToys> toys = new ArrayList<>();
            GirlToys toy;
            while (resultSet.next()) {
                toy = new GirlToys(
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
    public ArrayList<GirlToys> ShowGirlToysByName(String name) { // to show toys for girls by name
        Connection connection;
        try {
            connection = iManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM toys WHERE department_of_toys = 2 AND name like'%" + name + "%'");
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<GirlToys> toys = new ArrayList<>();
            GirlToys toy;
            while (resultSet.next()) {
                toy = new GirlToys(
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
    public boolean addGirlToys(GirlToys girlToys) { // to add toy for girls
        Connection connection;
        try {
            connection = iManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO toys(name,price,manufacturer,quantity,department_of_toys) VALUES(?,?,?,?,2)");
            preparedStatement.setString(1, girlToys.getName());
            preparedStatement.setInt(2, girlToys.getPrice());
            preparedStatement.setString(3, girlToys.getManufacturer());
            preparedStatement.setInt(4, girlToys.getQuantity());

            preparedStatement.execute();
            return true;


        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
