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
		Variable v3 = new Variable();
		v3.setId(1);
		assertEquals(v3.getId(), 1);
	}

	@Test
	public void testVariableGetLibelle() {
		assertEquals("brut", var.getLibelle());

	}

	@Test
	public void testVariableSetLibelle() {
		Variable v3 = new Variable();
		v3.setLibelle("coucou");
		assertEquals("coucou", v3.getLibelle());

	}

	@Test
	public void testVariableGetType() {
		assertEquals("entier", var.getType());

	}

	@Test
	public void testVariableSetType() {
		Variable v3 = new Variable();
		v3.setType("aurevoir");
		assertEquals("aurevoir", v3.getType());
	}

}
