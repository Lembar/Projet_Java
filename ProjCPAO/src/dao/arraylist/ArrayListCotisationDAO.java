package dao.arraylist;

import java.util.ArrayList;

import model.metier.Cotisation;
import dao.CotisationDAO;

public class ArrayListCotisationDAO implements CotisationDAO {

	private static ArrayListCotisationDAO instance;

	public static ArrayListCotisationDAO getInstance() {
		if (instance == null) {
			instance = new ArrayListCotisationDAO();
		}
		return instance;
	}

	private ArrayList<Cotisation> cotisations;

	public ArrayListCotisationDAO() {
		this.cotisations = new ArrayList<Cotisation>();
		Cotisation c1 = new Cotisation(1, "Retraite", 50);
		Cotisation c2 = new Cotisation(2, "AssuranceMaladie", 0.75);
		Cotisation c3 = new Cotisation(3, "CSG", 7.5);
		Cotisation c4 = new Cotisation(4, "AssuranceChomage", 2.4);
		cotisations.add(c1);
		cotisations.add(c2);
		cotisations.add(c3);
		cotisations.add(c4);
	}

	@Override
	public int create(Cotisation obj) {
		int id = 1;
		if (obj.getId() == -1) {
			if (!cotisations.isEmpty()) {
				id = cotisations.get(cotisations.size() - 1).getId() + 1;
			}
		} else {
			id = obj.getId();
		}
		obj.setId(id);
		this.cotisations.add(obj);
		return id;
	}

	@Override
	public void delete(Cotisation obj) {
		this.cotisations.remove(obj);

	}

	@Override
	public void update(Cotisation obj) {

		if (!cotisations.contains(obj)) {
			throw new IndexOutOfBoundsException("L'objet a mettre a jour n'est pas dans la liste");
		}

		Cotisation cot = cotisations.get(cotisations.indexOf(obj));

		cot.setLibelle(obj.getLibelle());
		cot.setTaux(obj.getTaux());
	}

	@Override
	public Cotisation getByID(int id) {
		for (int i = 0; i < this.cotisations.size(); i++) {
			if (this.cotisations.get(i).getId() == id) {
				return this.cotisations.get(i);
			}
		}
		return null;
	}

	public ArrayList<Cotisation> getCotisation() {
		return cotisations;
	}

}
