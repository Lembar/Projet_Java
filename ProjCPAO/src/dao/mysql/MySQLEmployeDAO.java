package dao.mysql;

import java.sql.*;
import java.util.ArrayList;

import modele.metier.Employe;
import modele.metier.Regle;
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

		try {
			ResultSet res = Connect
					.getInstance()
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_UPDATABLE)
					.executeQuery("SELECT * FROM Employe WHERE id_emp" + id);
			if (res.next()) {
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public ArrayList<Regle> getRegle(Employe emp) {
		try {
			Connect.getInstance()
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_UPDATABLE)
					.executeQuery("SELECT * FROM Regle LEFT JOIN Concerne ON Regle.id_regle=Concerne.id_regle WHERE id_emp="+ emp.getId());
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
