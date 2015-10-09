package dao.mysql;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Connect {

	private static Connection connexion;

	public static Properties load(String bdd) {
		Properties properties = new Properties();

		FileInputStream input = null;
		try {
			input = new FileInputStream(bdd);

			properties.loadFromXML(input);
		} catch (IOException e) {
			System.out.println("pb fichier de config");
		} finally {
			try {
				input.close();
			} catch (IOException e) {
				System.out.println("pb fermeture fichier de config");
			}
		}

		return properties;
	}

	public static Connection getInstance() {
		Properties p = load("config/bdd.properties");

		try {
			if (connexion == null || connexion.isClosed()) {
				try {
					connexion = DriverManager.getConnection(
							p.getProperty("adresse_ip") + ":"
									+ p.getProperty("port") + '/'
									+ p.getProperty("bdd"),
							p.getProperty("login"), p.getProperty("pass"));
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connexion;
	}

}
