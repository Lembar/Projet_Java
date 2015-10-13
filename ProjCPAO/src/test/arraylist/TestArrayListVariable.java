package test.arraylist;

import static org.junit.Assert.*;

import org.junit.Test;

import dao.arraylist.ArrayListVariableDAO;
import modele.metier.Variable;

public class TestArrayListVariable {

	@Test
	public void testSingleton() {
		assertNotNull(ArrayListVariableDAO.getInstance());
	}

	@Test
	public void testListeVariableNotNull() {
		assertNotNull(ArrayListVariableDAO.getInstance().getVariable());
	}

	@Test
	public void testListeVariableCreation() {
		Variable var = new Variable("a", "a");
		ArrayListVariableDAO.getInstance().create(var);
		assertTrue(ArrayListVariableDAO.getInstance().getVariable().contains(var));
	}

	@Test
	public void testListeVariableDelete() {
		Variable var = new Variable("a", "a");
		ArrayListVariableDAO.getInstance().create(var);
		ArrayListVariableDAO.getInstance().delete(var);
		assertFalse(ArrayListVariableDAO.getInstance().getVariable().contains(var));
	}

	@Test
	public void testListeVariableGetByIDNotNull() {
		Variable var = new Variable("a", "a");
		int id = ArrayListVariableDAO.getInstance().create(var);
		assertNotNull(ArrayListVariableDAO.getInstance().getByID(id));
	}

	@Test
	public void testListeVariableGetByID() {
		Variable var = new Variable("a", "a");
		int id = ArrayListVariableDAO.getInstance().create(var);
		assertEquals(id, ArrayListVariableDAO.getInstance().getByID(id).getId());
	}

	@Test
	public void testListeVariableUpdateLibelle() {
		Variable var = new Variable("a", "a");
		int id = ArrayListVariableDAO.getInstance().create(var);
		var.setLibelle("b");
		ArrayListVariableDAO.getInstance().update(var);
		assertEquals("b", ArrayListVariableDAO.getInstance().getByID(id).getLibelle());
	}

	@Test
	public void testListeVariableUpdateType() {
		Variable var = new Variable(555, "a", "a");
		int id = ArrayListVariableDAO.getInstance().create(var);
		var.setType("c");
		ArrayListVariableDAO.getInstance().update(var);
		assertEquals("c", ArrayListVariableDAO.getInstance().getByID(id).getType());
	}

}
