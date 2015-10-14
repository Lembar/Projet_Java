package test.modele.metier;

import static org.junit.Assert.*;
import modele.metier.Concerne;

import org.junit.Test;

public class TestConcerne {

	Concerne conc = new Concerne(1, 1);

	@Test
	public void testConcerneNotNull() {
		assertNotNull(conc);
	}

	@Test
	public void testConcerneGetIdEmploye() {
		assertEquals(1, conc.getIdEmploye());

	}

	@Test
	public void testConcerneSetIdEmploye() {
		Concerne c1 = new Concerne();
		c1.setIdEmploye(2);
		assertEquals(2, c1.getIdEmploye());

	}

	@Test
	public void testConcerneGetIdRegle() {
		assertEquals(1, conc.getIdRegle());
	}

	@Test
	public void testConcerneSetIdRegle() {
		Concerne c1 = new Concerne();
		c1.setIdRegle(2);
		assertEquals(2, c1.getIdRegle());
	}

}