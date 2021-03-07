package repositories.repository_toy.rep_btoys;

import entites.toy.boytoys.BoyToys;
import entites.toy.girlsboys.GirlToys;

import java.util.ArrayList;

public interface IRepositoryBoyToys {
    public ArrayList<BoyToys> ShowAllBoyToys();
    public ArrayList<BoyToys> ShowBoyToysByName(String name);
    public boolean AddBoyToys(BoyToys boyToys);
}
