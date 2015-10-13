package test.mysql;

import static org.junit.Assert.*;
import modele.metier.Cotisation;
import org.junit.Test;
import dao.mysql.MySQLCotisationDAO;


public class TestMYSQLCotisation {

	@Test
	public void testConnexion() {
		assertNotNull(MySQLCotisationDAO.getInstance());
	}
	
	@Test
	public void testCreerCotisationNotNull() {
		Cotisation c = new Cotisation(1,"brut", 10);
		Cotisation c1 = new Cotisation(2,"a",0);
		MySQLCotisationDAO.getInstance().create(c);
		c1 = MySQLCotisationDAO.getInstance().getByID(1);
		assertNotNull(c1);

	}
	
	@Test
	public void testCreerCotisation() {
		Cotisation c = new Cotisation(1,"Retraite", 10);
		Cotisation c1 = new Cotisation("a",0);
		MySQLCotisationDAO.getInstance().create(c);
		c1 = MySQLCotisationDAO.getInstance().getByID(1);
		assertEquals("Retraite", c1.getLibelle());
		assertEquals("10", c1.getTaux());
	}
	
	@Test
	public void testGetByIdNotNull() {
		assertNotNull(MySQLCotisationDAO.getInstance().getByID(1));
	}
	
	@Test
	public void testGetById() {
		Cotisation c = new Cotisation(4, "Retraite", 54);
		assertEquals(c.getId(), MySQLCotisationDAO.getInstance().getByID(4)
				.getId());
		assertEquals(c.getLibelle(), MySQLCotisationDAO.getInstance().getByID(4)
				.getLibelle());
		assertEquals(c.getTaux(), MySQLCotisationDAO.getInstance().getByID(4)
				.getTaux(),0);
	}
	

	@Test
	public void testUpdateCotisation() {
		Cotisation v1 = new Cotisation(2, "Retraite", 20);
		MySQLCotisationDAO.getInstance().update(v1);
		assertEquals(v1.getId(), MySQLCotisationDAO.getInstance().getByID(2)
				.getId());
		assertEquals(v1.getLibelle(), MySQLCotisationDAO.getInstance().getByID(2)
				.getLibelle());
		assertEquals(v1.getTaux(), MySQLCotisationDAO.getInstance().getByID(2)
				.getTaux(),0);
	}
	
	@Test
	public void testUpdateCotisationNotNull() {
		Cotisation v = new Cotisation(50,"Retraite", 78);
		Cotisation v1 = new Cotisation("a",0);
		MySQLCotisationDAO.getInstance().update(v);
		v1 = MySQLCotisationDAO.getInstance().getByID(50);
		assertNotNull(v1);
	}
	
	@Test
	public void testDeleteCotisation() {
		Cotisation v = new Cotisation(8, "Retraite", 20);
		MySQLCotisationDAO.getInstance().delete(v);
		assertNull(MySQLCotisationDAO.getInstance().getByID(8));
	}
}
