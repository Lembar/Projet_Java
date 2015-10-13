package dao.arraylist;

import java.util.ArrayList;

import modele.metier.Regle;
import dao.RegleDAO;

public class ArrayListRegleDAO implements RegleDAO {

	private static ArrayListRegleDAO instance;

	public static ArrayListRegleDAO getInstance() {
		if (instance == null) {
			instance = new ArrayListRegleDAO();
		}
		return instance;
	}

	private ArrayList<Regle> regles;

	public ArrayListRegleDAO() {
		this.regles = new ArrayList<Regle>();
		Regle r1 = new Regle(1, "cadre et brut3200", "rcp=0.05", false);
		Regle r2 = new Regle(2, "cadre", "Pce=0.05", false);
		regles.add(r1);
		regles.add(r2);
	}

	@Override
	public int create(Regle obj) {
		int id = 1;
		if (obj.getId() == -1) {
			if (!regles.isEmpty()) {
				id = regles.get(regles.size() - 1).getId() + 1;
			}
		} else {
			id = obj.getId();
		}
		obj.setId(id);
		this.regles.add(obj);
		return id;

	}

	@Override
	public void delete(Regle obj) {
		this.regles.remove(obj);

	}

	@Override
	public void update(Regle obj) {
		if (!regles.contains(obj)) {
			throw new IndexOutOfBoundsException("L'objet a mettre a jour n'est pas dans la liste");
		}

		Regle regle = regles.get(regles.indexOf(obj));

		regle.setCondition(obj.getCondition());
		regle.setAction(obj.getAction());
		regle.setActif(obj.getActif());

	}

	@Override
	public Regle getByID(int id) {
		for (int i = 0; i < this.regles.size(); i++) {
			if (this.regles.get(i).getId() == id) {
				return this.regles.get(i);
			}
		}
		return null;
	}

	public ArrayList<Regle> getRegle() {
		return regles;
	}

}