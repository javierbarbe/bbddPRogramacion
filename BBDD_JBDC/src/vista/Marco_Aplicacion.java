package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

import javax.swing.*;

import controlador.*;


public class Marco_Aplicacion extends JFrame{
	
/// campos de clase 
	private String conexion = "jdbc:mysql://localhost/bd1?user=root&password?useLegacyDatetimeCode=false&serverTimezone=UTC";
	private Connection conecta;
	private HashSet<String> seccion;
	private HashSet<String> pais;
	private String filtroPais, filtroSeccion;
	private  JComboBox <String>secciones;
	private JComboBox <String >paises;
	private JTextArea resultado;
	private JButton botonConsulta;

	public void añadePais (String paisAñadir) {
		paises.addItem(paisAñadir);
	}
	public void añadeSeccion (String seccionAñadir) {
		secciones.addItem(seccionAñadir);
	}
	public JComboBox< String > getComboPaises(){
		return paises;
	}
	public JComboBox< String> getComboSecciones(){
		return secciones;
	}
	public void añadeTexto(String textoAñadir) {
		resultado.append(textoAñadir);
	}
	public String getMenuSeccionSeleccionado() {
		return getComboSecciones().getSelectedItem().toString();
	}
	public String getMenuPaisSeleccionado() {
		return getComboPaises().getSelectedItem().toString();
	}
	
	public JTextArea getResultado() {
		return resultado;
	}

	// constructor 
	public Marco_Aplicacion() {

		setTitle("Consulta BBDD");

		setBounds(500, 300, 400, 400);

		setLayout(new BorderLayout());

		JPanel menus = new JPanel();

		menus.setLayout(new FlowLayout());

		secciones = new JComboBox();

		secciones.setEditable(false);

		secciones.addItem("Todos");

		paises = new JComboBox();

		paises.setEditable(false);

		paises.addItem("Todos");

		resultado = new JTextArea(4, 50);

		resultado.setEditable(false);

		JPanel resultadoPanel = new JPanel();

		resultadoPanel.add(resultado);

		resultadoPanel.setAutoscrolls(true);

		JScrollPane barrascroll = new JScrollPane(resultadoPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	

		menus.add(secciones);

		menus.add(paises);

		add(menus, BorderLayout.NORTH);

		add(barrascroll, BorderLayout.CENTER);

		seccion = new HashSet<String>();
		pais = new HashSet<String>();


		botonConsulta = new JButton("Consulta");
		botonConsulta.addActionListener(new AccionBoton(this));
		add(botonConsulta, BorderLayout.SOUTH);
		// hay que ponerle a la escucha de eventos de ventana ( al cargar) 
		addWindowListener(new ControladorCargaMenus(this));
		
		System.out.println("arrancando");
}
	}
