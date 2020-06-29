package controlador;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.CargaMenus;
import vista.Marco_Aplicacion;

public class ControladorCargaMenus extends WindowAdapter{
 
	 public ControladorCargaMenus (Marco_Aplicacion mimarco) {
		 this.mimarco= mimarco;
	}
	
//	tiene que manejar el evento al abrir
	@Override
	public void windowOpened(WindowEvent e) {
		
		// tiene que ejecutar la consulta bdd
		// la clase cargaSecciones tiene un metodo que realiza consultas a la bbdd
		// y que ademas   carga dentro de su campo de clase RS y RS2
		/// el resultado de la consulta
	obj.ejecutaConsultas();
				
		try {
			// hay que reiniciar el resutset iterador ... para que coja el primero en caso de haber recorrido ya 
			// el resultSet
//			res.beforeFirst();
			while (obj.getRs().next()) {
				// aqui hay que añadir dentro de los comboBox del objeto MarcoAplicacion
				mimarco.añadeSeccion(obj.getRs().getString(1));
				//mimarco.añadeTexto(obj.rs.getString(1)+"\n");;
			}
			while (obj.getRs2().next()) {
				mimarco.añadePais(obj.getRs2().getString(1));
			}
			obj.getRs().close();
			obj.getRs2().close();
			obj.getConexion().close();
		} catch (SQLException e1) {
			
			e1.printStackTrace();
			System.out.println("error linea 34 COntroladorCargaSecciones");
		}
		
	}
	public String getMenuSeccionSeleccionado() {
		return mimarco.getComboSecciones().getSelectedItem().toString();
	}
	public String getMenuPaisSeleccionado() {
		return mimarco.getComboPaises().getSelectedItem().toString();
	}
	
	CargaMenus obj = new CargaMenus();
	Marco_Aplicacion mimarco;
	public CargaMenus getObj() {
		return obj;
	}

	public void setObj(CargaMenus obj) {
		this.obj = obj;
	}

	public Marco_Aplicacion getMimarco() {
		return mimarco;
	}

	public void setMimarco(Marco_Aplicacion mimarco) {
		this.mimarco = mimarco;
	}
}
