package test.arraylist;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import dao.arraylist.ArrayListCotisationDAO;
import modele.metier.Cotisation;

public class TestArrayListCotisation {

	@Test
	public void testSingleton() {
		assertNotNull(ArrayListCotisationDAO.getInstance());
	}

	@Test
	public void testListeCotisationNotNull() {
		assertNotNull(ArrayListCotisationDAO.getInstance().getCotisation());
	}

	@Test
	public void testListeCotisationCreation() {
		Cotisation cot = new Cotisation("testC", 0.42);
		ArrayListCotisationDAO.getInstance().create(cot);
		assertTrue(ArrayListCotisationDAO.getInstance().getCotisation().contains(cot));
	}

	@Test
	public void testListeCotisationDelete() {
		Cotisation cot = new Cotisation("testC", 0.42);
		ArrayListCotisationDAO.getInstance().create(cot);
		ArrayListCotisationDAO.getInstance().delete(cot);
		assertFalse(ArrayListCotisationDAO.getInstance().getCotisation().contains(cot));
	}
	
	@Test
	public void testListeCotisationGetByIDNotNull() {
		Cotisation cot = new Cotisation(555, "testC", 0.42);
		ArrayListCotisationDAO.getInstance().create(cot);
		assertNotNull(ArrayListCotisationDAO.getInstance().getByID(555));
	}

	@Test
	public void testListeCotisationGetByID() {
		Cotisation cot = new Cotisation(555, "testC", 0.42);
		ArrayListCotisationDAO.getInstance().create(cot);
		assertEquals(555, ArrayListCotisationDAO.getInstance().getByID(555).getId());
	}

	@Test
	public void testListeCotisationUpdateLibelle() {
		Cotisation cot = new Cotisation("testC", 0.42);
		int id = ArrayListCotisationDAO.getInstance().create(cot);
		cot.setLibelle("testCotisation");
		ArrayListCotisationDAO.getInstance().update(cot);
		assertEquals("testCotisation", ArrayListCotisationDAO.getInstance().getByID(id).getLibelle());
	}

	@Test
	public void testListeCotisationUpdateTaux() {
		Cotisation cot = new Cotisation("testC", 0.42);
		int id = ArrayListCotisationDAO.getInstance().create(cot);
		cot.setTaux(0.666);
		ArrayListCotisationDAO.getInstance().update(cot);
		assertEquals(0.666, ArrayListCotisationDAO.getInstance().getByID(id).getTaux(),1e-5);
	}

}
