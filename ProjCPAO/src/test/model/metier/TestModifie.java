package test.model.metier;

import static org.junit.Assert.*;
import model.metier.Modifie;

import org.junit.Test;

public class TestModifie {

	Modifie mod = new Modifie(1, 1, "Meh");

	@Test
	public void testModifieNotNull() {
		assertNotNull(mod);
	}

	@Test
	public void testModifieGetIdEmploye() {
		assertEquals(1, mod.getIdEmploye());

	}

	@Test
	public void testModifieSetIdEmploye() {
		Modifie mod = new Modifie();
		mod.setIdEmploye(2);
		assertEquals(2, mod.getIdEmploye());

	}

	@Test
	public void testModifieGetIdVariable() {
		assertEquals(1, mod.getIdVariable());
	}

	@Test
	public void testModifieSetIdVariable() {
		Modifie mod = new Modifie();
		mod.setIdVariable(2);
		assertEquals(2, mod.getIdVariable());
	}
}
