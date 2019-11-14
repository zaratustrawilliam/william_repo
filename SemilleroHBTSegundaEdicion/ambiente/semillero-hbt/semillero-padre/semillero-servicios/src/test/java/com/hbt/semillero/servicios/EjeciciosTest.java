/**
 * EjeciciosTest.java
 */
package com.hbt.semillero.servicios;

import org.testng.annotations.Test;

import com.hbt.semillero.pojo.EjerciciosPOJO;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author acer
 * @version 
 */
public class EjeciciosTest {
	
	@Test
	public void testUnitary() {
		
		/**
		 * A$B
		 * es valido para nombrar una variable dado que cumple con empesar con caracteres
		 */
		
		/**
		 * _helloWorld
		 * es valido dado que inicia con caracteres especiales
		 */
		
		/**
		 * true
		 * Es el valor correspondiente a una variable booleana, no es un identificador
		 */
		
		/**
		 * java.lang
		 * no es  valido en cuanto a que vamos a importar librerias
		 */
		
		/**
		 * Public
		 * no es valido, ni tampoco es una palabra reservada
		 * 
		 */
		
		/**
		 * 1980_s
		 * no es valido ya que empieza con numero
		 */
	}
	
	/**
	 * NO SE DEBEN LLAMAR ATRIBUTOS DE CLASE DENTRO DE UN METODO ESTATICO, POR LO TANTO VOLVI LOS ATRIBUTOS ESTATICS
	 */
	@Test
	public void ejercicio2TEST() {
		EjerciciosPOJO.ejercicioIni();
	}
	

}
