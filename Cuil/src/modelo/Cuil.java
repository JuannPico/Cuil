package modelo;

import java.util.Scanner;

public class Cuil {

	public static void main(String[] args) {
		menu();

	}
	
//	este metodo recibe por parametro un dni y un sexo, y retorna el cuil verdadero
	public static String calcularCuil(long dni, char sexo) {
		String porDefecto = "5432765432";
		String cuilValido = "";
		int xy = 0;
		int multiplicacion = 0;
		int resto = 0;
		int z;
		//		dependiendo si el sexo es femenino o masculino, la variable xy obtiene un valor
		if(sexo == 'M' || sexo == 'm')
			xy = 20;
		else if(sexo == 'F' || sexo == 'f')
			xy = 27;
		//		la variable cuilValido va a ir obteniendo progresivamente los valores que deberia tener el cuil originalmente
		cuilValido = String.valueOf(xy);
		cuilValido = cuilValido + dni;

		//			multiplicamos cada uno de los numeros que tenemos por cada uo de los numeros por defecto
		for(int i = 0; i < cuilValido.length(); i++) {
			multiplicacion += Character.getNumericValue(cuilValido.charAt(i)) * Character.getNumericValue(porDefecto.charAt(i));
		}


		resto = multiplicacion % 11;
		z = -1;

		if(resto == 0) {
			z = 0;
			cuilValido = cuilValido + z;
		}
		else if(resto == 1) {
			xy = 23;
			if(sexo == 'M' || sexo == 'm') {
				z = 9;
			}
			else if(sexo == 'F' || sexo == 'f') {
				z = 4;
			}
			cuilValido = String.valueOf(xy) + String.valueOf(dni) + String.valueOf(z);
		}
		else {
			z = 11 - resto;
			cuilValido = cuilValido + z;
		}

		return cuilValido;
	}

	public static void menu() {
		Scanner scan = new Scanner(System.in);
		int opcion;
		do {
			long dni;
			char sexo;
			System.out.println("SISTEMA DE CALCULO DE CUIL\n");
			System.out.println("\n 1 - Calcular cuil\n 0 - salir del sistema\n");
			System.out.println("\n Ingrese opcion \n");
			opcion = scan.nextInt();
			switch (opcion) {
			case 1:

				System.out.println("\n    ingrese su numero de dni\n");

				do {
					dni = scan.nextLong();
					if(String.valueOf(dni).length() < 7 || String.valueOf(dni).length() > 8) {
						System.out.println("Error: dni invalido, vuelva a ingresar su dni\n");
					}      
				}while(String.valueOf(dni).length() < 7 || String.valueOf(dni).length() > 8);

				System.out.println("\n    ingrese su sexo, 'f' si es femenino o 'm' si es masculino\n");

				do {
					sexo = scan.next().charAt(0);
					if(sexo != 'm' && sexo != 'M'&& sexo != 'f' && sexo != 'F') {
						System.out.println("Error: sexo invalido, vuelva a ingresar su sexo\n");
					}
				}while(sexo != 'm' && sexo != 'M'&& sexo != 'f' && sexo != 'F');
				System.out.println("--- SU NUMERO DE CUIL ES "+ calcularCuil(dni, sexo));
				System.out.println("\n -------------------------\n");
				break;
			case 0 : System.out.println("\nSaliste del sistema\n");
			break;
			default : System.out.println("\nopcion incorrecta");
			break;
			}
		}while(opcion != 0);

	}


	
	
	
	
	
	
	
	
	
	
	
}
