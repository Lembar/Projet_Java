package dao.mysql;

import java.sql.*;
import java.util.ArrayList;
import modele.metier.Variable;
import dao.VariableDAO;

public class MySQLVariableDAO implements VariableDAO {

	private static MySQLVariableDAO instance;

	public static MySQLVariableDAO getInstance() {
		if (instance == null) {
			instance = new MySQLVariableDAO();
		}
		return instance;
	}

	@Override
	public int create(Variable obj) {

		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = Connect.getInstance().prepareStatement(
					"INSERT INTO Variable values (null,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, obj.getLibelle());
			ps.setString(2, obj.getType());
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
	public void delete(Variable obj) {

		PreparedStatement ps = null;
		try {
			ps = (PreparedStatement) Connect.getInstance().prepareStatement(
					"DELETE FROM Variable WHERE id_variable=?");
			ps.setInt(1, obj.getId());
			ps.executeUpdate();
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Variable obj) {

		PreparedStatement ps = null;
		try {
			ps = Connect
					.getInstance()
					.prepareStatement(
							"UPDATE Variable SET libelle_var=?, type=? WHERE id_variable=?");
			ps.setString(1, obj.getLibelle());
			ps.setString(2, obj.getType());
			ps.setInt(3, obj.getId());
			ps.executeUpdate();
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Variable getByID(int id) {

		Variable var = null;
		PreparedStatement ps = null;
		try {
			ps = Connect.getInstance().prepareStatement(
					"SELECT * FROM Variable WHERE id_variable=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				var = new Variable(id, rs.getString("libelle_var"),
						rs.getString("type"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return var;
	}

	@Override
	public ArrayList<Variable> getVariable() {
		// TODO Auto-generated method stub
		return null;
	}

}
