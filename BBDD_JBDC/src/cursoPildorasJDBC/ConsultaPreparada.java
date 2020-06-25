package cursoPildorasJDBC;

import java.sql.*;



public class ConsultaPreparada {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String conecta = "jdbc:mysql://localhost/bd1?user=root&password?useLegacyDatetimeCode=false&serverTimezone=UTC";
		try {
			//1. CREAR LA CONEXION
			Connection conexion  = DriverManager.getConnection(conecta, "root","");
			// 2. PREPARAR LA CONSULTA
			PreparedStatement misentencia = conexion.prepareStatement("select modelo, precioBase, fecha from  modelomotos"
					+ " where modelo=? and precioBase>? ");
			// 3. PASO ESTABLECER LOS PARAMETROS DE CONSULTA (?)
			misentencia.setString(1, "Chopper");
			//  EL PRIMER PARAMETRO DE ESTE METODO SETSTRING HACE REFERENCIA AL PRIMER PARAMETRO DE LA SENTECNIA
			// PREPARED STATMENT QUE TENGA COMO VALOR UN '?' 
			misentencia.setInt(2, 200 );
			
			// 4. EEJCUTAR Y RECORRER LA CONSULTA
			ResultSet miresultado = misentencia.executeQuery(); // ya esta almacenada no requiere que se la escriba
			
			while (miresultado.next()) {
				System.out.println(miresultado.getString("modelo")+ " "+ miresultado.getInt("precioBase")+ " "+
						miresultado.getDate("fecha"));
			}
			miresultado.close();
			
			
			// 5. REUTILIZACION DE CONSULTA
			System.out.println();
			System.out.println("EJECUCION SEGUNDA CONSULTA");
			System.out.println();
			misentencia.setString(1, "Angel Fury");
			//  EL PRIMER PARAMETRO DE ESTE METODO SETSTRING HACE REFERENCIA AL PRIMER PARAMETRO DE LA SENTECNIA
			// PREPARED STATMENT QUE TENGA COMO VALOR UN '?' 
			misentencia.setInt(2, 2000 );
			
			// 4. EEJCUTAR Y RECORRER LA CONSULTA
			 miresultado = misentencia.executeQuery(); // ya esta almacenada no requiere que se la escriba
			
			while (miresultado.next()) {
				System.out.println(miresultado.getString("modelo")+ " "+ miresultado.getInt("precioBase")+ " "+
						miresultado.getDate("fecha"));
			}
			miresultado.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
