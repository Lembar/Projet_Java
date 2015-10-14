package test.daofactory;

import static org.junit.Assert.*;

import org.junit.Test;

import dao.factory.DAOFactory;
import dao.factory.Persistance;

public class TestMySQLDAOFactory {

	DAOFactory daof = DAOFactory.getFactory(Persistance.MySQL);

	@Test
	public void testGetCotisation() {
		assertNotNull(daof.getCotisationDAO());
	}

	@Test
	public void testGetEmploye() {
		assertNotNull(daof.getEmployeDAO());
	}

	@Test
	public void testGetRegle() {
		assertNotNull(daof.getRegleDAO());
	}

	@Test
	public void testGetVariable() {
		assertNotNull(daof.getVariableDAO());
	}

}
