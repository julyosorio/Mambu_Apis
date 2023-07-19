package co.com.bancopichincha.mambu.utils.database;

import java.sql.*;
import java.util.logging.Logger;

import static co.com.bancopichincha.mambu.utils.database.SqlTemplate.getTable;

public class ConnectSQLite {

	private static final Logger LOGGER = Logger.getLogger(ConnectSQLite.class.getName());

	public static Connection connect() throws NullPointerException, SQLException {

		Connection conn;
		String url = "jdbc:sqlite:src/test/resources/database/BP.db";
		conn = DriverManager.getConnection(url);
		LOGGER.info("Conectado a la base de datos");
		return conn;
	}

	public static String[] selectAll(String nameTable) {

		String[] data = {"null", "null", "null"};

		try (Connection conn = connect();
			  Statement stmt = conn.createStatement();
			  ResultSet rs = stmt.executeQuery(getTable(nameTable))) {
			LOGGER.info("antes");

			while (rs.next()) {
				switch (nameTable) {
					case "clientsupdate":
						data[0] = rs.getString("id");
						data[1] = rs.getString("encodedkey");
						data[2] = rs.getString("external_id");
						break;
					case "validateClientEncodedKey":
					case "validateClients":
						data[0] = rs.getString("encodedkey");
						data[1] = rs.getString("state");
						break;
					case "validateClientsUpdate":
						data[0] = rs.getString("id");
						data[1] = rs.getString("state");
						break;
					default:
						LOGGER.info("No se encontro la tabla");
				}
			}
		} catch (SQLException | NullPointerException e) {
			LOGGER.info(e.getMessage());
		}
		return data;
	}
}
