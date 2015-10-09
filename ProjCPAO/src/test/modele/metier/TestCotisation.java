package test.modele.metier;

import static org.junit.Assert.*;
import modele.metier.Cotisation;

import org.junit.Test;

public class TestCotisation {

	Cotisation c1 = new Cotisation(1, "Retraite", 50);

	@Test
	public void TestCotisNotNull() {
		assertNotNull(c1);
	}

	@Test
	public void TestCotisGetId() {
		assertEquals(1, c1.getId());

	}

	@Test
	public void TestCotisSetId() {
		Cotisation c1 = new Cotisation();
		c1.setId(2);
		assertEquals(2, c1.getId());

	}
	
	@Test
	public void TestCotisGetLibelle() {
		assertEquals(c1.getLibelle(),"Retraite");
	}
	
	@Test
	public void TestCotisSetLibelle() {
		Cotisation c1 = new Cotisation();
		c1.setLibelle("titi");
		assertEquals("titi",c1.getLibelle());
	}

	@Test
	public void TestCotisGetTaux() {
		assertEquals(50,c1.getTaux(),0);
	}
	
	@Test
	public void TestCotisSetTaux() {
		Cotisation c1 = new Cotisation();
		c1.setTaux(40);
		assertEquals(40,c1.getTaux(),0);
		
	}
	
	
}
