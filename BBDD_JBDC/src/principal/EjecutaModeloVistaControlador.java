package principal;

import javax.swing.JFrame;

import vista.Marco_Aplicacion;

public class EjecutaModeloVistaControlador {

	public static void main(String[] args) {
	Marco_Aplicacion mimarco = new Marco_Aplicacion();
	mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	mimarco.setVisible(true);

	}

}
