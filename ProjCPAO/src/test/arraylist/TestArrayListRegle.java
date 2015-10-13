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
	public void testListeRegleGetByIDNotNull() {
		Regle regle = new Regle("Statut = Cadre", "Rep = 0.008", false);
		int id = ArrayListRegleDAO.getInstance().create(regle);
		assertNotNull(ArrayListRegleDAO.getInstance().getByID(id));
	}

	@Test
	public void testListeRegleGetByID() {
		Regle cot = new Regle("Statut = Cadre", "Rep = 0.008", false);
		int id = ArrayListRegleDAO.getInstance().create(cot);
		assertEquals(id, ArrayListRegleDAO.getInstance().getByID(id).getId());
	}

	@Test
	public void testListeRegleUpdateCondition() {
		Regle regle = new Regle("Statut = Cadre", "Rep = 0.008", false);
		int id = ArrayListRegleDAO.getInstance().create(regle);
		regle.setCondition("Statut = Salarié");
		ArrayListRegleDAO.getInstance().update(regle);
		assertEquals("Statut = Salarié", ArrayListRegleDAO.getInstance().getByID(id).getCondition());
	}

	@Test
	public void testListeRegleUpdateAction() {
		Regle regle = new Regle("Statut = Cadre", "Rep = 0.008", false);
		int id = ArrayListRegleDAO.getInstance().create(regle);
		regle.setAction("RCP = 0,05");
		ArrayListRegleDAO.getInstance().update(regle);
		assertEquals("RCP = 0,05", ArrayListRegleDAO.getInstance().getByID(id).getAction());
	}

	@Test
	public void testListeRegleUpdateActif() {
		Regle regle = new Regle("Statut = Cadre", "Rep = 0.008", false);
		int id = ArrayListRegleDAO.getInstance().create(regle);
		regle.setActif(true);
		ArrayListRegleDAO.getInstance().update(regle);
		assertEquals(true, ArrayListRegleDAO.getInstance().getByID(id).getActif());
	}

}
