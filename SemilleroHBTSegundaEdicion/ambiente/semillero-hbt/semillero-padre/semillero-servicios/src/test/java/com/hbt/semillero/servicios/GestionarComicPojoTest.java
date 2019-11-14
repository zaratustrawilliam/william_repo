/**
 * GestionarComicPojoTest.java
 */
package com.hbt.semillero.servicios;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hbt.semillero.entidades.EstadoEnum;
import com.hbt.semillero.entidades.TematicaEnum;
import com.hbt.semillero.pojo.GestionarComicPOJO;

/**
 * <b>Descripción:<b> Clase que nos permite probar lso metodos del GestionarComicPOJO
 * <b>:<b> 
 * @author William Vasquez
 * @version 
 */
public class GestionarComicPojoTest {
	
	/**
	 * 
	 * Metodo encargado de probar el metodo eliminar de GestionarComicPOJO
	 * 
	 * @author William Vasquez
	 *
	 */
	@Test(enabled = false)
	public void PUeliminar() {
		GestionarComicPOJO g = new GestionarComicPOJO();
		g.agregarListDTO(g.CrearComicDTO("1", "Dragon Ball Yamcha", "Planeta Comic", TematicaEnum.AVENTURAS, "Manga Shonen", 
				144, new BigDecimal(2100), "Dragon Garow Lee", Boolean.FALSE, LocalDate.now(), 
				EstadoEnum.ACTIVO, 20l));
		g.agregarListDTO(g.CrearComicDTO("2", "Captain America Corps 1-5 USA", "Panini Comics", TematicaEnum.FANTASTICO, "BIBLIOTECA MARVEL", 
				128, new BigDecimal(5000), "Phillippe Briones, Roger Stern", Boolean.FALSE, LocalDate.now(), 
				EstadoEnum.ACTIVO, 5l));
		g.agregarListDTO(g.CrearComicDTO("3", "The Spectacular Spider-Man v2 USA", "Panini Comics", TematicaEnum.FANTASTICO, "MARVEL COMICS", 
				208, new BigDecimal(6225), "Straczynski,Deodato Jr.,Barnes,Eaton", Boolean.TRUE, LocalDate.now(), 
				EstadoEnum.INACTIVO, 0l));
		
		int tamañoAnterior = g.getListaComics().size();
		g.eliminarComicDTO("1");
		Assert.assertEquals(g.getListaComics().size(), tamañoAnterior - 1);
	}
	
	/**
	 * 
	 * Metodo encargado de probar el metodo modificar de GestionarComicPOJO
	 * 
	 * @author William Vasquez
	 *
	 */
	@Test(enabled = false)
	public void PUmodificar() {
		GestionarComicPOJO g = new GestionarComicPOJO();
		g.agregarListDTO(g.CrearComicDTO("1", "Dragon Ball Yamcha", "Planeta Comic", TematicaEnum.AVENTURAS, "Manga Shonen", 
				144, new BigDecimal(2100), "Dragon Garow Lee", Boolean.FALSE, LocalDate.now(), 
				EstadoEnum.ACTIVO, 20l));
		g.agregarListDTO(g.CrearComicDTO("2", "Captain America Corps 1-5 USA", "Panini Comics", TematicaEnum.FANTASTICO, "BIBLIOTECA MARVEL", 
				128, new BigDecimal(5000), "Phillippe Briones, Roger Stern", Boolean.FALSE, LocalDate.now(), 
				EstadoEnum.ACTIVO, 5l));
		g.agregarListDTO(g.CrearComicDTO("3", "The Spectacular Spider-Man v2 USA", "Panini Comics", TematicaEnum.FANTASTICO, "MARVEL COMICS", 
				208, new BigDecimal(6225), "Straczynski,Deodato Jr.,Barnes,Eaton", Boolean.TRUE, LocalDate.now(), 
				EstadoEnum.INACTIVO, 0l));
		
		g.modificarComicDTO("2","Captain America");
		Assert.assertEquals(g.getListaComics().get(1).getNombre(),"Captain America");
	}
}
