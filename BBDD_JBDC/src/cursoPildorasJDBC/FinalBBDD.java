package cursoPildorasJDBC;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FinalBBDD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LectoraArchivoTxt arc = new LectoraArchivoTxt();
	}

}

class LectoraArchivoTxt {
	public LectoraArchivoTxt() {
		System.out.println("empiezo");
		try {
			int contador = 0;
		//	BufferedReader br2 = new BufferedReader(new FileReader("datos_configuracion.txt"));
			BufferedReader br =  new BufferedReader(new FileReader("ICMP.txt"));
			String linea = "a";
			String bbdd = "";
//			boolean bbddleida= false;
			String usuario = "";
//			boolean usuLeido= false;
			String contra = "";
//			boolean contraLeida= false;
			while (!linea.equals(null)) {
				linea = br.readLine();

				if (contador == 0) {
					contador++;
					bbdd = linea;

				} else if (contador == 1) {

					usuario = linea;
					contador++;
				} else {
					contador++;

					contra = linea;
				}
			}
			System.out.println(bbdd + usuario + contra);
		} catch (FileNotFoundException e) {
			System.out.println("error al leer el archivo");
			System.out.println(e.getLocalizedMessage());
			System.out.println(e.getCause());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}