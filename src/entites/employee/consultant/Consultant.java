package entites.employee.consultant;

import entites.employee.superclass_employee.Employee;

import java.time.LocalDate;

public class Consultant extends Employee { // this class extends the class Employee
    public Consultant(){

    }
    public Consultant(int id, String name, String surname, int age, int salary, LocalDate start_date, int department) { // construct of the class
        super(id, name, surname, age,salary, start_date, department);
    }

    public Consultant(String name, String surname, int age,  int salary, LocalDate start_date, int department) { // construct of the class
        super(name, surname, age,salary, start_date, department);
    }
    public Consultant(String name, String surname, int age,  int salary, LocalDate start_date) { // construct of the class
        super(name, surname, age, salary, start_date);
    }
    // setters and getters
    @Override
    public void setId(int id) {
        super.setId(id);
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }
    @Override
    public String getName() {
        return super.getName();
    }
    @Override
    public void setSurname(String surname) {
        super.setSurname(surname);
    }
    @Override
    public String getSurname() {
        return super.getSurname();
    }

    @Override
    public void setAge(int age) {
        super.setAge(age);
    }

    @Override
    public int getAge() {
        return super.getAge();
    }

    @Override
    public void setStart_date(LocalDate start_date) {
        super.setStart_date(start_date);
    }

    @Override
    public LocalDate getStart_date() {
        return super.getStart_date();
    }


    @Override
    public void setSalary(int salary) {
        super.setSalary(salary);
    }

    @Override
    public int getSalary() {
        return super.getSalary();
    }

    @Override
    public void setDepartment(int department) {
        super.setDepartment(department);
    }

    @Override
    public int getDepartment() {
        return super.getDepartment();
    }
    @Override
    public String toString() {
        return super.toString();
    }
}
