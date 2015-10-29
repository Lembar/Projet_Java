package test.mysql;

import static org.junit.Assert.*;
import model.metier.Regle;

import org.junit.Test;

import dao.mysql.MySQLRegleDAO;

public class TestMYSQLRegle {

	@Test
	public void testSingleton() {
		assertNotNull(MySQLRegleDAO.getInstance());
	}

	@Test
	public void testCreerRegleNotNull() {
		Regle regle = new Regle("statut='cadre' et brut>3200", "abc", 1);
		int id = MySQLRegleDAO.getInstance().create(regle);
		Regle regle1 = MySQLRegleDAO.getInstance().getByID(id);
		assertNotNull(regle1);
	}

	@Test
	public void testCreerRegle() {
		Regle regle = new Regle("statut='cadre' et brut>3200", "RCP=0.05",1);
		int id = MySQLRegleDAO.getInstance().create(regle);
		Regle regle1 = MySQLRegleDAO.getInstance().getByID(id);
		assertEquals("statut='cadre' et brut>3200", regle1.getCondition());
		assertEquals("RCP=0.05", regle1.getAction());
		assertEquals(true, regle1.getActif());
	}

	@Test
	public void testGetByIdNotNull() {
		assertNotNull(MySQLRegleDAO.getInstance().getByID(1));
	}

	@Test
	public void testGetById() {
		Regle regle = new Regle("statut='cadre' et brut>3200", "RCP=0.05",
				1);
		int id = MySQLRegleDAO.getInstance().create(regle);
		assertEquals(id, MySQLRegleDAO.getInstance().getByID(id)
				.getId());
		assertEquals(regle.getCondition(), MySQLRegleDAO.getInstance().getByID(id)
				.getCondition());
		assertEquals(regle.getAction(), MySQLRegleDAO.getInstance().getByID(id)
				.getAction());
		assertEquals(regle.getActif(), MySQLRegleDAO.getInstance().getByID(id)
				.getActif());
	}

	@Test
	public void testUpdateRegle() {
		Regle regle1 = new Regle("statut='cadre' et brut>3200", "RCP=0.05",
				1);
		int id = MySQLRegleDAO.getInstance().create(regle1);
		MySQLRegleDAO.getInstance().update(regle1);
		assertEquals(id, MySQLRegleDAO.getInstance().getByID(id)
				.getId());
		assertEquals(regle1.getCondition(), MySQLRegleDAO.getInstance()
				.getByID(id).getCondition());
		assertEquals(regle1.getAction(), MySQLRegleDAO.getInstance().getByID(id)
				.getAction());
		assertEquals(regle1.getActif(), MySQLRegleDAO.getInstance().getByID(id)
				.getActif());
	}

	@Test
	public void testUpdateRegleNotNull() {
		Regle regle = new Regle("statut='cadre' et brut>3200", "RCP=0.05",
				0);
		int id = MySQLRegleDAO.getInstance().create(regle);
		MySQLRegleDAO.getInstance().update(regle);
		Regle regle1 = MySQLRegleDAO.getInstance().getByID(id);
		assertNotNull(regle1);
	}

	@Test
	public void testDeleteRegle() {
		Regle regle = new Regle(220, "statut='cadre' et brut>3200", "RCP=0.05",
				0);
		MySQLRegleDAO.getInstance().delete(regle);
		assertNull(MySQLRegleDAO.getInstance().getByID(220));
	}
}
