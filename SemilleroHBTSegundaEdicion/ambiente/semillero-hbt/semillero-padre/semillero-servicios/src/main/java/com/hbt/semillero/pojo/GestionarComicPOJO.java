/**
 * GestionarComicPOJO.java
 */
package com.hbt.semillero.pojo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.entidades.EstadoEnum;
import com.hbt.semillero.entidades.TematicaEnum;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author WILLIAM VASQUEZ
 * @version 
 */
public class GestionarComicPOJO {
	private List<ComicDTO> listaComics = null;
	
	/**
	 * 
	 * Constructor de la clase.
	 */
	public GestionarComicPOJO() {
		this.listaComics = new ArrayList<>();
	}
	
	/**
	 * 
	 * Metodo encargado de crear un objeto ComicDTO
	 * 
	 * @author William Vasquez
	 * 
	 * @param id
	 * @param nombre
	 * @param editorial
	 * @param tematica
	 * @param coleccion
	 * @param numeroPaginas
	 * @param precio
	 * @param autores
	 * @param color
	 * @param fecha
	 * @param estado
	 * @param cantidad
	 * @return
	 */
	public ComicDTO CrearComicDTO(String id, String nombre, String editorial,TematicaEnum tematica, 
			String coleccion,int numeroPaginas,BigDecimal precio,String autores, boolean color, LocalDate fecha,
			EstadoEnum estado, long cantidad) {
		return new ComicDTO(id,nombre,editorial,tematica,coleccion,numeroPaginas,precio,autores,color,fecha,estado,cantidad);
	}
	
	/**
	 * 
	 * Metodo encargado de agregar objetos ComicDTO a la lista
	 * 
	 * @author William Vasquez
	 * 
	 * @param c
	 */
	public void agregarListDTO(ComicDTO c) {
		this.listaComics.add(c);
	}
	
	/**
	 * 
	 * Metodo encargado de modificar la lista de Comics
	 * 
	 * @author William Vasquez
	 * 
	 * @param id
	 * @param nombre
	 */
	public void modificarComicDTO(String id, String nombre) {
		for(ComicDTO comicDTO :  this.listaComics) {
			if(comicDTO.getId().equals(id)) {
				comicDTO.setNombre(nombre);
				return;
			}
		}
	}
	
	/**
	 * 
	 * Metodo encargado de eliminar comicDTO de la lista
	 * 
	 * @author William Vasquez
	 * 
	 * @param id
	 */
	public void eliminarComicDTO(String id) {
		if(!this.listaComics.isEmpty()) {
			int i = 0;
			while(i < this.listaComics.size()) {
				if(this.listaComics.get(i).getId().equals(id)) {
					this.listaComics.remove(i);
					return;
				}
				i++;
			}
		}
	}

	/**
	 * Metodo encargado de retornar el valor del atributo listaComics
	 * @return El listaComics asociado a la clase
	 */
	public List<ComicDTO> getListaComics() {
		return listaComics;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo listaComics
	 * @param listaComics El nuevo listaComics a modificar.
	 */
	public void setListaComics(List<ComicDTO> listaComics) {
		this.listaComics = listaComics;
	}
	
	
}
