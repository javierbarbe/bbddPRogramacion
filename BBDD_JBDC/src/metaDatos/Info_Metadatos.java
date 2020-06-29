package metaDatos;

import java.sql.*;

public class Info_Metadatos {
	static ResultSet rs;
	static Connection miConexion;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//getInfoBBDD();
		mostrarInfoTabla();

	}

	static void getInfoBBDD() {
		miConexion = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Error con el driver de jdbc");
		}
		String conecta = "jdbc:mysql://localhost/bd1?user=root&password?useLegacyDatetimeCode=false&serverTimezone=UTC";
		try {
			miConexion = DriverManager.getConnection(conecta, "root", "");
			DatabaseMetaData metadatos = miConexion.getMetaData();
			// mostrar info de la ddbb
			System.out.println(metadatos.getDatabaseProductName() + " es el nombre del gestor de BBDD");
			System.out.println(metadatos.getDatabaseProductVersion() + " version del producto");
			System.out.println(metadatos.getDriverName() + " nombre del driver");
			System.out.println(metadatos.getDriverVersion() + " version del driver");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al conectar a la BBDD");
		} finally {
			try {
				miConexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	static void mostrarInfoTabla() {

		Connection miConexion = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Error con el driver de jdbc");
		}
		String conecta = "jdbc:mysql://localhost/bd1?user=root&password?useLegacyDatetimeCode=false&serverTimezone=UTC";
		try {
			miConexion = DriverManager.getConnection(conecta, "root", "");
			DatabaseMetaData metadatos = miConexion.getMetaData();
			// lista de TABLAS 
			System.out.println(" -- Lista de tablas --");
			// aqui funciona perfectamente patrones( de hecho creo que es lo que usa pero patrones d SQL) 
			rs= metadatos.getTables(null, null,  "%p%", null);
			while (rs.next()) {
				System.out.println(rs.getString("TABLE_NAME"));
			}
			// CON GETCOLUMNS NOS DA EL NOMBRE DE LAS COLUMNAS DE LA TABLA ESPECIFICADA 
			System.out.println(" Lista de columnas de datospersonales");
			rs= metadatos.getColumns(null, null, "datospersonales", null);
			 while (rs.next()) {
				 System.out.println(rs.getString("column_name"));
			 }
			
		} catch (Exception e) {

		} finally {
			try {
				miConexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
