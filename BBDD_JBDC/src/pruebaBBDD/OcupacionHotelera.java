package pruebaBBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;

public class OcupacionHotelera {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("error por " +e.getCause());
		}
		
		
		String conexion = "jdbc:mysql://localhost/bd1?user=root&password=?useLegacyDatetimeCode=false&serverTimezone=UTC";
		try {
			Connection con = DriverManager.getConnection(conexion, "root", "");
			Statement s = con.createStatement();
			Statement d = con.createStatement();
			double cantVacias= 0, cantTotales=0;
			ResultSet r1 = s.executeQuery("select * from habitaciones");
			ResultSet rs = d.executeQuery("select precio from habitaciones where ocupada=0");
			while (r1.next()) {
				cantTotales++;
			}
			while (rs.next()) {
				cantVacias++;
				
			}/*
			*para formatear la salida de una division utiliza la clase DecimalFormat
			*y luego al objeto creaod, usar el metodo format(AQUI EL NUMERO DESEADO DE FORMATO)
			*/
			DecimalFormat formato= new DecimalFormat("#.00");
			System.out.println(cantTotales+" son todas las habitaciones del hotel");
			System.out.println(cantVacias+" son las habitaciones vacias ");
			double result = (cantVacias/cantTotales)*100 ;
			System.out.println("Por lo tanto, el porcentaje de ocupacion es "+ formato.format((cantVacias/cantTotales)*100)+"%");
			
		} catch (SQLException e) {
			System.out.println(e.getErrorCode()+ " codigo de error, problemas al conectar con la bd");
			System.out.println(e.getMessage());
		}
		
		
	}

}
