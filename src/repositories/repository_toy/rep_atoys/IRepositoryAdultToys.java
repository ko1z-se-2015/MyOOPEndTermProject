package repositories.repository_toy.rep_atoys;

import entites.toy.adulttoys.AdultToys;
import entites.toy.boytoys.BoyToys;

import java.util.ArrayList;

public interface IRepositoryAdultToys {
    public ArrayList<AdultToys> ShowAllAdultToys();
    public ArrayList<AdultToys> ShowAdultToysByName(String name);
    public boolean AddAdultToys(AdultToys boyToys);
}
