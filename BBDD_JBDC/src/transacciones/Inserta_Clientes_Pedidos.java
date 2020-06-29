package transacciones;

import java.sql.*;

public class Inserta_Clientes_Pedidos {

	public static void main(String[] args) {
		
		// PARA QUE EL PROGRAMA JAVA ENTIENDA TODAS LAS QUERYS COMO UN BLOQUE Y NO COMO
		// CONSULTAS INDIVIDUALES , (LO CUAL GENERA QUE SI HAY FALLOS EN ALGUNA DE LAS QUERYS, 
		// SE CONSULTEN LAS DEMAS, DEJANDO LA TABLA SIN COHERENCIA ) 
		/*
		 * LO QUE HAY QUE HACER ES AL OBJETO DE TIPO CONEXION , USAR SU METODO AUTOCOMMIT Y PASARLE FALSE
		 * COMO PARAMETRO miConexion.autoCommit(false)
		 * TRAS TODAS LAS TRANSACCIONES, SE COMMITA EL OBJETO CONNECTION 
		 */
		Connection miConexion= null;
		try{					
				
			miConexion= DriverManager.getConnection("jdbc:mysql://localhost/bd1", "root", "");
			
			// las convierto en bloque 
			miConexion.setAutoCommit(false);
			
			Statement miStatement =miConexion.createStatement();
			
		    String instruccionSql_1="INSERT INTO CLIENTES (CÓDIGOCLIENTE, EMPRESA, DIRECCIÓN) VALUES ('CT84', 'EJEMPLO', 'P BOTANICO')";
			    
		    miStatement.executeUpdate(instruccionSql_1);
			    
		    String instruccionSql_2="INSERT INTO PEDIDOS (NÚMERODEPEDIDO, CÓDIGOCLIENTE,FECHADEPEDIDO) VALUES('82', 'CT84', '11/03/2000')";
			    
		    miStatement.executeUpdate(instruccionSql_2);
		    
		    // commito los cambios en bloque
		    miConexion.commit();
		    				    
		    System.out.println("Datos INSERTADOS correctamente");
				
		}catch(Exception e){
				// AHORA HAY QUE DECIR QUE SI HA OCURRIDO ALGUN ERROR DURANTE LA TRANSACCION, QUE 
			// DEJE LA TABLA COMO ANTES DE NUESTRAS CONSULTAS CON ROLLBACK
			try {
				miConexion.rollback();
			} catch (SQLException e1) {
				System.out.println("Error al hacer rollback");
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}
			System.out.println("ERROR EN LA INSERCIÓN DE DATOS!!");
				
			
			e.printStackTrace();	
				
				
			}

		}

	}

