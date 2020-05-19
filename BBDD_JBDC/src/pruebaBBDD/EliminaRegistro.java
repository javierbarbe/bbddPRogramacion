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
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println(e1.getMessage());
		}
		
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
				
			} catch (InputMismatchException e) {
				System.out.println("No es un numero lo introducido");
				System.out.println("Introduce un numero par favar");
				sc.next();
				opcion = sc.nextInt();
				System.out.println(e.getMessage());
			}
			}
		// PARA QUE PARE LA EJECUCION DEL PROGRAMA Y COJA LO INTRODUCIDO POR EL SCANNER
		// REQUIERE QUE DESPUES DE USARLO LO CIERRE (USAR EL METODO CLOSE) Y GENERAR 
		//UNA NUEVA INSTANCIA DEL OBJETO SCANNER
			Scanner es = new Scanner(System.in);
			
		switch (opcion) {
		
		case 1: System.out.println("has elegido DNI");
		
				System.out.println("Introduce el DNI a eliminar el registro");
				String variable= es.nextLine();
				 eliminar= variable;
				 campoAEliminar="Dni";
				break;
		case 2: System.out.println("has elegido nombre");
				System.out.println("Introduce el nombre a eliminar en el registro");
				
				eliminar=es.nextLine();
				campoAEliminar="Nombre";
			break;
		case 3: System.out.println("has elegido apellido");
				System.out.println("Introduce el apellido a eliminar en el registro");
				eliminar=es.nextLine();
				campoAEliminar="apellido";
			break;
		case 4: System.out.println("has elegido edad");
				System.out.println("Introduce la edad a eliminar en el registro");
				eliminar=es.nextLine();
				campoAEliminar="edad";
			break;
		
		}
		es.close();
		sc.close();

		try {

			// IMPORTANTE NO DEJAR ESPACIOS EN ESTE STRING !!!!!
		String conexion = "jdbc:mysql://localhost/javi?user=root&password=?useLegacyDatetimeCode=false&serverTimezone=UTC";
		Connection con = DriverManager.getConnection(conexion,"root","");
				
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select * from datospersonales");
		//	ResultSet rs3 = s.executeQuery("select * from datospersonales");
			while (rs.next()) {
				System.out.printf("%13s %22s %22s %13s", rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4) + " ");
				System.out.println();
			}
			System.out.println();
			// IMPORTANTE LA SINTAXIS SQL LOS STRING QUE VAN A LA DERECHA DEL IGUAL VAN ENTRE COMILLA SIMPLE!!
			ResultSet rs2 = s.executeQuery("select * from datospersonales where "+campoAEliminar+"='" +eliminar+"' ");
			while (rs2.next()) {
				contador++;
			}
			if (contador==0) {
				System.out.println("no habia resultados coincidentes con tu busqueda \n"+ campoAEliminar+": "+eliminar);
			}
			s.executeUpdate("delete from datospersonales where "+campoAEliminar+" = '"+eliminar+"'");
			System.out.println("Eliminadas " + contador + " tuplas");
//			while (rs3.next()) {
//				System.out.printf("%13s %22s %22s %13s", rs.getString(1), rs.getString(2), rs.getString(3),
//						rs.getString(4) + " ");
//			}

		} catch (SQLException e) {
			System.out.println("Excepcion ocurrida " + e.getCause());
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode()+" es el codigo de error");
		}

	//}
//	else {
//		System.out.println("campo eliminar en blanco");
//	}
	}
}


