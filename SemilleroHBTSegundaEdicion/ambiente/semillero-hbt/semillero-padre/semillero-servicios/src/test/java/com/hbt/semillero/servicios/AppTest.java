package com.hbt.semillero.servicios;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.entidades.Comic;
import com.hbt.semillero.entidades.EstadoEnum;
import com.hbt.semillero.entidades.TematicaEnum;
import com.hbt.semillero.pojo.GestionarComicPOJO;

public class AppTest {

	public void shouldAnswerWithTrue() {

	}
	
	/**
	 * 
	 * Metodo encargado de invertir una cadena
	 * <b></b>
	 * @author William 
	 *
	 */
	private String invertirCadena(String cadena) {
        String cadenaInvertida = "";
        for (int x = cadena.length() - 1; x >= 0; x--) {
                      cadenaInvertida = cadenaInvertida + cadena.charAt(x);
        }
        return cadenaInvertida;
	}
	
	/**
	 * 
	 * Metodo encargado de Caso inversion de la cadena
	 * <b></b>
	 * @author William 
	 *
	 */
	@Test(description = "Caso inversion de la cadena", enabled = false)
	public void invertirCadenaPU() {
		String cadenaInvertir = "codigo";
		String cadenaEsperada = "ogidoc";
		Assert.assertEquals(invertirCadena(cadenaInvertir), cadenaEsperada);
	}
	
	/**
	 * 
	 * Metodo encargado de Caso donde el parametro es vacio
	 * <b></b>
	 * @author William 
	 *
	 */
	@Test(description = "Caso donde el parametro es vacio", enabled = false)
	public void invertirCadenaPU2() {
		Assert.assertEquals(invertirCadena(""),"");
	}
	
	/**
	 * 
	 * Metodo encargado de Caso de inversion que la cadena
	 * <b></b>
	 * @author William 
	 *
	 */
	@Test(description = "Caso de inversion que la cadena", enabled = false)
	public void invertirCadenaPU3() {
		Assert.assertNotEquals(invertirCadena("abac"),"abac");
	}
	
	/**
	 * 
	 * Metodo encargado de Caso de verificacion del tamaño de la cadena invertida
	 * <b></b>
	 * @author William 
	 *
	 */
	@Test(description = "Caso de verificacion del tamaño de la cadena invertida", enabled = false)
	public void invertirCadenaPU4() {
		Assert.assertEquals(invertirCadena("suma").length(),4);
	}
	
	/**
	 * 
	 * Metodo encargado de Caso de verificacion de cadenas con espacios
	 * <b></b>
	 * @author William 
	 *
	 */
	@Test(description = "Caso de verificacion de cadenas con espacios", enabled = false)
	public void invertirCadenaPU5() {
		Assert.assertEquals(invertirCadena("a la ")," al a");
	}
	
	/**
	 * 
	 * Metodo encargado de Caso de verificacion de cadenas con caracteres   especiales
	 * <b></b>
	 * @author William 
	 *
	 */
	@Test(description = "Caso de verificacion de cadenas con caracteres   especiales", enabled = false)
	public void invertirCadenaPU6() {
		Assert.assertEquals(invertirCadena("hol$_op"),"po_$loh");
	}
	
	/**
	 * 
	 * Metodo encargado de Instanciar un enum de la clase EstadoEnum
	 * <b></b>
	 * @author William 
	 *
	 */
	@Test(description = "Instanciar un enum de la clase EstadoEnum", enabled = false)
	public void Ejercicio2PU1() {
		EstadoEnum est1 = EstadoEnum.ACTIVO;
		Assert.assertEquals(est1,EstadoEnum.ACTIVO);
	}
	
	/**
	 * 
	 * Metodo encargado de Devolver un String con el nombre de la constante (ACTIVO)
	 * <b></b>
	 * @author William
	 *
	 */
	@Test(description = "Devolver un String con el nombre de la constante (ACTIVO)", enabled = false)
	public void Ejercicio2PU2() {
		EstadoEnum est1 = EstadoEnum.ACTIVO;
		String nombre = est1.name();
		Assert.assertEquals(nombre,EstadoEnum.ACTIVO.name());
	}

	/**
	 * 
	 * Metodo encargado de Devolver un entero con la posición del enum según está declarada
	 * <b></b>
	 * @author William
	 *
	 */
	@Test(description = "Devolver un entero con la posición del enum según está declarada", enabled = false)
	public void Ejercicio2PU3() {
		EstadoEnum est1 = EstadoEnum.ACTIVO;
		int posicion = est1.ordinal();
		Assert.assertEquals(posicion,EstadoEnum.ACTIVO.ordinal());
	}
	
	/**
	 * 
	 * Comparar el enum con el parámetro según el orden en el que están declarados lo enum
	 * <b></b>
	 * @author William
	 *
	 */
	@Test(description = "Comparar el enum con el parámetro según el orden en el que están declarados lo enum",
			enabled = false)
	public void Ejercicio2PU4() {
		EstadoEnum est1 = EstadoEnum.ACTIVO;
		Assert.assertTrue(est1.equals(EstadoEnum.ACTIVO));
		Assert.assertFalse(est1.equals(EstadoEnum.INACTIVO));
	}
	
	/**
	 * 
	 * Devolver un array que contiene todos los enum
	 * <b></b>
	 * @author William
	 *
	 */
	@Test(description = "Devolver un array que contiene todos los enum", enabled = false)
	public void Ejercicio2PU5() {
		EstadoEnum est1 = EstadoEnum.ACTIVO;
		Assert.assertEquals(est1.values(),EstadoEnum.values());
	}
	
	/**
	 * 
	 * prueba toString comic
	 * <b></b>
	 * @author William
	 *
	 */
	@Test(description = "prueba toString comic", enabled = false)
	public void Ejercicio2PU6() {
		Comic c =  new Comic();
		Assert.assertNotNull(c.toString());
	}
	
	/**
	 * 
	 * Metodo encargado de probar la base de datos FAKE
	 * @author William Vasquez
	 *
	 */
	@Test(enabled = false)
	public void Clase3PU() {
		GestionarComicPOJO pu = new GestionarComicPOJO();
		Assert.assertTrue(pu.getListaComics().isEmpty());
	}
	
	
}




