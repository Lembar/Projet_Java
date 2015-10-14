package test.mysql;

import static org.junit.Assert.*;
import modele.metier.Employe;

import org.junit.Test;
import dao.mysql.MySQLEmployeDAO;

public class TestMYSQLEmploye {

	@Test
	public void testConnexion() {
		assertNotNull(MySQLEmployeDAO.getInstance());
	}

	@Test
	public void testCreerEmployeNotNull() {
		Employe e = new Employe(8, "coucou", "robert");
		Employe e1 = new Employe("a", "a");
		MySQLEmployeDAO.getInstance().create(e);
		e1 = MySQLEmployeDAO.getInstance().getByID(8);
		assertNotNull(e1);
	}

	@Test
	public void testCreerEmploye() {

		Employe e = new Employe(20, "abcd", "manon");
		Employe e1 = new Employe("a", "a");
		MySQLEmployeDAO.getInstance().create(e);
		e1 = MySQLEmployeDAO.getInstance().getByID(20);
		assertEquals("abcd", e1.getNom());
		assertEquals("manon", e1.getPrenom());
	}

	@Test
	public void testGetByIdNotNull() {
		assertNotNull(MySQLEmployeDAO.getInstance().getByID(1));
	}

	@Test
	public void testGetById() {
		Employe c = new Employe(4, "coucou", "bernard");
		assertEquals(c.getId(), MySQLEmployeDAO.getInstance().getByID(4)
				.getId());
		assertEquals(c.getNom(), MySQLEmployeDAO.getInstance().getByID(4)
				.getNom());
		assertEquals(c.getPrenom(), MySQLEmployeDAO.getInstance().getByID(4)
				.getPrenom());
	}

	@Test
	public void testUpdateEmploye() {

		Employe e1 = new Employe(2, "jean", "pierre");
		MySQLEmployeDAO.getInstance().update(e1);
		assertEquals(e1.getId(), MySQLEmployeDAO.getInstance().getByID(2)
				.getId());
		assertEquals(e1.getNom(), MySQLEmployeDAO.getInstance().getByID(2)
				.getNom());
		assertEquals(e1.getPrenom(), MySQLEmployeDAO.getInstance().getByID(2)
				.getPrenom());
	}

	@Test
	public void testUpdateEmployeNotNull() {

		Employe e = new Employe(50, "joe", "titi");
		Employe e1 = new Employe("a", "a");
		MySQLEmployeDAO.getInstance().update(e);
		e1 = MySQLEmployeDAO.getInstance().getByID(50);
		assertNotNull(e1);
	}

	@Test
	public void testDeleteEmploye() {

		Employe e = new Employe(8, "joey", "toto");
		MySQLEmployeDAO.getInstance().delete(e);
		assertNull(MySQLEmployeDAO.getInstance().getByID(8));
	}
}
