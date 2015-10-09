package test.arraylist;

import static org.junit.Assert.assertNotNull;
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
		Cotisation cot = new Cotisation("testCot",0.42);
		
	}
}
