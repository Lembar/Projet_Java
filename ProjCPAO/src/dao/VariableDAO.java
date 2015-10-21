package dao;

import java.util.ArrayList;

import model.metier.Variable;

public interface VariableDAO extends Dao<Variable> {

	ArrayList<Variable> getVariable();

}
