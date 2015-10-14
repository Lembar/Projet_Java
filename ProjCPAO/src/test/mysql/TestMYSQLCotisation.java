package test.mysql;

import static org.junit.Assert.*;
import modele.metier.Cotisation;
import org.junit.Test;
import dao.mysql.MySQLCotisationDAO;

public class TestMYSQLCotisation {

	@Test
	public void testSingleton() {
		assertNotNull(MySQLCotisationDAO.getInstance());
	}

	@Test
	public void testCreerCotisationNotNull() {
		Cotisation cot = new Cotisation("brut", 10);
		int id = MySQLCotisationDAO.getInstance().create(cot);
		Cotisation cot1 = MySQLCotisationDAO.getInstance().getByID(id);
		assertNotNull(cot1);

	}

	@Test
	public void testCreerCotisation() {
		Cotisation cot = new Cotisation("Retraite", 50);
		int id = MySQLCotisationDAO.getInstance().create(cot);
		Cotisation cot1 = MySQLCotisationDAO.getInstance().getByID(id);
		assertEquals("Retraite", cot1.getLibelle());
		assertEquals(50, cot1.getTaux(), 1e-5);
	}

	@Test
	public void testGetByIdNotNull() {
		assertNotNull(MySQLCotisationDAO.getInstance().getByID(1));
	}

	@Test
	public void testGetById() {

		Cotisation cot = new Cotisation("Retraite", 78);
		int id = MySQLCotisationDAO.getInstance().create(cot);
		assertEquals(id, MySQLCotisationDAO.getInstance().getByID(id).getId());
		assertEquals(cot.getLibelle(), MySQLCotisationDAO.getInstance()
				.getByID(id).getLibelle());
		assertEquals(cot.getTaux(), MySQLCotisationDAO.getInstance()
				.getByID(id).getTaux(), 1e-5);
	}

	@Test
	public void testUpdateCotisation() {
		Cotisation cot1 = new Cotisation("Retraite", 20);
		int id = MySQLCotisationDAO.getInstance().create(cot1);
		MySQLCotisationDAO.getInstance().update(cot1);
		assertEquals(id, MySQLCotisationDAO.getInstance().getByID(id).getId());
		assertEquals(cot1.getLibelle(),
				MySQLCotisationDAO.getInstance().getByID(id).getLibelle());
		assertEquals(cot1.getTaux(), MySQLCotisationDAO.getInstance().getByID(id)
				.getTaux(), 1e-5);
	}

	@Test
	public void testUpdateCotisationNotNull() {
		Cotisation cot = new Cotisation("Retraite", 78);
		int id = MySQLCotisationDAO.getInstance().create(cot);
		MySQLCotisationDAO.getInstance().update(cot);
		Cotisation cot1 = MySQLCotisationDAO.getInstance().getByID(id);
		assertNotNull(cot1);
	}

	@Test
	public void testDeleteCotisation() {
		Cotisation cot = new Cotisation(555,"Retraite", 20);
		MySQLCotisationDAO.getInstance().delete(cot);
		assertNull(MySQLCotisationDAO.getInstance().getByID(555));
	}
}
