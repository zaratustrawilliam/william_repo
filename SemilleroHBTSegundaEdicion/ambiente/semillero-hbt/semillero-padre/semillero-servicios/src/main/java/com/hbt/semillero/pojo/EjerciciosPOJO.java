/**
 * EjerciciosPOJO.java
 */
package com.hbt.semillero.pojo;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author acer
 * @version 
 */
public class EjerciciosPOJO {
	
	private static String brand;

	private static boolean empty;

	public static void ejercicioIni() {

	System.out.print("Empty = " + empty);

	System.out.print(", Brand = " + brand);

	} 
	
	/**
	 * 
	 * Metodo encargado de pribar que un numero es primo
	 * <b>Caso de Uso</b>
	 * @author acer
	 * 
	 * @param numero
	 * @return
	 */
	public static boolean esPrimo(int numero) {
		int contador = 0;
		if(numero == 0 || numero == 1 || numero == 2) {
			return true;
		}
		for(int i = 1; i < numero /2 ; i ++) {
			if(numero % i == 0 ) {
				contador++;
			}
		}
		return contador <= 2;
	}
	

}
