/**
 * GestionarComicBean.java
 */
package com.htb.semillero.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.*;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.entidades.Comic;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author acer
 * @version 
 */
@Stateless
public class GestionarComicBean implements IGestionarComicLocal {
	
	@PersistenceContext
	private EntityManager en;
	
	/**
	 * creo un nuevo comic
	 * @see com.htb.semillero.ejb.IGestionarComicLocal#crearComic(com.hbt.semillero.dto.ComicDTO)
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void crearComic(ComicDTO comicDTO) {
		
		en.persist(convertirComicDTOToComic(comicDTO));
		
	}
	
//	@TransactionAttribute(TransactionAttributeType.REQUIRED)
//	public void modificar(ComicDTO comicDTO) {
//		Comic comic = new Comic();
//		//comic.setId(comicDTO.getId());
//		
//		en.merge(comic);
//	}
//	
	
	/**
	 * metodo encargado de consultar un comic
	 * @see com.htb.semillero.ejb.IGestionarComicLocal#consultarComic(java.lang.String)
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ComicDTO consultarComic(String id) {
		
		Comic comic = en.find(Comic.class,Long.parseLong(id));
		ComicDTO comicDTO = convertirComicToComicDTO(comic);
		return comicDTO;
	}
	
//	public List<ComicDTO> consultarTodos(){
//		en.createNativeQuery("Select * from Comic").getResultList();
//		List<Comic> resultados = (List<Comic>) en.createQuery("select c from Comic").getResultList();
//		return null;
//	}

	/** 
	 * metodo encargado de modificar un comic, es transaccion
	 * @see com.htb.semillero.ejb.IGestionarComicLocal#modificarComic(java.lang.Long, java.lang.String, com.hbt.semillero.dto.ComicDTO)
	 */
	@Override
	//@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void modificarComic(Long id, String nombre, ComicDTO comicNuevo) {
		
		Comic comicModificar;
		if(comicNuevo == null) {
			comicModificar = en.find(Comic.class,id);
		}else {
			comicModificar = convertirComicDTOToComic(comicNuevo);
		}
		comicModificar.setNombre(nombre);
		en.merge(comicModificar);
	}

	/** 
	 * metodo encargado de eliminar un comic
	 * @see com.htb.semillero.ejb.IGestionarComicLocal#eliminarComic(java.lang.Long)
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void eliminarComic(Long idComic) {
		if(en.find(Comic.class,idComic) != null) {
			en.remove(en.find(Comic.class,idComic));
		}
	}

	/** 
	 * metodo encargado de consultar todos los comics
	 * @see com.htb.semillero.ejb.IGestionarComicLocal#consultarComics()
	 */
	@Override
	public List<ComicDTO> consultarComics() {
		
		List<ComicDTO> resultadosComicDTO = new ArrayList<ComicDTO>();
		List<Comic> resultados = en.createQuery("select c from Comic c").getResultList();
		for(Comic comic : resultados) {
			resultadosComicDTO.add(convertirComicToComicDTO(comic));
		}
		return resultadosComicDTO;
	}
	
	/**
	 * 
	 * Metodo encargado de traspasar informaciónd de un lado a otro
	 * <b>Caso de Uso</b>
	 * @author William Vasquez
	 * 
	 * @param comicDTO
	 * @return
	 */
	private Comic convertirComicDTOToComic(ComicDTO comicDTO) {
		Comic comic = new Comic();
	      if(comicDTO.getId()!=null) {
	            comic.setId(Long.parseLong(comicDTO.getId()));
	        }
        comic.setNombre(comicDTO.getNombre());
        comic.setEditorial(comicDTO.getEditorial());
        comic.setTematicaEnum(comicDTO.getTematica());
        comic.setColeccion(comicDTO.getColeccion());
        comic.setNumeroPaginas(comicDTO.getNumeroPaginas());
        comic.setPrecio(comicDTO.getPrecio());
        comic.setAutores(comicDTO.getAutores());
        comic.setColor(comicDTO.getColor());
        comic.setFechaVenta(comicDTO.getFechaVenta());
        comic.setEstadoEnum(comicDTO.getEstado());
        comic.setCantidad(comicDTO.getCantidad());
        return comic;
	}
	
	/**
	 * metodo encaragdo de transpasar info
	 * Metodo encargado de 
	 * <b>Caso de Uso</b>
	 * @author acer
	 * 
	 * @param comic
	 * @return
	 */
	private ComicDTO convertirComicToComicDTO(Comic comic) {
        ComicDTO comicDTO = new ComicDTO();
        if(comic.getId()!=null) {
         comicDTO.setId(comic.getId().toString());
        }
        comicDTO.setNombre(comic.getNombre());
        comicDTO.setEditorial(comic.getEditorial());
        comicDTO.setTematica(comic.getTematicaEnum());
        comicDTO.setColeccion(comic.getColeccion());
        comicDTO.setNumeroPaginas(comic.getNumeroPaginas());
        comicDTO.setPrecio(comic.getPrecio());
        comicDTO.setAutores(comic.getAutores());
        comicDTO.setColor(comic.getColor());
        comicDTO.setFechaVenta(comic.getFechaVenta());
        comicDTO.setEstado(comic.getEstadoEnum());
        comicDTO.setCantidad(comic.getCantidad());
        return comicDTO;
    }

}
