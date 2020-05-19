package pruebaBBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CrearTablaDatosEmplea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println(e1.getMessage());
		}
		try {
			
			String connection = "jdbc:mysql://localhost/javi?"+
								"user=root&password=";
		
			Connection con = DriverManager.getConnection(connection);
			Statement s= con.createStatement();
			s.executeUpdate("create table datospersonales (DNI varchar(10) not null, Nombre varchar(20) not null,  "
					+ "apellido varchar(20) not null,"
					+ "edad int not null)");
//			s.executeUpdate("INSERT INTO datospersonales (DNI, Nombre, Apellido, Edad) VALUEs " +
//"('002334189S', 'Pedro', 'Neruda Ripollés', 58), "+
//" ('02334739M', 'Manolo', 'González Ariza', 40), ('034333444R', 'Rosa', 'López Sanjuan', 23), "+
//" ('034489031T', 'Pepe Luis', 'Romero Ramos', 46),('233993333S', 'Marina', 'Castaño Carras', 60), "+
//" ('66332256N', 'Rosa', 'López Pérez', 32)");
			
		}catch( Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}

}
