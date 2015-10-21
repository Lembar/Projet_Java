package test.model.metier;

import static org.junit.Assert.*;
import model.metier.Employe;

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
		Employe emp = new Employe();
		emp.setId(1);
		assertEquals(1, emp.getId());
	}

	@Test
	public void testEmployeGetNom() {
		assertEquals("Zeis", emp.getNom());
	}

	@Test
	public void testEmployeSetNomChaine() {
		Employe emp = new Employe();
		emp.setNom("Toto");
		assertEquals("Toto", emp.getNom());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEmployeSetNomVide() {
		Employe emp = new Employe();
		emp.setNom("");
		assertEquals("", emp.getNom());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEmployeSetNomEspaces() {
		Employe emp = new Employe();
		emp.setNom("     ");
		assertEquals("     ", emp.getNom());
	}

	@Test
	public void testEmployeGetPrenom() {
		assertEquals("Oceane", emp.getPrenom());
	}

	@Test
	public void testEmployeSetPrenomChaine() {
		Employe emp = new Employe();
		emp.setPrenom("Toto");
		assertEquals("Toto", emp.getPrenom());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEmployeSetPrenomVide() {
		Employe emp = new Employe();
		emp.setPrenom("");
		assertEquals("", emp.getPrenom());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEmployeSetPrenomEspaces() {
		Employe emp = new Employe();
		emp.setPrenom("     ");
		assertEquals("     ", emp.getPrenom());
	}

}
