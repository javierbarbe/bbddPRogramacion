package pruebaBBDD;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ComprobaDni {
	boolean dniok=false;
	protected boolean isDniok() {
		return dniok;
	}
	public ComprobaDni() {
		
		String terminacion="TRWAGMYFPDXBNJZSQVHLCKE";
		Scanner sc = new Scanner(System.in);
		
	
		System.out.println("INTRODUZCA DNI");
		while(!dniok) {
			
		Pattern dnipat= Pattern.compile("[0-9]{8}[A-Za-z]");
		String dni = sc.nextLine();
		Matcher dnimat= dnipat.matcher(dni);
		if (dnimat.matches()) {
			
			char letra=  dni.charAt(dni.length()-1);
			String letra3 = Character.toString(letra).toUpperCase();
			char letra2= (letra3.charAt(0));
//			System.out.println(letra);
			String cortado = dni.substring(0, dni.length()-1);
//			System.out.println(cortado);
			int numero= Integer.valueOf(cortado);
			int posletra= numero%23;
			char correspondiente= terminacion.charAt(posletra);
//			System.out.println(correspondiente);
			if (correspondiente==letra) {
				dniok=true;
//				System.out.println("todo correcto");
			}
			else if(correspondiente==letra2){
				dniok=true;
//				System.out.println("todo correcto");
			}
			
		}else {
			System.out.println("el dni no coincide con el patron");
		
//			sc.next();
			System.out.println("Vuelva a introducir el DNI");
//			 dni = sc.nextLine();
			
		}
	}
	}
	
	
}
