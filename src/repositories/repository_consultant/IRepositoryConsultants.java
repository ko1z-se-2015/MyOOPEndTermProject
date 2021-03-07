package repositories.repository_consultant;

import entites.employee.consultant.Consultant;

import java.util.ArrayList;

public interface IRepositoryConsultants {
    public ArrayList<Consultant> ShowAllConsultants();
    public ArrayList<Consultant> ShowConsultantsByName(String name);
    public Consultant ShowConsultantByID(int id);
    public ArrayList<Consultant> ShowConsultantsByDepartment(int id);
    public boolean addConsultantToBoyToys(Consultant consultant);
    public boolean addConsultantToGirlToys(Consultant consultant);
    public boolean addConsultantToAdultToys(Consultant consultant);
    public boolean removeConsultantByID(int id);
}

