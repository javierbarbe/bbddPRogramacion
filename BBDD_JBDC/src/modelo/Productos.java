package modelo;

public class Productos {

	private String n_articulo, seccion, pais_origen;
	private Double precio;

	// CONSTRUCTOR <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	public Productos() {
		n_articulo = "";
		seccion = "";
		pais_origen = "";
		precio = 0.0;
	} // <<<<<<<<<<<<<<<<<<<FIN CONSTRUCTOR -------------------------------------------

	// <<<<<<<<<<<<<<<<<<<<<<<< GETTERS Y SETTERS
	public String getN_articulo() {
		return n_articulo;
	}

	public void setN_articulo(String n_articulo) {
		this.n_articulo = n_articulo;
	}

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	public String getPais_origen() {
		return pais_origen;
	}

	public void setPais_origen(String pais_origen) {
		this.pais_origen = pais_origen;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	// <<<<<<<<<<<<<<<<<<<< FIN GETTERS Y seetters
	

}
