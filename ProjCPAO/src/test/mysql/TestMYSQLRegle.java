package test.mysql;

import static org.junit.Assert.*;
import modele.metier.Regle;
import modele.metier.Regle;
import modele.metier.Variable;

import org.junit.Test;

import dao.mysql.MySQLRegleDAO;
import dao.mysql.MySQLVariableDAO;

public class TestMYSQLRegle {

	@Test
	public void testConnexion() {
		assertNotNull(MySQLRegleDAO.getInstance());
	}

	@Test
	public void testCreerRegleNotNull() {
		Regle r = new Regle(100, "statut='cadre' et brut>3200", "abc", true);
		Regle r1 = new Regle("a", "a", true);
		MySQLRegleDAO.getInstance().create(r);
		r1 = MySQLRegleDAO.getInstance().getByID(100);
		assertNotNull(r1);
	}

	@Test
	public void testCreerRegle() {
		Regle r = new Regle(100, "statut='cadre' et brut>3200", "RCP=0.05",
				true);
		Regle r1 = new Regle("a", "a", false);
		MySQLRegleDAO.getInstance().create(r);
		r1 = MySQLRegleDAO.getInstance().getByID(100);
		assertEquals("statut='cadre' et brut>3200", r1.getCond());
		assertEquals("RCP=0.05", r1.getAction());
		assertEquals(true, r1.getActif());
	}

	@Test
	public void testGetByIdNotNull() {
		assertNotNull(MySQLRegleDAO.getInstance().getByID(1));
	}

	@Test
	public void testGetById() {
		Regle r = new Regle(100, "statut='cadre' et brut>3200", "RCP=0.05",
				true);
		assertEquals(r.getId(), MySQLRegleDAO.getInstance().getByID(100)
				.getId());
		assertEquals(r.getCond(), MySQLRegleDAO.getInstance().getByID(100)
				.getCond());
		assertEquals(r.getAction(), MySQLRegleDAO.getInstance().getByID(100)
				.getAction());
		assertEquals(r.getActif(), MySQLRegleDAO.getInstance().getByID(100)
				.getActif());
	}

	@Test
	public void testUpdateRegle() {
		Regle r1 = new Regle(200, "statut='cadre' et brut>3200", "RCP=0.05",
				true);
		MySQLRegleDAO.getInstance().update(r1);
		assertEquals(r1.getId(), MySQLRegleDAO.getInstance().getByID(200)
				.getId());
		assertEquals(r1.getCond(), MySQLRegleDAO.getInstance().getByID(200)
				.getCond());
		assertEquals(r1.getAction(), MySQLRegleDAO.getInstance().getByID(200)
				.getAction());
		assertEquals(r1.getActif(), MySQLRegleDAO.getInstance().getByID(200)
				.getActif());
	}

	@Test
	public void testUpdateRegleNotNull() {
		Regle r = new Regle(300, "statut='cadre' et brut>3200", "RCP=0.05",false);
		Regle r1 = new Regle("a", "a",false);
		MySQLRegleDAO.getInstance().update(r);
		r1 = MySQLRegleDAO.getInstance().getByID(300);
		assertNotNull(r1);
	}
	
	@Test
	public void testDeleteRegle() {
		Regle v = new Regle(220, "statut='cadre' et brut>3200", "RCP=0.05",false);
		MySQLRegleDAO.getInstance().delete(v);
		assertNull(MySQLRegleDAO.getInstance().getByID(220));
	}
}
