package dao.arraylist;

import java.util.ArrayList;
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

	private ArrayList<Variable> alv;

	public ArrayListVariableDAO() {
		this.alv = new ArrayList<Variable>();
		Variable v1 = new Variable(1, "statut", "chaine");
		Variable v2 = new Variable(2, "brut", "entier");
		Variable v3 = new Variable(3, "net", "entier");
		alv.add(v1);
		alv.add(v2);
		alv.add(v3);

	}

	@Override
	public void create(Variable obj) {
		this.alv.add(obj);

	}

	@Override
	public void delete(Variable obj) {
		this.alv.remove(obj);

	}

	@Override
	public void update(Variable obj) {
		this.alv.set(this.alv.indexOf(obj), obj);

	}

	@Override
	public Variable getByID(int id) {
		for (int i = 0; i < this.alv.size(); i++) {
			if (this.alv.get(i).getId() == id) {
				return this.alv.get(i);
			}
		}
		return null;
	}

	@Override
	public ArrayList<Variable> getVariable() {
		return alv;
	}

}
