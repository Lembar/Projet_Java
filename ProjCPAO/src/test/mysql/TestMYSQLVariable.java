package test.mysql;

import static org.junit.Assert.*;
import model.metier.Variable;

import org.junit.Test;

import dao.mysql.MySQLVariableDAO;

public class TestMYSQLVariable {

	@Test
	public void testSingleton() {
		assertNotNull(MySQLVariableDAO.getInstance());
	}

	@Test
	public void testCreerVariableNotNull() {
		Variable var = new Variable("brut", "entier");
		int id = MySQLVariableDAO.getInstance().create(var);
		Variable var1 = MySQLVariableDAO.getInstance().getByID(id);
		assertNotNull(var1);
	}

	@Test
	public void testCreerVariable() {
		Variable var = new Variable("brut", "entier");
		int id = MySQLVariableDAO.getInstance().create(var);
		Variable var1 = MySQLVariableDAO.getInstance().getByID(id);
		assertEquals("brut", var1.getLibelle());
		assertEquals("entier", var1.getType());
	}

	@Test
	public void testGetByIdNotNull() {
		assertNotNull(MySQLVariableDAO.getInstance().getByID(1));
	}

	@Test
	public void testGetById() {
		Variable var = new Variable("statut", "chaine");
		int id = MySQLVariableDAO.getInstance().create(var);
		assertEquals(id, MySQLVariableDAO.getInstance().getByID(id)
				.getId());
		assertEquals(var.getLibelle(), MySQLVariableDAO.getInstance().getByID(id)
				.getLibelle());
		assertEquals(var.getType(), MySQLVariableDAO.getInstance().getByID(id)
				.getType());
	}

	@Test
	public void testUpdateVariable() {
		Variable var1 = new Variable("brut", "entier");
		MySQLVariableDAO.getInstance().update(var1);
		int id = MySQLVariableDAO.getInstance().create(var1);
		assertEquals(id, MySQLVariableDAO.getInstance().getByID(id)
				.getId());
		assertEquals(var1.getLibelle(), MySQLVariableDAO.getInstance().getByID(id)
				.getLibelle());
		assertEquals(var1.getType(), MySQLVariableDAO.getInstance().getByID(id)
				.getType());
	}

	@Test
	public void testUpdateVariableNotNull() {
		Variable var = new Variable(30, "brut", "entier");	
		int id = MySQLVariableDAO.getInstance().create(var);
		MySQLVariableDAO.getInstance().update(var);
		Variable var1 = MySQLVariableDAO.getInstance().getByID(id);
		assertNotNull(var1);
	}

	@Test
	public void testDeleteVariable() {
		Variable var = new Variable(22, "brut", "entier");
		MySQLVariableDAO.getInstance().delete(var);
		assertNull(MySQLVariableDAO.getInstance().getByID(22));
	}
}
