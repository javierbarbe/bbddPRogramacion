package pruebaBBDD;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentaMotos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Class.forName("com.mysql.jdbc.Driver");
			MarcoMotos ma = new MarcoMotos();
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("error con el driver mysql");
		}
		
	}

}
