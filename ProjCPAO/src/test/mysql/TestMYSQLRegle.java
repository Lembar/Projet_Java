package test.mysql;

import static org.junit.Assert.*;
import modele.metier.Regle;
import org.junit.Test;
import dao.mysql.MySQLRegleDAO;

public class TestMYSQLRegle {

	@Test
	public void testConnexion() {
		assertNotNull(MySQLRegleDAO.getInstance());
	}

	@Test
	public void testCreerRegleNotNull() {
		Regle r = new Regle(100,"statut='cadre' et brut>3200", "abc",true);
		Regle r1 = new Regle("a","a",true);
		MySQLRegleDAO.getInstance().create(r);
		r1 = MySQLRegleDAO.getInstance().getByID(100);
		assertNotNull(r1);
	}
}
