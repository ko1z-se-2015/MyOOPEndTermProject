package entites.employee.superclass_employee;

import java.time.LocalDate;

public class Employee {
    private int id;  // fields of the class
    private String Name;
    private String Surname;
    private int age;
    private LocalDate start_date;
    private int salary;
    private int department;

    public Employee() {

    }

    public Employee(int id, String name, String surname, int age,  int salary, LocalDate start_date,int Department) { // constructer of the class
        setId(id);
        setName(name);
        setSurname(surname);
        setAge(age);
        setStart_date(start_date);
        setSalary(salary);
        setDepartment(Department);
    }

    public Employee(String name, String surname, int age,  int salary, LocalDate start_date, int Department) { //constructer of the class
        setName(name);
        setSurname(surname);
        setAge(age);
        setStart_date(start_date);
        setSalary(salary);
        setDepartment(Department);
    }

    public Employee(String name, String surname, int age,  int salary, LocalDate start_date) { //constructer of the class
        setName(name);
        setSurname(surname);
        setAge(age);
        setStart_date(start_date);
        setSalary(salary);
    }


    // setters and getters
    public void setDepartment(int department) {
        this.department = department;
    }

    public int getDepartment() {
        return department;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getName() {
        return Name;
    }

    public void setSurname(String add) {
        this.Surname = add;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public LocalDate getStart_date() {
        return start_date;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", Surname='" + Surname + '\'' +
                ", age=" + age +
                ", start_date=" + start_date +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                '}' + "\n";
    }
}
