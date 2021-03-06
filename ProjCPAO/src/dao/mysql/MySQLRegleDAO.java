package dao.mysql;

import java.sql.*;
import java.util.ArrayList;

import model.metier.Regle;
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
	public int create(Regle obj) {

		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = Connect.getInstance().prepareStatement(
					"INSERT INTO Regle values (null,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, obj.getCondition());
			ps.setString(2, obj.getAction());
			ps.setInt(3, obj.getActif());
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
			ps.setString(1, obj.getCondition());
			ps.setString(2, obj.getAction());
			ps.setInt(3, obj.getActif());
			ps.setInt(4, obj.getId());
			ps.executeUpdate();
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Regle getByID(int id) {

		Regle reg = null;
		PreparedStatement ps = null;
		try {
			ps = Connect.getInstance().prepareStatement(
					"SELECT * FROM Regle WHERE id_regle=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				reg = new Regle(id, rs.getString("conditio"),
						rs.getString("action"), rs.getInt("actif"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return reg;
	}

	@Override
	public ArrayList<Regle> findAll() {

		ArrayList<Regle> liste = new ArrayList<Regle>();
		Regle reg = null;
		PreparedStatement ps = null;

		try {
			ps = Connect.getInstance().prepareStatement(
					"SELECT * FROM Regle order by conditio, action, actif");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				reg = new Regle(rs.getInt("id_regle"), rs.getString("conditio"),
						rs.getString("action"), rs.getInt("actif"));
				liste.add(reg);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return liste;
	}

}
