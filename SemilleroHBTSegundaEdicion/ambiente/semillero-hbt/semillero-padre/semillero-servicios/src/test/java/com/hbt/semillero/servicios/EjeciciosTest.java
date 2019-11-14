/**
 * EjeciciosTest.java
 */
package com.hbt.semillero.servicios;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hbt.semillero.pojo.EjerciciosPOJO;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author acer
 * @version 
 */
public class EjeciciosTest {
	
	@Test(enabled = false)
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
	@Test(enabled = false)
	public void ejercicio2TEST() {
		EjerciciosPOJO.ejercicioIni();
	}
	
	/**
	 * Prueba ejercicio 3 primos
	 */
	@Test(enabled = false)
	public void pruebaEjercicio3() {
		
		int num = 0;
		Assert.assertEquals(EjerciciosPOJO.esPrimo(num),true);
		
		num = 222;
		Assert.assertEquals(EjerciciosPOJO.esPrimo(num),false);
		
		num = 15;
		Assert.assertEquals(EjerciciosPOJO.esPrimo(num),false);
	}
	/**
	 * 
	 * Metodo encargado de probar el ejercicio4
	 * <b>Caso de Uso</b>
	 * @author acer
	 *
	 */
	@Test(enabled = false)
	public void pruebaEhercicicio4() {
		Assert.assertEquals(EjerciciosPOJO.miFecha(),false);
	}
	
	/**
	 * 
	 * Metodo encargado de probar el ejerciico5
	 * <b>Caso de Uso</b>
	 * @author acer
	 *
	 */
	@Test(enabled = false)
	public void pruebaEjercicio5() {
		EjerciciosPOJO p = new EjerciciosPOJO();
		p.llenarLista(-2);
		p.llenarLista(50);
		p.llenarLista(1);
		p.llenarLista(249);
		Assert.assertEquals(p.datosMostrar(),"-2,249,4");
	}
	/**
	 * 
	 * Metodo encargado de probar ejercicio 7
	 * <b>Caso de Uso</b>
	 * @author acer
	 *
	 */
	@Test(enabled = false)
	public void pruebaEjercicio7() {
		EjerciciosPOJO p = new EjerciciosPOJO();
		p.agregarJugadores("federer", "thiem");
		p.agregarSet("federer", 3,"thiem", 6);
		p.agregarSet("federer", 2,"thiem", 6);
		Assert.assertEquals(p.verificarGanador(),"thiem");
	}
	
	/**
	 * 
	 * Metodo encargado de probar el ejercicio 8
	 * <b>Caso de Uso</b>
	 * @author acer
	 *
	 */
	@Test(enabled = false)
	public void pruebaEjercicio8() {
		int [] esperado = {5,1,0,0,1};
		Assert.assertEquals(EjerciciosPOJO.cambio(5550),esperado);
		
		int [] esperado2 = {1,0,0,0,0};
		Assert.assertEquals(EjerciciosPOJO.cambio(1000),esperado2);
	}
	
	/**
	 * 
	 * Metodo encargado de probar el ejercicio 11
	 * <b>Caso de Uso</b>
	 * @author acer
	 *
	 */
	@Test
	public void pruebaEjercicio11() {
		EjerciciosPOJO p = new EjerciciosPOJO();
		Assert.assertEquals(p.siguiente("80","36"),46);
		
	}
	

}
