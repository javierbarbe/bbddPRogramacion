package pruebaBBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;



public class EliminaRegistro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean opc = false;
		int opcion=0;
		int contador=0;
		String eliminar="";
		String campoAEliminar="";
		Scanner sc = new Scanner(System.in);
		System.out.println("Elige el filtro por el cual quieres eliminar un registro");
		System.out.println("1. DNI\n2.Nombre\n3.Apellido\n4.Edad");
		while (!opc) {
			try {

				opcion = sc.nextInt();
				opc = true;
				
				switch (opcion) {
				
				case 1: System.out.println("has elegido DNI");
				
						System.out.println("Introduce el DNI a eliminar el registro");
						String variable= sc.nextLine();
						 eliminar= variable;
						 campoAEliminar="Dni";
						break;
				case 2: System.out.println("has elegido nombre");
						System.out.println("Introduce el nombre a eliminar en el registro");
						
						eliminar=sc.nextLine();
						campoAEliminar="Nombre";
					break;
				case 3: System.out.println("has elegido apellido");
						System.out.println("Introduce el apellido a eliminar en el registro");
						eliminar=sc.nextLine();
						campoAEliminar="apellido";
					break;
				case 4: System.out.println("has elegido edad");
						System.out.println("Introduce la edad a eliminar en el registro");
						eliminar=sc.nextLine();
						campoAEliminar="edad";
					break;
				
				}
				System.out.println();
			
			} catch (InputMismatchException e) {
				System.out.println("No es un numero lo introducido");
				System.out.println("Introduce un numero par favar");
				sc.next();
				opcion = sc.nextInt();
				System.out.println(e.getMessage());
			}
			}
			
	
	
	if (!eliminar.isBlank()) {	
		try {

			// IMPORTANTE NO DEJAR ESPACIOS EN ESTE STRING !!!!!
		String conexion = "jdbc:mysql://localhost/javi?user=root&password=";
		Connection con = DriverManager.getConnection(conexion);
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select * from datospersonales");
		
			while (rs.next()) {
				System.out.printf("%13s %22s %22s %13s", rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4) + " ");
				System.out.println();
			}
			System.out.println();
			ResultSet rs2 = s.executeQuery("select * from datospersonales where " + campoAEliminar + " = " + eliminar);
			while (rs2.next()) {
				contador++;
			}
			s.executeUpdate("delete from datospersonales where nombre ='javi'");
			System.out.println("Eliminadas " + contador + " tuplas");
			while (rs.previous()) {
				System.out.printf("%13s %22s %22s %13s", rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4) + " ");
			}

		} catch (SQLException e) {
			System.out.println("Excepcion ocurrida " + e.getCause());
			System.out.println(e.getMessage());
		}

	}else {
		System.out.println("campo eliminar en blanco");
	}
	}
}


