package test.model.metier;

import static org.junit.Assert.*;
import model.metier.Cotisation;

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
		Cotisation cot = new Cotisation();
		cot.setId(2);
		assertEquals(2, cot.getId());

	}

	@Test
	public void testCotisationGetLibelle() {
		assertEquals("Retraite", cot.getLibelle());
	}

	@Test
	public void testCotisationSetLibelleChaine() {
		Cotisation cot = new Cotisation();
		cot.setLibelle("titi");
		assertEquals("titi", cot.getLibelle());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCotisationSetLibelleVide() {
		Cotisation cot = new Cotisation();
		cot.setLibelle("");
		assertEquals("", cot.getLibelle());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCotisationSetLibelleEspaces() {
		Cotisation cot = new Cotisation();
		cot.setLibelle("     ");
		assertEquals("     ", cot.getLibelle());
	}

	@Test
	public void testCotisationGetTaux() {
		assertEquals(50, cot.getTaux(), 0);
	}

	@Test
	public void testCotisationSetTaux() {
		Cotisation cot = new Cotisation();
		cot.setTaux(40);
		assertEquals(40, cot.getTaux(), 0);

	}

}
