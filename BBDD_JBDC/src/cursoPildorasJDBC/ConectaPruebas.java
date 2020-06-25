package cursoPildorasJDBC;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class ConectaPruebas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("error al importar el driver de JDBC");
		}
		try {
			String conecta = "jdbc:mysql://localhost/bd1?user=root&password?useLegacyDatetimeCode=false&serverTimezone=UTC";
			Connection conexion  = DriverManager.getConnection(conecta, "root","");
			// CREAR UN STATEMENT SOBRE LA CONEXION 
			Statement consulta = conexion.createStatement();
			//3. EJECUTAR LA INSTRUCCION SQL, el resultado se almacena en un objeto ResultSet
			ResultSet resultadoConsulta = consulta.executeQuery("Select * from modelomotos");
			// LEER EL RESULTADO DE LA CONSULTA
			
			while (resultadoConsulta.next()) {
				System.out.println(resultadoConsulta.getString("modelo")+" "+ resultadoConsulta.getDouble("precioBase")*3
						+ " "+ resultadoConsulta.getDate("fecha")+3);
			}
			
			
		}catch (SQLException e) {
			System.out.println("errror al conectar con la bbdd");
			System.out.println(e.getMessage());
		}
		
	}

}
