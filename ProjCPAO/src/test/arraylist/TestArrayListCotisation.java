package test.arraylist;

import static org.junit.Assert.*;

import org.junit.Test;

import dao.arraylist.ArrayListCotisationDAO;

public class TestArrayListCotisation {

	@Test
	public void testSingleton() {
		assertNotNull(ArrayListCotisationDAO.getInstance());
	}
	
	@Test
	public void testListCotisationNotNull(){
//		assertNotNull(ArrayListCotisationDAO.getInstance().get)
	}

}
