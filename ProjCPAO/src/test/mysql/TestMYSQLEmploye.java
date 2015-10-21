package test.mysql;

import static org.junit.Assert.*;
import model.metier.Employe;

import org.junit.Test;

import dao.mysql.MySQLEmployeDAO;

public class TestMYSQLEmploye {

	@Test
	public void testSingleton() {
		assertNotNull(MySQLEmployeDAO.getInstance());
	}

	@Test
	public void testCreerEmployeNotNull() {
		Employe emp = new Employe("coucou", "robert");
		int id=MySQLEmployeDAO.getInstance().create(emp);
		Employe emp1 = MySQLEmployeDAO.getInstance().getByID(id);
		assertNotNull(emp1);
	}

	@Test
	public void testCreerEmploye() {

		Employe emp = new Employe("abcd", "manon");
		int id = MySQLEmployeDAO.getInstance().create(emp);
		Employe emp1 = MySQLEmployeDAO.getInstance().getByID(id);
		assertEquals("abcd", emp1.getNom());
		assertEquals("manon", emp1.getPrenom());
	}

	@Test
	public void testGetByIdNotNull() {
		assertNotNull(MySQLEmployeDAO.getInstance().getByID(1));
	}

	@Test
	public void testGetById() {
		Employe emp = new Employe("coucou", "bernard");
		int id = MySQLEmployeDAO.getInstance().create(emp);
		assertEquals(id, MySQLEmployeDAO.getInstance().getByID(id)
				.getId());
		assertEquals(emp.getNom(), MySQLEmployeDAO.getInstance().getByID(id)
				.getNom());
		assertEquals(emp.getPrenom(), MySQLEmployeDAO.getInstance().getByID(id)
				.getPrenom());
	}

	@Test
	public void testUpdateEmploye() {

		Employe emp = new Employe("jean", "pierre");
		int id = MySQLEmployeDAO.getInstance().create(emp);
		MySQLEmployeDAO.getInstance().update(emp);
		assertEquals(id, MySQLEmployeDAO.getInstance().getByID(id)
				.getId());
		assertEquals(emp.getNom(), MySQLEmployeDAO.getInstance().getByID(id)
				.getNom());
		assertEquals(emp.getPrenom(), MySQLEmployeDAO.getInstance().getByID(id)
				.getPrenom());
	}

	@Test
	public void testUpdateEmployeNotNull() {

		Employe emp = new Employe("joe", "titi");
		int id = MySQLEmployeDAO.getInstance().create(emp);
		MySQLEmployeDAO.getInstance().update(emp);
		Employe emp2 = MySQLEmployeDAO.getInstance().getByID(id);
		assertNotNull(emp2);
	}

	@Test
	public void testDeleteEmploye() {

		Employe emp = new Employe(557, "joey", "toto");
		MySQLEmployeDAO.getInstance().delete(emp);
		assertNull(MySQLEmployeDAO.getInstance().getByID(557));
	}
}
