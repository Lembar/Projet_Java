package dao.mysql;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;


import modele.metier.Employe;
import modele.metier.Regle;
import modele.metier.Variable;
import dao.EmployeDAO;

public class MySQLEmployeDAO implements EmployeDAO {

	private static MySQLEmployeDAO instance;

	public static MySQLEmployeDAO getInstance() {
		if (instance == null) {
			instance = new MySQLEmployeDAO();
		}
		return instance;
	}

	@Override
	public void create(Employe obj) {

		PreparedStatement ps = null;
		try {
			ps = (PreparedStatement) Connect.getInstance().prepareStatement(
					"INSERT INTO Employe values (null,?,?)");
			ps.setString(1, obj.getNom());
			ps.setString(2, obj.getPrenom());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Employe obj) {

		PreparedStatement ps = null;
		try {
			ps = (PreparedStatement) Connect.getInstance().prepareStatement(
					"DELETE FROM Employe WHERE id_emp=?");
			ps.setInt(1, obj.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Employe obj) {

		PreparedStatement ps = null;
		try {
			ps = (PreparedStatement) Connect.getInstance().prepareStatement(
					"UPDATE Employe SET =?, =? WHERE id_emp=?");
			ps.setString(1, obj.getNom());
			ps.setString(2, obj.getPrenom());
			ps.setInt(3, obj.getId());

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Employe getByID(int id) {

		Employe emp = null;
		try {
			ResultSet res = Connect
					.getInstance()
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_UPDATABLE)
					.executeQuery("SELECT * FROM Employe WHERE id_emp" + id);
			if (res.next()) {
				emp = new Employe(res.getInt(0), res.getString("nom"),
						res.getString("prenom"), null);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public ArrayList<Regle> getRegle(Employe obj) {
		ArrayList<Regle> regl = new ArrayList<Regle>();
		PreparedStatement ps = null;

		try {
			ps = Connect
					.getInstance().prepareStatement("SELECT Regle.id_regle, Regle.conditio, action, actif FROM Regle, Concerne WHERE Regle.id_regle=Concerne.id_regle AND id_emp=?");
			ps.setInt(1, obj.getId());
			ResultSet rs=ps.executeQuery();
			while(rs.next())
				regl.add(new Regle(rs.getInt("id"), rs.getString("conditio"), rs.getString("action"), rs.getBoolean("actif")));
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public HashMap<Variable, String> getHm(int id) {
		HashMap<Variable, String> map = new HashMap<Variable, String>();
		PreparedStatement ps = null;
		try {
			ps = (PreparedStatement) Connect
					.getInstance()
					.prepareStatement(
							"SELECT VARIABLE.id_variable,libelle_var,type,valeur FROM Variable,Modifie where id_emp=? AND Variable.id_variable=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
				map.put(new Variable(rs.getInt("id_variable"), rs
						.getString("libelle_var"), rs.getString("type")), rs
						.getString("valeur"));
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return map;
	}
}
