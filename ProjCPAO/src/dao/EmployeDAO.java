package dao;

import java.util.ArrayList;
import java.util.HashMap;

import model.metier.Employe;
import model.metier.Regle;
import model.metier.Variable;

public interface EmployeDAO extends Dao<Employe> {

	public ArrayList<Regle> getRegle(Employe obj);

	public HashMap<Variable, String> getHm(int id);

	ArrayList<Employe> findAll();

}
