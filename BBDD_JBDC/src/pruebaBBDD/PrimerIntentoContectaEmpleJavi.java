package pruebaBBDD;

import java.sql.Array;
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
			s.executeUpdate("CREATE TABLE notas ( DNI varchar(10) NOT NULL, Sistemas int(11) NOT NULL, "+
		 " Programacion int(11) NOT NULL, LenguajeMarcas int(11) NOT NULL) ENGINE=InnoDB DEFAULT CHARSET=latin1");

//			s.executeUpdate("insert into emple(cod_emp,nombre,oficio, jefe, salario, cod_dep, fecha_alta) "
//					+ " values (11,'javi','bailarin',1,5000, 32, 12/12/1222) ");
		//	s.executeUpdate("delete from emple where nombre like 'javi'");
			ResultSet rs = s.executeQuery("select * from datospersonales");
			
			while (rs.next()) { 
				i=1;
				
			
						while (i<=4) {
					
							System.out.printf("%15s", rs.getString(i));
							System.out.println("\n"+rs.getDate(5));
							if(i==3) {
								if(rs.getString(i).equals("freak")) {
								System.out.println("\nle oficio es "+ rs.getString(i));
								System.out.println(rs.getDate(5));
								}
							}
							i++;
							
							
						};
						System.out.println();
						System.out.println();
			}
			// hay que cerrar tanto las consultas , como los resultados, como las conexiones a la bbdd para liberar
			//recursos
			rs.close();
			s.close();
			con.close();
			
		}catch (SQLException e) {
		System.out.println("sql exception "+ e.toString());
		System.out.println("codigo "+e.getErrorCode());
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		System.out.println("Excepcion "+e.toString());
		System.out.println("codigo "+e.getMessage());
	}
		
}
}
