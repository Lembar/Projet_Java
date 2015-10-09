package dao.arraylist;

import java.util.ArrayList;
import java.util.HashMap;

import modele.metier.Employe;
import modele.metier.Regle;
import modele.metier.Variable;
import dao.EmployeDAO;


public class ArrayListEmployeDAO implements EmployeDAO {
	
	private static ArrayListEmployeDAO instance;

	public static ArrayListEmployeDAO getInstance() {
		if(instance==null){
		 instance = new ArrayListEmployeDAO();
		}
		return instance;
	}
	
	private ArrayList<Employe> al;
	
	public ArrayListEmployeDAO() {
		this.al=new ArrayList<Employe>();
		Employe e1 = new Employe(1,"Zeis","Oceane");
		Employe e2 = new Employe(2,"Hesse","Kevin");
		al.add(e1);
		al.add(e2);
		
	}


	
    @Override
    public void create(Employe obj) {
            this.al.add(obj);

    }

    @Override
    public void delete(Employe obj) {
            this.al.remove(obj);

    }

    @Override
    public void update(Employe obj) {
            this.al.set(this.al.indexOf(obj), obj);

    }

    @Override
    public Employe getByID(int id) {
            for (int i = 0; i < this.al.size(); i++) {
                    if (this.al.get(i).getId() == id) {
                            return this.al.get(i);
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

}
