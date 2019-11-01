/**
 * GestionarComicBean.java
 */
package com.htb.semillero.jbe;

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
public class GestionarComicBean {
	
	@PersistenceContext
	private EntityManager en;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void crearComic(ComicDTO comicDTO) {
		
		Comic comic =  new Comic();
		comic.setId(comicDTO.getId());
		
		
		en.persist(comic);
		
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void modificar(ComicDTO comicDTO) {
		Comic comic = new Comic();
		comic.setId(comicDTO.getId());
		
		en.merge(comic);
	}
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ComicDTO consultarComic(String id) {
		
		Comic comic = en.find(Comic.class,id);
		ComicDTO comicDTO = new ComicDTO(comic.getId(), comic.getNombre());
		return comicDTO;
	}
	
	public List<ComicDTO> consultarTodos(){
		en.createNativeQuery("Select * from Comic").getResultList();
		List<Comic> resultados = (List<Comic>) en.createQuery("select c from Comic").getResultList();
		return null;
	}
	

}
