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
		Variable var = new Variable("", "");
		ArrayListVariableDAO.getInstance().create(var);
		assertTrue(ArrayListVariableDAO.getInstance().getVariable().contains(var));
	}

	@Test
	public void testListeVariableDelete() {
		Variable var = new Variable("", "");
		ArrayListVariableDAO.getInstance().create(var);
		ArrayListVariableDAO.getInstance().delete(var);
		assertFalse(ArrayListVariableDAO.getInstance().getVariable().contains(var));
	}

	@Test
	public void testListeVariableGetByID() {
		Variable var = new Variable(555, "", "");
		ArrayListVariableDAO.getInstance().create(var);
		assertEquals(555, ArrayListVariableDAO.getInstance().getByID(555).getId());
	}

	@Test
	public void testListeVariableUpdateID() {
		Variable var = new Variable(555, "", "");
		ArrayListVariableDAO.getInstance().create(var);
		var.setId(666);
		ArrayListVariableDAO.getInstance().update(var);
		assertEquals(666, ArrayListVariableDAO.getInstance().getByID(555).getId());
	}

	@Test
	public void testListeVariableUpdateLibelle() {
		Variable var = new Variable(555, "", "");
		ArrayListVariableDAO.getInstance().create(var);
		var.setLibelle("");
		ArrayListVariableDAO.getInstance().update(var);
		assertEquals("", ArrayListVariableDAO.getInstance().getByID(555).getLibelle());
	}

	@Test
	public void testListeVariableUpdateType() {
		Variable var = new Variable(555, "", "");
		ArrayListVariableDAO.getInstance().create(var);
		var.setType("");
		ArrayListVariableDAO.getInstance().update(var);
		assertEquals("", ArrayListVariableDAO.getInstance().getByID(555).getType());
	}

}
