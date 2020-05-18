package pruebaBBDD;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class InsertaRegistroDatosPersonales {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Bienvenido al gestor la base de datos DatosPersonales");
		System.out.println("Introduciremos los siguientes datos DNI,NOMBRE, APELLIDO,EDAD");
		ComprobaDni mio = new ComprobaDni();
		if (mio.isDniok()==true) {
			System.out.println("el dni es correcto");
		}
		String dni= mio.getDni2();
		System.out.println("Introduce ahora el nombre");
		String nombre  = sc.nextLine();
		System.out.println("Introduce apellido");
		String apellido = sc.nextLine();
		System.out.println("Introduce edad");
		int edad= sc.nextInt();
		try {
			
			String connection =  "jdbc:mysql://localhost/javi?"+
					"user=root&password=";
					//"jdbc:mysql://localhost/javi user=root&password=";
			Connection con = DriverManager.getConnection(connection);
			Statement s= con.createStatement();
			s.executeUpdate("insert into datospersonales (DNI, Nombre, Apellido, Edad) values ("+dni +","+nombre.toString()+","
			+apellido.toString()+","+ edad+")");
			con.close();
			s.close();
			
			
		}catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
			
		}
		
	}

}
