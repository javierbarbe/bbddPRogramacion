package pruebaBBDD;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ComprobaDni {
	boolean dniok = false;

	protected boolean isDniok() {
		return dniok;
	}

	String dni2;

	public String getDni2() {
		return dni2;
	}

	public ComprobaDni() {

		String terminacion = "TRWAGMYFPDXBNJZSQVHLCKE";
		Scanner sc = new Scanner(System.in);

		System.out.println("INTRODUZCA DNI");
		while (!dniok) {

			Pattern dnipat = Pattern.compile("[0-9]{8}[A-Za-z]");
			String dni = sc.nextLine();
			Matcher dnimat = dnipat.matcher(dni);
			if (dnimat.matches()) {
				char letra = dni.charAt(dni.length() - 1);
				String letra3 = Character.toString(letra).toUpperCase();
				char letra2 = (letra3.charAt(0));
				String cortado = dni.substring(0, dni.length() - 1);
				int numero = Integer.valueOf(cortado);
				int posletra = numero % 23;
				char correspondiente = terminacion.charAt(posletra);
				if (correspondiente == letra) {
					dniok = true;
					dni2 = dni;
				} else if (correspondiente == letra2) {
					dniok = true;
					dni2 = dni;
				}

			} else {
				System.out.println("el dni no coincide con el patron");
				System.out.println("Vuelva a introducir el DNI");
			}
		}
	}

}
