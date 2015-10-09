package dao.mysql;

import java.sql.*;
import com.mysql.jdbc.PreparedStatement;
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
	public void create(Cotisation obj) {
		PreparedStatement ps = null;
		try {
			ps = (PreparedStatement) Connect.getInstance()
					.prepareStatement("INSERT INTO Cotisation values (null,?,?)");
							ps.setString(1,obj.getLibelle());
							ps.setDouble(2,obj.getTaux());
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Cotisation obj) {

		PreparedStatement ps = null;
		try {
			ps=(PreparedStatement) Connect.getInstance()
					.prepareStatement("DELETE FROM Cotisation WHERE id_cotis=?");
					ps.setInt(1,obj.getId());
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
			ps =(PreparedStatement) Connect.getInstance()
					.prepareStatement("UPDATE Cotisation SET libelle_cotis=?, taux_cotis=? WHERE id_cotis");
				    ps.setString(1, obj.getLibelle());
					ps.setDouble(2, obj.getTaux());
					ps.setInt(3,obj.getId());
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Cotisation getByID(int id) {

		Cotisation cot = null;
		try {
			ResultSet res = Connect
					.getInstance()
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_UPDATABLE)
					.executeQuery(
							"SELECT * FROM Cotisation WHERE id_cotis" + id);
			if (res.next()) {
				cot = new Cotisation(res.getInt(0),
						res.getString("libelle_cotis"),
						res.getDouble("taux_cotis"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

}
