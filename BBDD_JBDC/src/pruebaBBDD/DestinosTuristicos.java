package pruebaBBDD;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class DestinosTuristicos {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub

		Class.forName("com.mysql.jdbc.Driver");
		MarcoTurismo marco = new MarcoTurismo();
		
	

	}

}

class menudos extends JMenu {
	public menudos(String nombre) {
		super.setText(nombre);
	}

	public String toString() {
		return super.getText();

	}
}
class MarcoTurismo extends JFrame {
	public MarcoTurismo() {
		setVisible(true);
		setBounds(400, 400, 250, 180);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		PanelTurismo pan = new PanelTurismo();
		add(pan);
	}

private	class PanelTurismo extends JPanel {
		ArrayList<String> des = new ArrayList<>();
		ArrayList<String> cod = new ArrayList<>();
		HashMap<String, Double> precios = new HashMap<>();
		JMenuBar barra = new JMenuBar();
		menudos paises = new menudos("Paises");
		menudos destinos = new menudos("Destinos");
		ArrayList<String> arrayPaises = new ArrayList<>();
		JLabel central = new JLabel();
		String conexion = "jdbc:mysql://localhost/bd1?user=root&password=?useLegacyDatetimeCode=false&serverTimezone=UTC";

	private	class oyenteprecios implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				Connection con;
				Statement st = null;
				try {
					con = DriverManager.getConnection(conexion, "root", "");
					st = con.createStatement();

				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

				int a = 0;
				while (a < des.size()) {
					if (e.getSource().equals(destinos.getItem(a))) {
						// System.out.println(precios.get("ola"));
						System.out.println("coincide");
						central.setText(Double.toString(precios.get(cod.get(a))));
						System.out.println(precios.get(cod.get(a)));
					}
					a++;
				}
			}

		}

		public PanelTurismo() {
//				 String conexion = "jdbc:mysql://localhost/bd1?user=root&password=?useLegacyDatetimeCode=false&serverTimezone=UTC";
			Connection con;
			oyenteDestinos oy = new oyenteDestinos();
			Statement st = null;

			try {
				con = DriverManager.getConnection(conexion, "root", "");
				st = con.createStatement();
				ResultSet distintospaises = st.executeQuery("select distinct pais from destinoturistico");
				while (distintospaises.next()) {
					arrayPaises.add(distintospaises.getString(1));
				}
				for (String r : arrayPaises) {
					System.out.println(r);
					JMenuItem $r = new JMenuItem(r);
					$r.addActionListener(oy);
					paises.add($r);
				}
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}

			barra.add(paises);
			destinos.setVisible(false);
			barra.add(destinos);
			add(barra);
			add(central);

		}

	private class oyenteDestinos implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				destinos.setVisible(true);
				destinos.removeAll();
				cod.clear();
				des.clear();
				precios.clear();
				central.setText("");
				System.out.println(e.getSource());
//					 String conexion = "jdbc:mysql://localhost/bd1?user=root&password=?useLegacyDatetimeCode=false&serverTimezone=UTC";
				Connection con;
				Statement st = null;
				try {
					con = DriverManager.getConnection(conexion, "root", "");
					st = con.createStatement();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				oyenteprecios ko = new oyenteprecios();
				// intento de hacerlo metodo una sola vez
				int canti = paises.getItemCount();
				for (int pa = 0; pa < canti; pa++) {
					if (e.getSource() == paises.getItem(pa)) {

						try {
							ResultSet r1 = st.executeQuery(
									"select * from destinoturistico where pais='" + arrayPaises.get(pa) + "'");
							while (r1.next()) {
								des.add(r1.getString(2));
								cod.add(r1.getString(1));
								System.out.println(r1.getString(2));
								precios.put(r1.getString(1), Double.valueOf((r1.getString(4))));
							}
							for (int i = 0; i < des.size(); i++) {
								JMenuItem $i = new JMenuItem(des.get(i));
								destinos.add($i);
								$i.addActionListener(ko);
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}

				}
				// fin de intento de hacerlo metodo
//					if(e.getSource() ==  paises.getItem(0)) {
//						
//						
//						System.out.println(des.size());
//						
//						try {
//							ResultSet r1 = st.executeQuery("select * from destinoturistico where pais='España'");
//							while (r1.next()) {
//								des.add(r1.getString(2));
//								cod.add(r1.getString(1));
//								System.out.println(r1.getString(2));
//								precios.put(r1.getString(1), Double.valueOf((r1.getString(4))));
//							}
//							for (int i=0; i< des.size(); i++) {
//								JMenuItem $i = new JMenuItem(des.get(i));
//								destinos.add($i);
//								$i.addActionListener(ko);
//							}
//						} catch (SQLException e1) {
//							// TODO Auto-generated catch block
//							e1.printStackTrace();
//						}
//					}
//					else if (e.getSource() == paises.getItem(1)) {
//						des.clear();
//						try {
//							ResultSet r2 = st.executeQuery("select * from destinoturistico where pais='Italia'");
//							while (r2.next()) {
//								des.add(r2.getString(2));
//								cod.add(r2.getString(1));
//								precios.put(r2.getString(1), Double.valueOf((r2.getString(4))));
//							//	System.out.println(r2.getString(2));
//							}
//							for (int i=0; i< des.size(); i++) {
//								JMenuItem $i = new JMenuItem(des.get(i));
//								destinos.add($i);
//								$i.addActionListener(ko);
//							}
//						} catch (SQLException e1) {
//							// TODO Auto-generated catch block
//							e1.printStackTrace();
//						}
//					}else {
//						try {
//							System.out.println(arrayPaises.get(2));
//							des.clear();
//							ResultSet r3 = st.executeQuery("select * from destinoturistico where pais='Marruecos'");
//							while (r3.next()) {
//								des.add(r3.getString(2));
//								cod.add(r3.getString(1));
//								precios.put(r3.getString(1), Double.valueOf((r3.getString(4))));
//							//	System.out.println(r3.getString(2));
//							}
//							for (int i=0; i< des.size(); i++) {
//								JMenuItem $i = new JMenuItem(des.get(i));
//								destinos.add($i);
//								$i.addActionListener(ko);
//							}
//						} catch (SQLException e1) {
//							// TODO Auto-generated catch block
//							e1.printStackTrace();
//						}
//					}

			}

		}
	}
}
