package dao.mysql;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

import model.metier.Employe;
import model.metier.Regle;
import model.metier.Variable;
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
	public int create(Employe obj) {

		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = Connect.getInstance().prepareStatement(
					"INSERT INTO Employe values (null,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, obj.getNom());
			ps.setString(2, obj.getPrenom());
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			rs.next();
			return rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
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
					"UPDATE Employe SET nom=?, prenom=? WHERE id_emp=?");
			ps.setString(1, obj.getNom());
			ps.setString(2, obj.getPrenom());
			ps.setInt(3, obj.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Employe getByID(int id) {

		Employe emp = null;
		PreparedStatement ps = null;
		try {
			ps = Connect.getInstance().prepareStatement(
					"SELECT * FROM Employe WHERE id_emp=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				emp = new Employe(id, rs.getString("nom"),
						rs.getString("prenom"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return emp;
	}

	@Override
	public ArrayList<Regle> getRegle(Employe obj) {
		ArrayList<Regle> regl = new ArrayList<Regle>();
		PreparedStatement ps = null;

		try {
			ps = Connect
					.getInstance()
					.prepareStatement(
							"SELECT Regle.id_regle, Regle.conditio, action, actif FROM Regle, Concerne WHERE Regle.id_regle=Concerne.id_regle AND id_emp=?");
			ps.setInt(1, obj.getId());
			ResultSet rs = ps.executeQuery();
			while (rs.next())
				regl.add(new Regle(rs.getInt("id"), rs.getString("conditio"),
						rs.getString("action"), rs.getBoolean("actif")));
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

	@Override
	public ArrayList<Employe> findAll() {

		ArrayList<Employe> liste = new ArrayList<Employe>();
		Employe emp = null;
		PreparedStatement ps = null;

		try {
			ps = Connect.getInstance().prepareStatement(
					"SELECT * FROM Employe order by nom, prenom");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				emp = new Employe(rs.getInt("id_emp"), rs.getString("nom"),
						rs.getString("prenom"));
				liste.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return liste;
	}
}
