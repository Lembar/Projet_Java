package dao.factory;

import dao.CotisationDAO;
import dao.EmployeDAO;
import dao.RegleDAO;
import dao.VariableDAO;
import dao.arraylist.ArrayListCotisationDAO;
import dao.arraylist.ArrayListEmployeDAO;
import dao.arraylist.ArrayListRegleDAO;
import dao.arraylist.ArrayListVariableDAO;

public class ArrayListDAOFactory extends DAOFactory {

	public CotisationDAO getCotisationDAO() {
		return ArrayListCotisationDAO.getInstance();
	}

	public EmployeDAO getEmployeDAO() {
		return ArrayListEmployeDAO.getInstance();
	}

	public RegleDAO getRegleDAO() {
		return ArrayListRegleDAO.getInstance();
	}

	public VariableDAO getVariableDAO() {
		return ArrayListVariableDAO.getInstance();
	}
}