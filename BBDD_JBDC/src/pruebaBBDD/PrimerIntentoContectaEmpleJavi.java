package pruebaBBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class PrimerIntentoContectaEmpleJavi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String connection= "jdbc:mysql://localhost/javi?"+"user=root&password=";
			Connection con= DriverManager.getConnection(connection);
			Object n;
			Statement s = con.createStatement();
			int i=1;
			s.executeUpdate("insert into emple(cod_emp,nombre,oficio, jefe, salario, cod_dep) "
					+ " values (9,'javi','bailarin',1,5000, 32) ");
			ResultSet rs = s.executeQuery("select * from emple");
			
			while (rs.next()) { 
				i=1;
				
						
						while (i<=8) {
							System.out.printf("%15s", rs.getString(i));
							if(i==3) {
								if(rs.getString(i).equals("freak")) {
								System.out.println("\nle oficio es "+ rs.getString(i));
								}
							}
							i++;
							
							
						};
						System.out.println();
						System.out.println();
			}
		}catch (SQLException e) {
		System.out.println("sql exception "+ e.toString());
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		System.out.println("Excepcion "+e.toString());
	}

}
}
