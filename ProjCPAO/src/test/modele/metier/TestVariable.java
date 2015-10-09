package test.modele.metier;

import static org.junit.Assert.*;
import modele.metier.Variable;

import org.junit.Test;

public class TestVariable {

	Variable v2 = new Variable(2, "brut", "entier");

	@Test
	public void TestVariableNotNull() {
		assertNotNull(v2);
	}

	@Test
	public void TestVariableGetId() {
		assertEquals(2, v2.getId());
	}

	@Test
	public void TestVariableSetId() {
		Variable v3 = new Variable();
		v3.setId(1);
		assertEquals(v3.getId(), 1);
	}

	@Test
	public void TestVariableGetLibelle() {
		assertEquals("brut", v2.getLibelle());
		
	}
	
	@Test
	public void TestVariableSetLibelle() {
		Variable v3 = new Variable();
		v3.setLibelle("coucou");
		assertEquals("coucou",v3.getLibelle() );
		
	}
	
	@Test
	public void TestVariableGetType() {
		assertEquals("entier", v2.getType());
		
	}

	@Test
	public void TestVariableSetType() {
		Variable v3 = new Variable();
		v3.setType("aurevoir");
		assertEquals("aurevoir",v3.getType());
	}
	

}
