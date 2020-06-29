package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import modelo.Conexion;
import modelo.EjecutaConsulta;
import vista.Marco_Aplicacion;

public class AccionBoton implements ActionListener{
	Marco_Aplicacion marco;
	public AccionBoton(Marco_Aplicacion marco) {
		this.marco=marco;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		EjecutaConsulta consulta1 = new EjecutaConsulta(marco);
		consulta1.ejecutaConsulta();
	}
		
	
}
