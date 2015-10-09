package dao.mysql;

import java.sql.*;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import modele.metier.Regle;
import dao.RegleDAO;

public class MySQLRegleDAO implements RegleDAO {
	private static MySQLRegleDAO instance;

	public static MySQLRegleDAO getInstance() {
		if (instance == null) {
			instance = new MySQLRegleDAO();
		}
		return instance;
	}

	@Override
	public void create(Regle obj) {

		PreparedStatement ps = null;
		try {
			ps = (PreparedStatement) Connect.getInstance().prepareStatement(
					"INSERT INTO Regle values (null,?,?,?)");
			ps.setString(1, obj.getCond());
			ps.setString(2, obj.getAction());
			ps.setBoolean(3, obj.getActif());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Regle obj) {

		PreparedStatement ps = null;
		try {
			ps = (PreparedStatement) Connect.getInstance().prepareStatement(
					"DELETE FROM Regle WHERE id_regle=?");
			ps.setInt(1, obj.getId());
			ps.executeUpdate();
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Regle obj) {

		PreparedStatement ps = null;
		try {
			ps = (PreparedStatement) Connect
					.getInstance()
					.prepareStatement(
							"UPDATE Regle SET conditio=?, action=?, actif=? WHERE id_regle=?");
			ps.setString(1, obj.getCond());
			ps.setString(2, obj.getAction());
			ps.setBoolean(3, obj.getActif());
			ps.setInt(4, obj.getId());
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Regle getByID(int id) {

		Regle reg = null;
		try {
			ResultSet res = Connect
					.getInstance()
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_UPDATABLE)
					.executeQuery("SELECT * FROM Employe WHERE id_emp" + id);
			if (res.next()) {
				reg = new Regle(res.getInt(0), res.getString("condition"),
						res.getString("action"), res.getBoolean("actif"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public ArrayList<Regle> getRegle() {
		// TODO Auto-generated method stub
		return null;
	}
}
