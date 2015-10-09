package test.modele.metier;

import static org.junit.Assert.*;
import modele.metier.Employe;

import org.junit.Test;

public class TestEmploye {
	
	Employe e1 = new Employe(1,"Zeis","Oceane");
	
	@Test
	public void TestEmployeNotNull() {
		assertNotNull(e1);	
	}
	
	@Test
	public void TestEmployeGetId() {
		assertEquals(1, e1.getId());
	}

	@Test
	public void TestEmployeSetId() {
		Employe e = new Employe();
		e.setId(1);
		assertEquals(1,e.getId());
	}
	
	@Test
	public void TestEmployeGetNom() {
		assertEquals("Zeis",e1.getNom());
	}
	
	@Test
	public void TestEmployeSetNom(){
		Employe e = new Employe();
		e.setNom("Toto");
		assertEquals(e.getNom(),"Toto");
	}
	
	@Test
	public void TestEmployeGetPrenom() {
		assertEquals("Oceane",e1.getPrenom());
	}
	
	@Test
	public void TestEmployeSetPrenom(){
		Employe e = new Employe();
		e.setPrenom("Toto");
		assertEquals(e.getPrenom(),"Toto");
	}
	
	
}


