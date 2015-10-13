package test.mysql;

import static org.junit.Assert.*;
import modele.metier.Variable;

import org.junit.Test;

import dao.mysql.MySQLVariableDAO;

public class TestMYSQLVariable {

	@Test
	public void testConnexion() {
		assertNotNull(MySQLVariableDAO.getInstance());
	}

	@Test
	public void testCreerVariableNotNull() {
		Variable v = new Variable(8,"brut", "entier");
		Variable v1 = new Variable("a", "a");
		MySQLVariableDAO.getInstance().create(v);
		v1 = MySQLVariableDAO.getInstance().getByID(8);
		assertNotNull(v1);
	}

	@Test
	public void testCreerVariable() {
		Variable v = new Variable(20,"brut", "entier");
		Variable v1 = new Variable("a", "a");
		MySQLVariableDAO.getInstance().create(v);
		v1 = MySQLVariableDAO.getInstance().getByID(20);
		assertEquals("brut", v1.getLibelle());
		assertEquals("entier", v1.getType());
	}

	@Test
	public void testGetByIdNotNull() {
		assertNotNull(MySQLVariableDAO.getInstance().getByID(1));
	}

	@Test
	public void testGetById() {
		Variable v = new Variable(1, "statut", "chaine");
		assertEquals(v.getId(), MySQLVariableDAO.getInstance().getByID(1)
				.getId());
		assertEquals(v.getLibelle(), MySQLVariableDAO.getInstance().getByID(1)
				.getLibelle());
		assertEquals(v.getType(), MySQLVariableDAO.getInstance().getByID(1)
				.getType());
	}


	@Test
	public void testUpdateVariable() {
		Variable v1 = new Variable(2, "brut", "entier");
		MySQLVariableDAO.getInstance().update(v1);
		assertEquals(v1.getId(), MySQLVariableDAO.getInstance().getByID(2)
				.getId());
		assertEquals(v1.getLibelle(), MySQLVariableDAO.getInstance().getByID(2)
				.getLibelle());
		assertEquals(v1.getType(), MySQLVariableDAO.getInstance().getByID(2)
				.getType());
	}

	@Test
	public void testUpdateVariableNotNull() {
		Variable v = new Variable(30,"brut", "entier");
		Variable v1 = new Variable("a", "a");
		MySQLVariableDAO.getInstance().update(v);
		v1 = MySQLVariableDAO.getInstance().getByID(30);
		assertNotNull(v1);
	}

	@Test
	public void testDeleteVariable() {
		Variable v = new Variable(22, "brut", "entier");
		MySQLVariableDAO.getInstance().delete(v);
		assertNull(MySQLVariableDAO.getInstance().getByID(22));
	}
}
