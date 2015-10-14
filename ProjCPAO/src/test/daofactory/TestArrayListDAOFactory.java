package test.daofactory;

import static org.junit.Assert.*;

import org.junit.Test;

import dao.factory.DAOFactory;
import dao.factory.Persistance;

public class TestArrayListDAOFactory {

	DAOFactory daof = DAOFactory.getFactory(Persistance.ArrayList);

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

