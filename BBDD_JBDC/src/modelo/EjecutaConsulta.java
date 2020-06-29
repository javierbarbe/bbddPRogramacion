package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import vista.Marco_Aplicacion;

public class EjecutaConsulta {
	Marco_Aplicacion marco;

	public EjecutaConsulta (Marco_Aplicacion marco) {
		this.marco=marco;
	}
	
	public void ejecutaConsulta() {
		String query="";
		Conexion conexion = new Conexion();
		Connection accesobbdd2 = conexion.dameConexion();
		try {
			marco.getResultado().setText("");
			Statement statement1=accesobbdd2.createStatement();
			
			
			String paisElegido = marco.getMenuPaisSeleccionado();
			String seccionElegida = marco.getMenuSeccionSeleccionado();
			if (!paisElegido.equals("Todos") && !seccionElegida.equals("Todos")) {
				enviaConsulta = accesobbdd2.prepareStatement(consulta);
				enviaConsulta.setString(1, paisElegido);
				enviaConsulta.setString(2, seccionElegida);
				 query = "SELECT * FROM PRODUCTOS WHERE PAIS_ORIGEN = '"+ paisElegido +"' and SECCION = '"+seccionElegida + "'";
			} else if (seccionElegida.equals("Todos")) {
				enviaConsulta = accesobbdd2.prepareStatement(consultaSoloPais);
				enviaConsulta.setString(1, paisElegido);
				 query = " SELECT * FROM PRODUCTOS WHERE PAIS_ORIGEN = '"+ paisElegido +"' ";
				 
			}else if (paisElegido.equals("Todos")) {
				enviaConsulta = accesobbdd2.prepareStatement(consultaSoloSeccion);
				enviaConsulta.setString(1, seccionElegida);
				 query = " SELECT * FROM PRODUCTOS WHERE SECCION = '"+ seccionElegida +"' ";
				 
			} if (paisElegido.equals("Todos") && seccionElegida.equals("Todos")) {
				enviaConsulta = accesobbdd2.prepareStatement(consultaTotal);	
				query = " SELECT * FROM PRODUCTOS";
			}
			
			
			ResultSet rs1 = statement1.executeQuery(query);
			ResultSet rsPreparada = enviaConsulta.executeQuery();
			
			while (rs1.next()) {
				marco.añadeTexto(rs1.getString("NOMBRE_ARTICULO")+ "     "+rs1.getString("PAIS_ORIGEN")+
						" "+ rs1.getString("SECCION")+"\n");
				
			}
			marco.añadeTexto("--------------------------\n");
			while (rsPreparada.next()) {
				marco.añadeTexto(rsPreparada.getString("PRECIO")+ "     "+rsPreparada.getString("PAIS_ORIGEN")+
						" "+ rsPreparada.getString("SECCION")+"\n");
			}
			rsPreparada.close();
			rs1.close();
		}catch (SQLException e2) {
			System.out.println(e2.getCause());
		}
		
	
	}
	private String consulta ="SELECT * FROM PRODUCTOS WHERE PAIS_ORIGEN = ? and SECCION = ?";
	private String consultaTotal= "SELECT * FROM PRODUCTOS";
	private String consultaSoloPais ="SELECT * FROM PRODUCTOS WHERE PAIS_ORIGEN = ? ";
	private String consultaSoloSeccion ="SELECT * FROM PRODUCTOS WHERE  SECCION = ? ";
PreparedStatement enviaConsulta;
}
