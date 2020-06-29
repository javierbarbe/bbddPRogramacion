package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class CargaMenus {
	
	public CargaMenus () {
		miConexion = new Conexion();
	}
	
	public void ejecutaConsultas () {
		Productos miProducto = null;
		// utilizamos el objeto de tipo Conexion, y su metodo dameConexion para 
		// que nos devuelva un objeto tipo Connection a la bbdd que hemos configurado en la clase
		// Conexion
		 accesoBBDD = miConexion.dameConexion();
		// creamos la consulta 
		try {
			Statement secciones = accesoBBDD.createStatement();
			Statement paises = accesoBBDD.createStatement();
			rs = secciones.executeQuery("select distinctrow SECCION from productos");
			rs2 = paises.executeQuery("select distinctrow PAIS_ORIGEN from productos");
			
				// esto no tiene sentido
//				miProducto= new Productos();
//				miProducto.setPais_origen(rs2.getString(1));
//				miProducto.setSeccion(rs.getString(1));
				// fin del sinsentido
			

		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			System.out.println("error linea 40 - CARGA MENUS");
		}
	
		
	}
	
 // <<<<<<<<<< GETTERS Y SETTERS 
	 public ResultSet getRs() {
			return rs;
		}

		public ResultSet getRs2() {
			return rs2;
		}
		
		public Connection getConexion() {
			return accesoBBDD;
		}
// ---------------------------------
// <<<<<<<<<< CAMPOS DE CLASE
		private Connection accesoBBDD;
		Conexion miConexion ;
		 private ResultSet rs;
		 private ResultSet rs2;
	
}
