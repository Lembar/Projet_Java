package test.modele.metier;

import static org.junit.Assert.*;
import modele.metier.Regle;

import org.junit.Test;

public class TestRegle {

	Regle r2 = new Regle(2, "cadre", "Pce=0.05", false);

	@Test
	public void TestRegleNotNull() {
		assertNotNull(r2);
	}
	
	@Test
	public void TestRegleGetId() {
		assertEquals(2, r2.getId());
	}

	@Test
	public void TestRegleSetId() {
		Regle r1 = new Regle();
		r1.setId(1);
		assertEquals(r1.getId(), 1);
	}
	
	@Test
	public void TestRegleGetCond() {
		assertEquals(r2.getCondition(),"cadre");
		
	}
	
	@Test
	public void TestRegleSetCond() {
		Regle r3 = new Regle();
		r3.setCondition("abc");
		assertEquals(r3.getCondition(),"abc");
	}
	
	@Test
	public void TestRegleGetAction() {
		assertEquals("Pce=0.05",r2.getAction());
		
	}
	
	@Test
	public void TestRegleSetAction() {
		Regle r3 = new Regle();
		r3.setAction("abc");
		assertEquals(r3.getAction(),"abc");
		
	}
	
	@Test
	public void TestRegleGetActif() {
		assertEquals(r2.getActif(),false);
		
	}
	
	@Test
	public void TestRegleSetActif() {
		Regle r3 = new Regle();
		r3.setActif(true);
		assertEquals(r3.getActif(),true);
		
	}
	
	
}
