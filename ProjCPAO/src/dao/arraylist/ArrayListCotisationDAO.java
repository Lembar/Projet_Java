package dao.arraylist;

import java.util.ArrayList;

import modele.metier.Cotisation;
import dao.CotisationDAO;

public class ArrayListCotisationDAO implements CotisationDAO {

	private static ArrayListCotisationDAO instance;

	public static ArrayListCotisationDAO getInstance() {
		if (instance == null) {
			instance = new ArrayListCotisationDAO();
		}
		return instance;
	}

	private ArrayList<Cotisation> alc;

	public ArrayListCotisationDAO() {
		this.alc = new ArrayList<Cotisation>();
		Cotisation c1 = new Cotisation(1, "Retraite", 50);
		Cotisation c2 = new Cotisation(2, "AssuranceMaladie", 0.75);
		Cotisation c3 = new Cotisation(3, "CSG", 7.5);
		Cotisation c4 = new Cotisation(4, "AssuranceChomage", 2.4);
		alc.add(c1);
		alc.add(c2);
		alc.add(c3);
		alc.add(c4);
	}

	@Override
	public void create(Cotisation obj) {
		this.alc.add(obj);

	}

	@Override
	public void delete(Cotisation obj) {
		this.alc.remove(obj);

	}

	@Override
	public void update(Cotisation obj) {
		this.alc.set(this.alc.indexOf(obj), obj);

	}

	@Override
	public Cotisation getByID(int id) {
		for (int i = 0; i < this.alc.size(); i++) {
			if (this.alc.get(i).getId() == id) {
				return this.alc.get(i);
			}
		}
		return null;
	}

	public ArrayList<Cotisation> getCotisation() {
		return alc;
	}

}
