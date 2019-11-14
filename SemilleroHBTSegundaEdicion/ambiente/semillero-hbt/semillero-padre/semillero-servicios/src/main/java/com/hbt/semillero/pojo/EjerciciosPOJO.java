/**
 * EjerciciosPOJO.java
 */
package com.hbt.semillero.pojo;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
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

	HashMap<String,Integer> partido = new HashMap<>();
	
	/**
	 * 
	 * Metodo encargado de agregar al ganador un set
	 * <b>Caso de Uso</b>
	 * @author acer
	 * 
	 * @param ganador
	 */
	public void agregarSetGanador (String ganador) {
		partido.put(ganador, partido.get(ganador)+ 1);
	}
	
	/**
	 * 
	 * Metodo encargado de agregar el juego
	 * <b>Caso de Uso</b>
	 * @author acer
	 * 
	 * @param jugador1
	 * @param val1
	 * @param jugador2
	 * @param val2
	 */
	public void agregarSet(String jugador1, int val1,String jugador2,int val2 ) {
		if(val1 > val2) {
			agregarSetGanador(jugador1);
		}else {
			agregarSetGanador(jugador2);
		}
	}
	/**
	 * 
	 * Metodo encargado de agregar los jugadores
	 * <b>Caso de Uso</b>
	 * @author acer
	 * 
	 * @param jug1
	 * @param jug2
	 */
	public void agregarJugadores(String jug1, String jug2) {
		partido.put(jug1,0);
		partido.put(jug2, 0);
	}
	
	/**
	 * 
	 * Metodo encargado de verificar al ganador
	 * <b>Caso de Uso</b>
	 * @author acer
	 * 
	 * @return
	 */
	public String verificarGanador() {
		int val = 0;
		String ganador = "Empate";
		for(String i : partido.keySet()) {
			if(val < partido.get(i)) {
				val = partido.get(i);
				ganador = i;
			}
		}
		return ganador;
	}
	
	
	
	/**
	 * 
	 * Metodo encargado de calcular el cambio
	 * <b>Caso de Uso</b>
	 * @author acer
	 * 
	 * @param cambio
	 * @return
	 */
	public static int[] cambio(int cambio) {
		int []  cambioFinal = new int [5];
		while(cambio > 0) {
			if(cambio > 1000) {
				cambioFinal[0]+=1;
				cambio-=1000;
			}else if(cambio > 500) {
				cambioFinal[1]+=1;
				cambio-=500;
			}else if(cambio > 200) {
				cambioFinal[2]+=1;
				cambio-=200;
			}else if(cambio > 100) {
				cambioFinal[3]+=1;
				cambio-=100;
			}else if(cambio > 50) {
				cambioFinal[4]+=1;
				cambio-=50;
			}
		}
		return cambioFinal;
	}
	
	/**
	 * 
	 * Metodo encargado del ejercicio 9 
	 * <b>Caso de Uso</b>
	 * @author acer
	 * 
	 * @throws Exception
	 */
	public void ejercicio9() throws Exception{
		throw new Exception();
	}
	
	/**
	 * 
	 * Metodo encargado de entregar el sig num
	 * <b>Caso de Uso</b>
	 * @author acer
	 * 
	 * @param num1
	 * @param num2
	 * @return
	 */
	public String siguiente(String num1,String num2) {
		int sum1=0,sum2 = 0,sum = 0;
		
		for(int i = 0;i < num1.length();i++) {
			sum1+=Integer.parseInt(num1.charAt(i)+"");
		}
		for(int i = 0;i < num2.length();i++) {
			sum2+=Integer.parseInt(num2.charAt(i)+"");
		}
		
		sum = sum2 + (sum2-sum1);
		return num(sum);
		
	}
	
	/**
	 * 
	 * Metodo encargado de retornar el num
	 * <b>Caso de Uso</b>
	 * @author acer
	 * 
	 * @param suma
	 * @return
	 */
	public String num(int suma) {
		if(suma < 10) {
			return suma + "";
		}
		int num1 = 1;
		int num2 = 1;
		while(num1 + num2 == suma) {
			if(num2 > 9) {
				num1++;
				num2 = 1;
			}
		}
		return "" + num1+num2;
	}
}
