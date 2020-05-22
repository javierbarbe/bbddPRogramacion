package pruebaBBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JOptionPane;



public class ModificarRegistro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println(e1.getMessage());
		}
		Scanner sc = new Scanner(System.in);
		String hola = JOptionPane.showInputDialog("damelo papi");

		String conexion = "jdbc:mysql://localhost/bd1?user=root&password=?useLegacyDatetimeCode=false&serverTimezone=UTC";
		try {
			Connection con = DriverManager.getConnection(conexion, "root", "");
			Statement s = con.createStatement();

			System.out.println("introduce el nombre a buscar");
			String nombre = sc.nextLine();
			System.out.println("Introduce el apellido");
			String apellido = sc.nextLine();
			System.out.println("Introduce el nuevo nombre");
			String nombrenuevo = sc.nextLine();
			System.out.println("Introduce nuevo apellido");
			String apellidoNuevo = sc.nextLine();
			ComprobaDni mi = new ComprobaDni();
			String dni = mi.getDni2();
			System.out.println("introduce edad nueva");
			int edad = sc.nextInt();
			
			ResultSet rs = s.executeQuery(
					"select * from datospersonales  where nombre='" + nombre + "' and apellido='" + apellido + "'");
			while (rs.next()) {
				System.out.printf("%12s %12s %16s %12s", rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getInt(4));
				System.out.println();
			}
			s.executeUpdate("update datospersonales set nombre= '" + nombrenuevo + "'" + ",apellido='" + apellidoNuevo
					+ "', dni='" + dni + "', edad=" + edad + " where nombre='" + nombre + "' and apellido='" + apellido
					+ "'");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getErrorCode()+ " codigo de error");
			System.out.println(e.getMessage());
		}

	}
}