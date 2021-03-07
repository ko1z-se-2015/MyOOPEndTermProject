package repositories.repository_toy;

import entites.toy.superclass_toy.Toy;

import java.util.ArrayList;

public interface IRepositoryToy {
    public ArrayList<Toy> ShowAllToys();
    public ArrayList<Toy> ShowToysByName(String name);
    public Toy ShowToyByID(int id);
    public boolean RemoveToyByID(int id);
}
