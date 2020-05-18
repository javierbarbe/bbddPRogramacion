package pruebaBBDD;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class InsertaRegistroDatosPersonales {

	public static void main(String[] args) {
		System.out.println("Bienvenido al gestor la base de datos DatosPersonales");
		System.out.println("Introduciremos los siguientes datos DNI,NOMBRE, APELLIDO,EDAD");
		ComprobaDni mio = new ComprobaDni();
		if (mio.isDniok()==true) {
			System.out.println("el dni es correcto");
		}
		
		try {
			
			String connection = "jdbc:mysql://localhost/javi user=root&password=";
			Connection con = DriverManager.getConnection(connection);
			
		}catch (Exception e) {
			
		}
		
	}

}
