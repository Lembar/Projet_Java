package test.modele.metier;

import static org.junit.Assert.*;
import modele.metier.Cotisation;

import org.junit.Test;

public class TestCotisation {

	Cotisation cot = new Cotisation(1, "Retraite", 50);

	@Test
	public void testCotisationNotNull() {
		assertNotNull(cot);
	}

	@Test
	public void testCotisationGetId() {
		assertEquals(1, cot.getId());

	}

	@Test
	public void testCotisationSetId() {
		Cotisation c1 = new Cotisation();
		c1.setId(2);
		assertEquals(2, c1.getId());

	}

	@Test
	public void testCotisationGetLibelle() {
		assertEquals("Retraite", cot.getLibelle());
	}

	@Test
	public void testCotisationSetLibelle() {
		Cotisation c1 = new Cotisation();
		c1.setLibelle("titi");
		assertEquals("titi", c1.getLibelle());
	}

	@Test
	public void testCotisationGetTaux() {
		assertEquals(50, cot.getTaux(), 0);
	}

	@Test
	public void testCotisationSetTaux() {
		Cotisation c1 = new Cotisation();
		c1.setTaux(40);
		assertEquals(40, c1.getTaux(), 0);

	}

}
