package test.model.metier;

import static org.junit.Assert.*;
import model.metier.Regle;

import org.junit.Test;

public class TestRegle {

	Regle regle = new Regle(2, "Statut = cadre", "Pce = 0.05", 0);

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
		Regle regle = new Regle();
		regle.setId(1);
		assertEquals(1, regle.getId());
	}

	@Test
	public void testRegleGetCondition() {
		assertEquals("Statut = cadre", regle.getCondition());

	}

	@Test
	public void testRegleSetConditionChaine() {
		Regle regle = new Regle();
		regle.setCondition("abc");
		assertEquals("abc", regle.getCondition());
	}

	@Test(expected=IllegalArgumentException.class)
	public void testRegleSetConditionVide() {
		Regle regle = new Regle();
		regle.setCondition("");
		assertEquals("", regle.getCondition());
	}

	@Test(expected=IllegalArgumentException.class)
	public void testRegleSetConditionEspaces() {
		Regle regle = new Regle();
		regle.setCondition("     ");
		assertEquals("     ", regle.getCondition());
	}

	@Test
	public void testRegleGetAction() {
		assertEquals("Pce = 0.05", regle.getAction());

	}

	@Test
	public void testRegleSetActionChaine() {
		Regle regle = new Regle();
		regle.setAction("abc");
		assertEquals("abc", regle.getAction());
	}

	@Test(expected=IllegalArgumentException.class)
	public void testRegleSetActionVide() {
		Regle regle = new Regle();
		regle.setAction("");
		assertEquals("", regle.getAction());
	}

	@Test(expected=IllegalArgumentException.class)
	public void testRegleSetActionEspaces() {
		Regle regle = new Regle();
		regle.setAction("     ");
		assertEquals("     ", regle.getAction());
	}

	@Test
	public void testRegleGetActif() {
		assertEquals(false, regle.getActif());

	}

	@Test
	public void testRegleSetActif() {
		Regle regle = new Regle();
		regle.setActif(1);
		assertEquals(true, regle.getActif());

	}

}
