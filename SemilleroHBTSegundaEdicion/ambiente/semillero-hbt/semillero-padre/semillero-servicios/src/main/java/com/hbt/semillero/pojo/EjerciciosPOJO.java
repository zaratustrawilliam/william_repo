/**
 * EjerciciosPOJO.java
 */
package com.hbt.semillero.pojo;

import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedList;

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
	
	/**
	 * 
	 * Metodo encargado de validar que i fecha de nac mas mi edad es iagual a la fecha de hoy
	 * <b>Caso de Uso</b>
	 * @author acer
	 * 
	 * @return
	 */
	
	public static boolean miFecha() {
		
		LocalDate fech =  LocalDate.of(1998,5,18);
		fech.plusYears(21);
		return fech.equals(LocalDate.now());
	}
	
	LinkedList <Integer> list =  new LinkedList<Integer>();
	
	/**
	 * 
	 * Metodo encargado de llenar la lista
	 * <b>Caso de Uso</b>
	 * @author acer
	 * 
	 * @param num
	 */
	public void llenarLista(int num) {
		list.add(num);
	}
	
	/**
	 * 
	 * Metodo encargado de retornar los avlores
	 * <b>Caso de Uso</b>
	 * @author acer
	 * 
	 * @return
	 */
	public String datosMostrar() {
		
		Collections.sort(list);
		
		return ""+list.getFirst() + ","+list.getLast()+","+list.size();
	}

}
