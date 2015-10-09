package dao.factory;

import dao.CotisationDAO;
import dao.EmployeDAO;
import dao.RegleDAO;
import dao.VariableDAO;
import dao.mysql.MySQLCotisationDAO;
import dao.mysql.MySQLEmployeDAO;
import dao.mysql.MySQLRegleDAO;
import dao.mysql.MySQLVariableDAO;

public class MySQLDAOFactory extends DAOFactory {

	public CotisationDAO getCotisationDAO() {
		return MySQLCotisationDAO.getInstance();
	}

	public EmployeDAO getEmployeDAO() {
		return MySQLEmployeDAO.getInstance();
	}

	public RegleDAO getRegleDAO() {
		return MySQLRegleDAO.getInstance();
	}

	public VariableDAO getVariableDAO() {
		return MySQLVariableDAO.getInstance();
	}
}