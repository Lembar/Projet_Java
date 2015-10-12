package test.arraylist;

import static org.junit.Assert.*;

import org.junit.Test;

import dao.arraylist.ArrayListRegleDAO;
import modele.metier.Regle;

public class TestArrayListRegle {

	@Test
	public void testSingleton() {
		assertNotNull(ArrayListRegleDAO.getInstance());
	}

	@Test
	public void testListeRegleNotNull() {
		assertNotNull(ArrayListRegleDAO.getInstance().getRegle());
	}

	@Test
	public void testListeRegleCreation() {
		Regle cot = new Regle("Statut = Cadre", "Rep = 0.008", false);
		ArrayListRegleDAO.getInstance().create(cot);
		assertTrue(ArrayListRegleDAO.getInstance().getRegle().contains(cot));
	}

	@Test
	public void testListeRegleDelete() {
		Regle cot = new Regle("Statut = Cadre", "Rep = 0.008", false);
		;
		ArrayListRegleDAO.getInstance().create(cot);
		ArrayListRegleDAO.getInstance().delete(cot);
		assertFalse(ArrayListRegleDAO.getInstance().getRegle().contains(cot));
	}

	@Test
	public void testListeRegleGetByID() {
		Regle cot = new Regle(555, "Statut = Cadre", "Rep = 0.008", false);
		ArrayListRegleDAO.getInstance().create(cot);
		assertEquals(555, ArrayListRegleDAO.getInstance().getByID(555).getId());
	}

	@Test
	public void testListeRegleUpdateID() {
		Regle regle = new Regle(555, "Statut = Cadre", "Rep = 0.008", false);
		ArrayListRegleDAO.getInstance().create(regle);
		regle.setId(666);
		ArrayListRegleDAO.getInstance().update(regle);
		assertEquals(666, ArrayListRegleDAO.getInstance().getByID(555).getId());
	}

	@Test
	public void testListeRegleUpdateCondition() {
		Regle regle = new Regle(555, "Statut = Cadre", "Rep = 0.008", false);
		ArrayListRegleDAO.getInstance().create(regle);
		regle.setCond("Brut > 3200 ET statut = “employé“");
		ArrayListRegleDAO.getInstance().update(regle);
		assertEquals("Brut > 3200 ET statut = “employé“", ArrayListRegleDAO.getInstance().getByID(555).getCond());
	}

	@Test
	public void testListeRegleUpdateAction() {
		Regle regle = new Regle(555, "Statut = Cadre", "Rep = 0.008", false);
		ArrayListRegleDAO.getInstance().create(regle);
		regle.setAction("RCP = 0,05");
		ArrayListRegleDAO.getInstance().update(regle);
		assertEquals("RCP = 0,05", ArrayListRegleDAO.getInstance().getByID(555).getAction());
	}

	@Test
	public void testListeRegleUpdateActif() {
		Regle regle = new Regle(555, "Statut = Cadre", "Rep = 0.008", false);
		ArrayListRegleDAO.getInstance().create(regle);
		regle.setActif(true);
		ArrayListRegleDAO.getInstance().update(regle);
		assertEquals(true, ArrayListRegleDAO.getInstance().getByID(555).getActif());
	}

}
