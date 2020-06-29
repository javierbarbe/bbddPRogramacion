package procAlmacenado;
import java.sql.*;
public class ConsultaPrueba {

	public static void main(String[] args) {
		
		try {
				Class.forName("com.mysql.jdbc.Driver");
				String conecta = "jdbc:mysql://localhost/bd1?user=root&password?useLegacyDatetimeCode=false&serverTimezone=UTC";
				Connection conexion  = DriverManager.getConnection(conecta, "root","");
				// UTILIZAMOS LA INTERFAZ CALLABLESTATEMENT PARA UTILIZAR UN PROCEDIMIENTO
				// ALMACENADO EN LA BBDD
				// EL PARAMETRO QUE RECIBE ES UNA INSTRUCCION CALL AL PROCEDIMIENTO ENTRE { } 
				// CON LA ESTRUCTURA "{call Nombre_procedimiento_almacenado }"
				CallableStatement miSentencia = conexion.prepareCall("{call prueba1}");
				// INTRODUCE EN UN RESULT SET  EL RESULTADO DE EJECUTAR ESA INSTRUCCION (USAR EL PROCEDURE)
				ResultSet rs = miSentencia.executeQuery();
				
				while (rs.next()) {
					System.out.println(rs.getString(1)+ " "+rs.getString(2)+ " "+ rs.getString(3));
				}
				rs.close();
				conexion.close();
			
		}catch (Exception e) {
			System.out.println(e.getCause());
		}
		

	}

}
