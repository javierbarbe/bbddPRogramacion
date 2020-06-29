package cursoPildorasJDBC;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.HashSet;

public class Aplicacion_Consulta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame mimarco = new Marco_Aplicacion();

		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		mimarco.setVisible(true);

	}

}

class Marco_Aplicacion extends JFrame {
	int total = 0;

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

		// CONEXION CON BBDD
		try {
			
			 conecta = DriverManager.getConnection(conexion, "root", "");
			System.out.println("conectando a la bbdd");
			Statement mistatement = conecta.createStatement();
			String consulta = "select * from productos";
			ResultSet rs = mistatement.executeQuery(consulta);

			while (rs.next()) {

				seccion.add(rs.getString("SECCION"));
				pais.add(rs.getString("PAIS_ORIGEN"));
				System.out.println(rs.getString("NOMBRE_ARTICULO"));

			}

			for (String i : seccion) {
				secciones.addItem(i);
			}
			for (String i : pais) {
				paises.addItem(i);
			}
			conecta.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		JButton botonConsulta = new JButton("Consulta");

		botonConsulta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				resultado.setText("");

				int cantidad = 0;
				filtroSeccion = secciones.getSelectedItem().toString();
				filtroPais = paises.getSelectedItem().toString();
				//consulta = "select *  from productos where SECCION = '" + filtroSeccion + "' " + "AND PAIS_ORIGEN = '"
					//	+ filtroPais + "'";
				
				PreparedStatement misentencia = null;

				try {
					 conecta = DriverManager.getConnection(conexion, "root", "");

					if (!filtroPais.equals("Todos") && !filtroSeccion.equals("Todos")) {
						misentencia = conecta
								.prepareStatement("select * from  productos " + " where PAIS_ORIGEN=? and SECCION=? ");
						misentencia.setString(1, filtroPais);
						misentencia.setString(2, filtroSeccion);
					} else if (filtroSeccion.equals("Todos")) {
						misentencia = conecta.prepareStatement("select * from  productos " + " where PAIS_ORIGEN=? ");
						misentencia.setString(1, filtroPais);
					} else if (filtroPais.equals("Todos")) {
						misentencia = conecta.prepareStatement("select * from  productos " + " where SECCION=?  ");
						misentencia.setString(1, filtroSeccion);
					}
					if (filtroPais.equals("Todos") && filtroSeccion.equals("Todos")) {
						System.out.println("aqui marco selecciona * de productos");
						misentencia = conecta.prepareStatement("select * from productos");

					}

					ResultSet miresultado = misentencia.executeQuery();
					String nombre = "", section = "", fecha;
					double precio;
					while (miresultado.next()) {
						nombre = miresultado.getString("NOMBRE_ARTICULO");
						section = miresultado.getString("SECCION");
						fecha = miresultado.getString("fecha");
						precio = miresultado.getDouble("PRECIO");
						String pais = miresultado.getString("PAIS_ORIGEN");
						cantidad++;

						// fecha = fech.parse(new Date());
						if (resultado.getText().equals("No hay resultados")) {
							resultado.setText("");
						}

						resultado.append(nombre + " , " + section);
						resultado.append("  " + fecha + "  , " + pais + " ,  " + precio + " € \n");
					}
					resultado.append("----------------------------------------------------------------" + cantidad
							+ " ARTICULOS \n");
					if (cantidad == 0) {
						// if (nombre.isEmpty() || section.isEmpty()) {
						resultado.setText("No hay resultados");
						System.out.println("No hay resultados");
					}

				} catch (SQLException e1) {

					e1.printStackTrace();
				}

			}
		});
		
		add(botonConsulta, BorderLayout.SOUTH);

	}
	private String conexion = "jdbc:mysql://localhost/bd1?user=root&password?useLegacyDatetimeCode=false&serverTimezone=UTC";
	private Connection conecta;
	private HashSet<String> seccion;
	private HashSet<String> pais;
	private String filtroPais, filtroSeccion;
	private JComboBox secciones;

	private JComboBox paises;

	private JTextArea resultado;

}