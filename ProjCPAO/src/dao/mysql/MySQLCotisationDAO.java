package dao.mysql;

import java.sql.*;

import modele.metier.Cotisation;
import dao.CotisationDAO;

public class MySQLCotisationDAO implements CotisationDAO {
	private static MySQLCotisationDAO instance;

	public static MySQLCotisationDAO getInstance() {
		if (instance == null) {
			instance = new MySQLCotisationDAO();
		}
		return instance;
	}

	@Override
	public int create(Cotisation obj) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = Connect.getInstance().prepareStatement(
					"INSERT INTO Cotisation values (null,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, obj.getLibelle());
			ps.setDouble(2, obj.getTaux());
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			rs.next();
			return rs.getInt(1);
		}

		catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	public void delete(Cotisation obj) {

		PreparedStatement ps = null;
		try {
			ps = Connect.getInstance().prepareStatement(
					"DELETE FROM Cotisation WHERE id_cotis=?");
			ps.setInt(1, obj.getId());
			ps.executeUpdate();
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Cotisation obj) {

		PreparedStatement ps = null;
		try {
			ps = Connect
					.getInstance()
					.prepareStatement(
							"UPDATE Cotisation SET libelle_cotis=?, taux_cotis=? WHERE id_cotis=?");
			ps.setString(1, obj.getLibelle());
			ps.setDouble(2, obj.getTaux());
			ps.setInt(3, obj.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Cotisation getByID(int id) {

		Cotisation cot = null;
		PreparedStatement ps = null;
		try {
			ps = Connect.getInstance().prepareStatement(
					"SELECT * FROM Cotisation WHERE id_cotis=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				cot = new Cotisation(id, rs.getString("libelle_cotis"),
						rs.getDouble("taux_cotis"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cot;
	}
}
