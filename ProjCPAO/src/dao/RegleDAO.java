package dao;

import java.util.ArrayList;

import model.metier.Regle;

public interface RegleDAO extends Dao<Regle> {

	ArrayList<Regle> findAll();

}