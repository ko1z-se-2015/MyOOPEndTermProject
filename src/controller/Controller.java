package controller;

import entites.employee.consultant.Consultant;
import entites.toy.adulttoys.AdultToys;
import entites.toy.boytoys.BoyToys;
import entites.toy.girlsboys.GirlToys;
import repositories.repository_consultant.IRepositoryConsultants;
import repositories.repository_toy.IRepositoryToy;
import repositories.repository_toy.rep_atoys.IRepositoryAdultToys;
import repositories.repository_toy.rep_btoys.IRepositoryBoyToys;
import repositories.repository_toy.rep_gtoys.IRepositoryGirlToys;

public class Controller {
    private IRepositoryConsultants iRepositoryConsultants; // fields to work and make with methods
    private IRepositoryToy iRepositoryToy;
    private IRepositoryBoyToys iRepositoryBoyToys;
    private IRepositoryGirlToys iRepositoryGirlToys;
    private IRepositoryAdultToys iRepositoryAdultToys;

    public Controller(IRepositoryConsultants iRepositoryConsultants,
                      IRepositoryToy iRepositoryToy, IRepositoryBoyToys iRepositoryBoyToys, IRepositoryGirlToys iRepositoryGirlToys,
                      IRepositoryAdultToys iRepositoryAdultToys) {  // class' constructor
        this.iRepositoryConsultants = iRepositoryConsultants;
        this.iRepositoryToy = iRepositoryToy;
        this.iRepositoryBoyToys = iRepositoryBoyToys;
        this.iRepositoryGirlToys = iRepositoryGirlToys;
        this.iRepositoryAdultToys = iRepositoryAdultToys;
    }

    public String ShowAllConsultants() { // method which shows all consultants
        String res = iRepositoryConsultants.ShowAllConsultants().toString();
        return res;
    }

    public String ShowConsultantsByName(String name) {  // method which shows consultants by name
        String res = iRepositoryConsultants.ShowConsultantsByName(name).toString();
        return res;
    }

    public String ShowConsultantById(int id) {  // method which shows consultant by id
        String res = iRepositoryConsultants.ShowConsultantByID(id).toString();
        return res;
    }

    public String ShowConsultantsByDepartment(int id) {  // method which shows consultants by department
        String res = iRepositoryConsultants.ShowConsultantsByDepartment(id).toString();
        return res;
    }

    public String AddConsultantsToBoyToys(Consultant consultant) { // method which adds the consultant to department of toys for boys
        if (iRepositoryConsultants.addConsultantToBoyToys(consultant)) {
            return "Consultant was added";
        } else {
            return "Error";
        }
    }

    public String AddConsultantsToGirlToys(Consultant consultant) { // method which adds the consultant to department of toys for girls
        if (iRepositoryConsultants.addConsultantToGirlToys(consultant)) {
            return "Consultant was added";
        } else {
            return "Error";
        }
    }

    public String AddConsultantsToAdultToys(Consultant consultant) { // method which adds the consultant to department of toys for adults
        if (iRepositoryConsultants.addConsultantToAdultToys(consultant)) {
            return "Consultant was added";
        } else {
            return "Error";
        }
    }

    public String RemoveConsultantByID(int id) { // method which removes consultant by id
        if (iRepositoryConsultants.removeConsultantByID(id)) {
            return "Consultant was removed";
        } else {
            return "Error";
        }
    }
    public String ShowAllTOYS(){ // method which shows all toys
        String res= iRepositoryToy.ShowAllToys().toString();
        return res;
    }
    public String ShowToysByName(String name){ // method which shows toys by name
        String res = iRepositoryToy.ShowToysByName(name).toString();
        return res;
    }
    public String ShowToyByID(int id){ // method which shows toy by id
        String res = iRepositoryToy.ShowToyByID(id).toString();
        return res;
    }
    public String RemoveToyByID(int id){ // method which removes toy by id
        if(iRepositoryToy.RemoveToyByID(id)){
            return "Toy was removed";
        }else{
            return "Error";
        }
    }
    public String ShowAllGirlToys(){ // method which shows all toys for girls
        String res= iRepositoryGirlToys.ShowAllGirlToys().toString();
        return res;
    }
    public String ShowBoyGirlByName(String name){ // method which shows  toys for girls by name
        String res = iRepositoryGirlToys.ShowGirlToysByName(name).toString();
        return res;
    }
    public String AddGirlToys(GirlToys girlToys){ // method which adds toys for girls
        if(iRepositoryGirlToys.addGirlToys(girlToys)){
            return "Toy was added";
        }else {
            return "Error";
        }
    }
    public String ShowAllAdultToys(){ // method which shows all toys for adults
        String res= iRepositoryAdultToys.ShowAllAdultToys().toString();
        return res;
    }
    public String ShowAdultToysByName(String name){ // method which shows toys for adults by name
        String res = iRepositoryAdultToys.ShowAdultToysByName(name).toString();
        return res;
    }
    public String AddAdultToys(AdultToys adultToys){ // method which adds toy for adults
        if(iRepositoryAdultToys.AddAdultToys(adultToys)){
            return "Toy was added";
        }else {
            return "Error";
        }
    }
    public String ShowAllBoyToys(){ // method which shows all toys for boy
        String res= iRepositoryBoyToys.ShowAllBoyToys().toString();
        return res;
    }
    public String ShowBoyToysByName(String name){ // method which shows  toys for boy by name
        String res = iRepositoryBoyToys.ShowBoyToysByName(name).toString();
        return res;
    }
    public String AddBoyToys(BoyToys boyToys){ // method which adds toy for boy
        if(iRepositoryBoyToys.AddBoyToys(boyToys)){
            return "Toy was added";
        }else {
            return "Error";
        }
    }
}
