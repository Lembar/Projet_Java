package dao.arraylist;

import java.util.ArrayList;
import java.util.HashMap;

import model.metier.Employe;
import model.metier.Regle;
import model.metier.Variable;
import dao.EmployeDAO;

public class ArrayListEmployeDAO implements EmployeDAO {

	private static ArrayListEmployeDAO instance;

	public static ArrayListEmployeDAO getInstance() {
		if (instance == null) {
			instance = new ArrayListEmployeDAO();
		}
		return instance;
	}

	private ArrayList<Employe> employes;

	public ArrayListEmployeDAO() {
		this.employes = new ArrayList<Employe>();
		Employe e1 = new Employe(1, "Zeis", "Oceane");
		Employe e2 = new Employe(2, "Hesse", "Kevin");
		employes.add(e1);
		employes.add(e2);

	}

	@Override
	public int create(Employe obj) {
		int id = 1;
		if (obj.getId() == -1) {
			if (!employes.isEmpty()) {
				id = employes.get(employes.size() - 1).getId() + 1;
			}
		} else {
			id = obj.getId();
		}
		obj.setId(id);
		this.employes.add(obj);
		return id;

	}

	@Override
	public void delete(Employe obj) {
		this.employes.remove(obj);

	}

	@Override
	public void update(Employe obj) {
		if (!employes.contains(obj)) {
			throw new IndexOutOfBoundsException("L'objet a mettre a jour n'est pas dans la liste");
		}

		Employe emp = employes.get(employes.indexOf(obj));

		emp.setNom(obj.getNom());
		emp.setPrenom(obj.getPrenom());

	}

	@Override
	public Employe getByID(int id) {
		for (int i = 0; i < this.employes.size(); i++) {
			if (this.employes.get(i).getId() == id) {
				return this.employes.get(i);
			}
		}
		return null;
	}

	@Override
	public ArrayList<Regle> getRegle(Employe obj) {
		return obj.getRegle();
	}

	@Override
	public HashMap<Variable, String> getHm(int id) {
		return getHm(id);
	}

	public ArrayList<Employe> getEmploye() {
		return employes;
	}

}
