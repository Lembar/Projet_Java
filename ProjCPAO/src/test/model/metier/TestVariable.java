package test.model.metier;

import static org.junit.Assert.*;
import model.metier.Variable;

import org.junit.Test;

public class TestVariable {

	Variable var = new Variable(2, "brut", "entier");

	@Test
	public void TestVariableNotNull() {
		assertNotNull(var);
	}

	@Test
	public void testVariableGetId() {
		assertEquals(2, var.getId());
	}

	@Test
	public void testVariableSetId() {
		Variable var = new Variable();
		var.setId(1);
		assertEquals(var.getId(), 1);
	}

	@Test
	public void testVariableGetLibelle() {
		assertEquals("brut", var.getLibelle());

	}

	@Test
	public void testVariableSetLibelleChaine() {
		Variable var = new Variable();
		var.setLibelle("coucou");
		assertEquals("coucou", var.getLibelle());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testVariableSetLibelleVide() {
		Variable var = new Variable();
		var.setLibelle("");
		assertEquals("", var.getLibelle());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testVariableSetLibelleEspaces() {
		Variable var = new Variable();
		var.setLibelle("      ");
		assertEquals("      ", var.getLibelle());
	}

	@Test
	public void testVariableGetType() {
		assertEquals("entier", var.getType());

	}

	@Test
	public void testVariableSetTypeChaine() {
		Variable var = new Variable();
		var.setType("aurevoir");
		assertEquals("aurevoir", var.getType());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testVariableSetTypeVide() {
		Variable var = new Variable();
		var.setType("");
		assertEquals("", var.getType());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testVariableSetTypeEspaces() {
		Variable var = new Variable();
		var.setType("     ");
		assertEquals("     ", var.getType());
	}

}
