package test.modele.metier;

import static org.junit.Assert.*;
import modele.metier.Employe;

import org.junit.Test;

public class TestEmploye {

	Employe emp = new Employe(1, "Zeis", "Oceane");

	@Test
	public void testEmployeNotNull() {
		assertNotNull(emp);
	}

	@Test
	public void testEmployeGetId() {
		assertEquals(1, emp.getId());
	}

	@Test
	public void testEmployeSetId() {
		Employe e = new Employe();
		e.setId(1);
		assertEquals(1, e.getId());
	}

	@Test
	public void testEmployeGetNom() {
		assertEquals("Zeis", emp.getNom());
	}

	@Test
	public void testEmployeSetNom() {
		Employe e = new Employe();
		e.setNom("Toto");
		assertEquals(e.getNom(), "Toto");
	}

	@Test
	public void testEmployeGetPrenom() {
		assertEquals("Oceane", emp.getPrenom());
	}

	@Test
	public void testEmployeSetPrenom() {
		Employe e = new Employe();
		e.setPrenom("Toto");
		assertEquals(e.getPrenom(), "Toto");
	}

}
