package dao;

import java.util.ArrayList;

import modele.metier.Variable;

public interface VariableDAO extends Dao<Variable> {

	ArrayList<Variable> getVariable();

	

}
	  