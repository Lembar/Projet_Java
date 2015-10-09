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

	private ArrayList<Regle> alr;

	public ArrayListRegleDAO() {
		this.alr = new ArrayList<Regle>();
		Regle r1 = new Regle(1, "cadre et brut3200", "rcp=0.05", false);
		Regle r2 = new Regle(2, "cadre", "Pce=0.05", false);
		alr.add(r1);
		alr.add(r2);
	}

	@Override
	public void create(Regle obj) {
		this.alr.add(obj);

	}

	@Override
	public void delete(Regle obj) {
		this.alr.remove(obj);

	}

	@Override
	public void update(Regle obj) {
		this.alr.set(this.alr.indexOf(obj), obj);

	}

	@Override
	public Regle getByID(int id) {
		for (int i = 0; i < this.alr.size(); i++) {
			if (this.alr.get(i).getId() == id) {
				return this.alr.get(i);
			}
		}
		return null;
	}

}