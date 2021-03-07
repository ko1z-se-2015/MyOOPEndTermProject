package repositories.repository_toy.rep_gtoys;

import entites.toy.girlsboys.GirlToys;
import entites.toy.superclass_toy.Toy;

import java.util.ArrayList;

public interface IRepositoryGirlToys {
    public ArrayList<GirlToys> ShowAllGirlToys();
    public ArrayList<GirlToys> ShowGirlToysByName(String name);
    public boolean addGirlToys(GirlToys girlToys);
}
