package dao.arraylist;

import java.util.ArrayList;

import modele.metier.Regle;
import modele.metier.Variable;
import dao.VariableDAO;

public class ArrayListVariableDAO implements VariableDAO {

	private static ArrayListVariableDAO instance;

	public static ArrayListVariableDAO getInstance() {
		if (instance == null) {
			instance = new ArrayListVariableDAO();
		}
		return instance;
	}

	private ArrayList<Variable> variables;

	public ArrayListVariableDAO() {
		this.variables = new ArrayList<Variable>();
		Variable v1 = new Variable(1, "statut", "chaine");
		Variable v2 = new Variable(2, "brut", "entier");
		Variable v3 = new Variable(3, "net", "entier");
		variables.add(v1);
		variables.add(v2);
		variables.add(v3);

	}

	@Override
	public int create(Variable obj) {
		int id = 1;
		if (obj.getId() == -1) {
			if (!variables.isEmpty()) {
				id = variables.get(variables.size() - 1).getId() + 1;
			}
		} else {
			id = obj.getId();
		}
		obj.setId(id);
		this.variables.add(obj);
		return id;

	}

	@Override
	public void delete(Variable obj) {
		this.variables.remove(obj);

	}

	@Override
	public void update(Variable obj) {
		if (!variables.contains(obj)) {
			throw new IndexOutOfBoundsException("L'objet a mettre a jour n'est pas dans la liste");
		}

		Variable var = variables.get(variables.indexOf(obj));

		var.setLibelle(obj.getLibelle());
		var.setType(obj.getType());

	}

	@Override
	public Variable getByID(int id) {
		for (int i = 0; i < this.variables.size(); i++) {
			if (this.variables.get(i).getId() == id) {
				return this.variables.get(i);
			}
		}
		return null;
	}

	@Override
	public ArrayList<Variable> getVariable() {
		return variables;
	}

}
