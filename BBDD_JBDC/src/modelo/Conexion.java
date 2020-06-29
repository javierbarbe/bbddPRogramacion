package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	public Conexion() {

	}

	public Connection dameConexion() {

		try {
			conecta = DriverManager.getConnection(conexion, "root", "");
		} catch (SQLException e) {
			System.out.println(e.getCause());
		}
		return conecta;
	}

	private Connection conecta= null;
	private final String conexion = "jdbc:mysql://localhost/bd1?user=root&password?useLegacyDatetimeCode"
			+ "=false&serverTimezone=UTC";
}
