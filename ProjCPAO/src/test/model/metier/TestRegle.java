package test.model.metier;

import static org.junit.Assert.*;
import model.metier.Regle;

import org.junit.Test;

public class TestRegle {

	Regle regle = new Regle(2, "Statut = cadre", "Pce = 0.05", false);

	@Test
	public void testRegleNotNull() {
		assertNotNull(regle);
	}

	@Test
	public void testRegleGetId() {
		assertEquals(2, regle.getId());
	}

	@Test
	public void testRegleSetId() {
		Regle r1 = new Regle();
		r1.setId(1);
		assertEquals(1, r1.getId());
	}

	@Test
	public void testRegleGetCondition() {
		assertEquals("Statut = cadre", regle.getCondition());

	}

	@Test
	public void testRegleSetCondition() {
		Regle r3 = new Regle();
		r3.setCondition("abc");
		assertEquals("abc", r3.getCondition());
	}

	@Test
	public void testRegleGetAction() {
		assertEquals("Pce = 0.05", regle.getAction());

	}

	@Test
	public void testRegleSetAction() {
		Regle r3 = new Regle();
		r3.setAction("abc");
		assertEquals("abc", r3.getAction());

	}

	@Test
	public void testRegleGetActif() {
		assertEquals(false, regle.getActif());

	}

	@Test
	public void testRegleSetActif() {
		Regle r3 = new Regle();
		r3.setActif(true);
		assertEquals(true, r3.getActif());

	}

}
