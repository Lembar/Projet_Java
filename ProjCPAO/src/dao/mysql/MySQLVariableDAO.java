package dao.mysql;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

import com.mysql.jdbc.PreparedStatement;

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
	public void create(Variable obj) {

		PreparedStatement ps = null;
		try {
			ps = (PreparedStatement) Connect.getInstance().prepareStatement("INSERT INTO Variable values (null,?,?)");
			ps.setString(1, obj.getLibelle());
			ps.setString(2, obj.getType());
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Variable obj) {

		PreparedStatement ps = null;
		try {
			ps = (PreparedStatement) Connect.getInstance().prepareStatement("DELETE FROM Variable WHERE id_regle=?");
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
			ps = (PreparedStatement) Connect.getInstance()
					.prepareStatement("UPDATE Variable SET libelle=?, type=? WHERE id_regle=?");
			ps.setString(1, obj.getLibelle());
			ps.setString(2, obj.getType());
			ps.setInt(3, obj.getId());
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Variable getByID(int id) {

		Variable var = null;
		try {
			ResultSet res = Connect.getInstance()
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
					.executeQuery("SELECT * FROM Employe WHERE id_emp" + id);
			if (res.next()) {
				var = new Variable(res.getInt(0), res.getString("libele_var"), res.getString("type"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public ArrayList<Variable> getVariable() {
		// TODO Auto-generated method stub
		return null;
	}

}
