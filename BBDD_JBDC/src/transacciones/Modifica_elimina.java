package transacciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Modifica_elimina {

	public static void main(String[] args) {
		Connection miConexion = null;
		try {

			miConexion = DriverManager.getConnection("jdbc:mysql://localhost/bd1", "root", "");

			// las convierto en bloque
			miConexion.setAutoCommit(false);

			Statement miStatement = miConexion.createStatement();
			

			String instruccionSql_1 = "DELETE FROM PRODUCTOS where PAIS_ORIGEN = 'alemania' ";

			String instruccionSql_2 = "DELETE FROM PRODUCTOS WHERE PRECIO > 600";

			String instruccionSql_3 = "UPDATE PRODUCTOS SET PRECIOs = PRECIO*2.15";
			boolean ejecutar = modificacion_pregunta();
			if (ejecutar) {

				miStatement.executeUpdate(instruccionSql_1);

				miStatement.executeUpdate(instruccionSql_2);

				miStatement.executeUpdate(instruccionSql_3);
				// commito los cambios en bloque
				System.out.println("comitando");
				miConexion.commit();
				System.out.println("postcomitado");
				System.out.println("Datos INSERTADOS correctamente");
			}else {
				System.out.println("No se han realizado cambios en la bbDD");
			}

		} catch (Exception e) {
			// AHORA HAY QUE DECIR QUE SI HA OCURRIDO ALGUN ERROR DURANTE LA TRANSACCION,
			// QUE
			// DEJE LA TABLA COMO ANTES DE NUESTRAS CONSULTAS CON ROLLBACK
		
				try {
					
					miConexion.rollback();
					System.out.println("marcha atras");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			System.out.println("ERROR EN LA INSERCIÓN DE DATOS!!");
			System.out.println(e.getMessage());
		//	e.printStackTrace();
		}

	}
	 static  boolean modificacion_pregunta() {
		String respuesta = JOptionPane.showInputDialog("Quieres realizar la modificacion?");
	
		respuesta="s";
		
		if (respuesta.equals("Si") || respuesta.equals("SI") || respuesta.equals("s")|| respuesta.equals("S")) {
			return true;
		}else {
			return false;
		}
	}

}
