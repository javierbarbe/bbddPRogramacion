package procAlmacenado;

import java.sql.*;

import javax.swing.JOptionPane;

import com.mysql.jdbc.UpdatableResultSet;

public class Actualiza_productos {

	public static void main(String[] args) {

		double n_precio = Double.parseDouble(JOptionPane.showInputDialog("Introduce precio"));
		String n_articulo = JOptionPane.showInputDialog("Introduce nombre articulo");

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String conecta = "jdbc:mysql://localhost/bd1?user=root&password?useLegacyDatetimeCode=false&serverTimezone=UTC";
			Connection conexion = DriverManager.getConnection(conecta, "root", "");
			// UTILIZAMOS LA INTERFAZ CALLABLESTATEMENT PARA UTILIZAR UN PROCEDIMIENTO
			// ALMACENADO EN LA BBDD
			// EL PARAMETRO QUE RECIBE ES UNA INSTRUCCION CALL AL PROCEDIMIENTO ENTRE { }
			// CON LA ESTRUCTURA "{call Nombre_procedimiento_almacenado }"
			// ESTE PROCEDIDIMIENTO RECIBE DOS PARAMETROS
			// SE INDICA MEDIANTE PARENTESIS Y DOS ? ? PARA CAADA PARAMETRO
			CallableStatement miSentencia = conexion.prepareCall("{call ACTUALIZA_PROD(?,?)}");

			// AHORA SE PASAN LOS PARAMETRSO COMO SI FUERA UNA PREPAREDSTATEMENT
			miSentencia.setDouble(1, n_precio);
			miSentencia.setString(2, n_articulo);
			// EL ORDEN ES IMPORTANTE, (EL TIPO ) TIENE QUE SER IGUAL AL DEL PROCEDURE, SINO DARÁ ERROR

			// SOLO QUEDA EJECUTAR
			miSentencia.execute();
			System.out.println("ACTUALIZACION OK");

		} catch (Exception e) {

		}
	}

}
