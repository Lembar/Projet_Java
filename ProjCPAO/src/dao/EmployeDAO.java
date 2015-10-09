package dao;

import java.util.ArrayList;
import java.util.HashMap;

import modele.metier.Employe;
import modele.metier.Regle;
import modele.metier.Variable;

public interface EmployeDAO extends Dao<Employe> {
	
	public ArrayList<Regle> getRegle(Employe obj);
	public HashMap<Variable, String> getHm(int id);

	
}
