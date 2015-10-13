package test.arraylist;

import static org.junit.Assert.*;

import org.junit.Test;
import dao.arraylist.ArrayListEmployeDAO;
import modele.metier.Employe;

public class TestArrayListEmploye {

	@Test
	public void testSingleton() {
		assertNotNull(ArrayListEmployeDAO.getInstance());
	}

	@Test
	public void testListeEmployeNotNull() {
		assertNotNull(ArrayListEmployeDAO.getInstance().getEmploye());
	}

	@Test
	public void testListeEmployeCreation() {
		Employe emp = new Employe("Doe", "John");
		ArrayListEmployeDAO.getInstance().create(emp);
		assertTrue(ArrayListEmployeDAO.getInstance().getEmploye().contains(emp));
	}

	@Test
	public void testListeEmployeDelete() {
		Employe emp = new Employe("Doe", "John");
		ArrayListEmployeDAO.getInstance().create(emp);
		ArrayListEmployeDAO.getInstance().delete(emp);
		assertFalse(ArrayListEmployeDAO.getInstance().getEmploye().contains(emp));
	}

	@Test
	public void testListeEmployeGetByIDNotNull() {
		Employe emp = new Employe("Doe", "John");
		int id = ArrayListEmployeDAO.getInstance().create(emp);
		assertNotNull(ArrayListEmployeDAO.getInstance().getByID(id));
	}

	@Test
	public void testListeEmployeGetByID() {
		Employe emp = new Employe("Doe", "John");
		int id = ArrayListEmployeDAO.getInstance().create(emp);
		assertEquals(id, ArrayListEmployeDAO.getInstance().getByID(id).getId());
	}

	@Test
	public void testListeEmployeUpdateNom() {
		Employe emp = new Employe("Doe", "John");
		int id = ArrayListEmployeDAO.getInstance().create(emp);
		emp.setNom("Lemétayer");
		ArrayListEmployeDAO.getInstance().update(emp);
		assertEquals("Lemétayer", ArrayListEmployeDAO.getInstance().getByID(id).getNom());
	}

	@Test
	public void testListeEmployeUpdatePrenom() {
		Employe emp = new Employe("Doe", "John");
		int id = ArrayListEmployeDAO.getInstance().create(emp);
		emp.setPrenom("Léo");
		ArrayListEmployeDAO.getInstance().update(emp);
		assertEquals("Léo", ArrayListEmployeDAO.getInstance().getByID(id).getPrenom());
	}

}
