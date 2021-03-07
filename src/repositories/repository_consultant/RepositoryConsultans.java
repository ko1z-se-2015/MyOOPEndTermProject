package repositories.repository_consultant;

import data.Interface.IManager;
import entites.employee.consultant.Consultant;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class RepositoryConsultans implements IRepositoryConsultants {
    private IManager iManager;

    public RepositoryConsultans(IManager connection) {
        this.iManager = connection;
    }
    @Override
    public ArrayList<Consultant> ShowAllConsultants() { // to show all consultants
        Connection connection;
        try {
            connection = iManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM consultants");
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<Consultant> consultants = new ArrayList<>();
            Consultant consultant;
            while (resultSet.next()) {
                consultant = new Consultant(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getInt("age"),
                        resultSet.getInt("salary"),
                        resultSet.getDate("date_of_employment").toLocalDate(),
                        resultSet.getInt("department")
                );
                consultants.add(consultant);
            }
            return consultants;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Consultant> ShowConsultantsByName(String name) { // to show consultants by name
        Connection connection;
        try {
            connection = iManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM consultants WHERE name like '%"+name+"%'");
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<Consultant> consultants = new ArrayList<>();
            Consultant consultant;
            while (resultSet.next()) {
                consultant = new Consultant(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getInt("age"),
                        resultSet.getInt("salary"),
                        resultSet.getDate("date_of_employment").toLocalDate(),
                        resultSet.getInt("department")
                );
                consultants.add(consultant);
            }
            return consultants;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Consultant ShowConsultantByID(int id) { // to show consultant by id
        Connection connection;
        try {
            connection = iManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM consultants WHERE id="+id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Consultant consultant =new Consultant();
              if (resultSet.next()) {
                consultant = new Consultant(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getInt("age"),
                        resultSet.getInt("salary"),
                        resultSet.getDate("date_of_employment").toLocalDate(),
                        resultSet.getInt("department")
                );
            }
            return consultant;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Consultant> ShowConsultantsByDepartment(int id) { // to show consultants by department
        Connection connection;
        try {
            connection = iManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM consultants WHERE department="+id);
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<Consultant> consultants = new ArrayList<>();
            Consultant consultant;
            while (resultSet.next()) {
                consultant = new Consultant(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getInt("age"),
                        resultSet.getInt("salary"),
                        resultSet.getDate("date_of_employment").toLocalDate(),
                        resultSet.getInt("department")
                );
                consultants.add(consultant);
            }
            return consultants;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addConsultantToBoyToys(Consultant consultant) { // to add consultant to department of toys for boys
        Connection connection;
        try {
            connection = iManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO consultants(name,surname,age,salary,date_of_employment,department) VALUES (?,?,?,?,?,1)");
            preparedStatement.setString(1,consultant.getName());
            preparedStatement.setString(2,consultant.getSurname());
            preparedStatement.setInt(3,consultant.getAge());
            preparedStatement.setInt(4,consultant.getSalary());
            preparedStatement.setDate(5, Date.valueOf(consultant.getStart_date()));

            preparedStatement.execute();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addConsultantToGirlToys(Consultant consultant) {  // to add consultant to department of toys for girls
        Connection connection;
        try {
            connection = iManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO consultants(name,surname,age,salary,date_of_employment,department) VALUES (?,?,?,?,?,2)");
            preparedStatement.setString(1,consultant.getName());
            preparedStatement.setString(2,consultant.getSurname());
            preparedStatement.setInt(3,consultant.getAge());
            preparedStatement.setInt(4,consultant.getSalary());
            preparedStatement.setDate(5, Date.valueOf(consultant.getStart_date()));
            preparedStatement.execute();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addConsultantToAdultToys(Consultant consultant) {  // to add consultant to department of toys for adults
        Connection connection;
        try {
            connection = iManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO consultants(name,surname,age,salary,date_of_employment,department) VALUES (?,?,?,?,?,3)");
            preparedStatement.setString(1,consultant.getName());
            preparedStatement.setString(2,consultant.getSurname());
            preparedStatement.setInt(3,consultant.getAge());
            preparedStatement.setInt(4,consultant.getSalary());
            preparedStatement.setDate(5, Date.valueOf(consultant.getStart_date()));
            preparedStatement.execute();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean removeConsultantByID(int id) { // to remove the consultant by id
        Connection connection;
        try {
            connection = iManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM consultants WHERE id="+id);
            preparedStatement.execute();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
