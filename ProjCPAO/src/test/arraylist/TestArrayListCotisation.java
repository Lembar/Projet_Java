package test.arraylist;

import static org.junit.Assert.*;
import modele.metier.Cotisation;

import org.junit.Test;

import dao.arraylist.ArrayListCotisationDAO;

public class TestArrayListCotisation {

	@Test
	public void testSingleton() {
		assertNotNull(ArrayListCotisationDAO.getInstance());
	}
	
	@Test
	public void testListeCotisationNotNull(){
		assertNotNull(ArrayListCotisationDAO.getInstance().getCotisation());
	}	
	
	
	@Test
	public void testListeCotisationCreation(){
		Cotisation cot = new Cotisation("testC",0.42);
		ArrayListCotisationDAO.getInstance().create(cot);
		assertTrue(ArrayListCotisationDAO.getInstance().getCotisation().contains(cot));
	}
	
	@Test
	public void testListeCotisationDelete(){
		Cotisation cot = new Cotisation("testC",0.42);
		ArrayListCotisationDAO.getInstance().create(cot);
		ArrayListCotisationDAO.getInstance().delete(cot);
		assertFalse(ArrayListCotisationDAO.getInstance().getCotisation().contains(cot));
	}
	
	@Test
	public void testListeCotisationGetByID(){
		Cotisation cot = new Cotisation(555,"testC",0.42);
		ArrayListCotisationDAO.getInstance().create(cot);
		ArrayListCotisationDAO.getInstance().getByID(555);
		//assertEquals(,);
	}
	
	@Test
	public void testListeCotisationUpdateLibelle(){
		Cotisation cot = new Cotisation(555, "testC",0.42);
		ArrayListCotisationDAO.getInstance().create(cot);
		cot.setLibelle("testCbis");
		ArrayListCotisationDAO.getInstance().update(cot);
		assertEquals("testCbis",ArrayListCotisationDAO.getInstance().getByID(555).getLibelle());
	}
	
}
