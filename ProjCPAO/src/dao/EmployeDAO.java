package dao;

import java.util.ArrayList;

import modele.metier.Employe;
import modele.metier.Regle;

public interface EmployeDAO extends Dao<Employe> {
	
	public ArrayList<Regle> getRegle(Employe emp);
	
}
