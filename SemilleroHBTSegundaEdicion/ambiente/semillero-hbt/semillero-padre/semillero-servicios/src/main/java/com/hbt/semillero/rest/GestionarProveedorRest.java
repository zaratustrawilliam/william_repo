/**
 * GestionarProveedorRest.java
 */
package com.hbt.semillero.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.annotations.common.util.impl.Log;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.dto.ProveedorDTO;
import com.htb.semillero.ejb.IGestionarComicLocal;
import com.htb.semillero.ejb.IGestionarProveedorLocal;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author acer
 * @version 
 */
@Path("/GestionarProveedor")
public class GestionarProveedorRest {

	@EJB
	private IGestionarProveedorLocal gestionarProveedorEJB;
	
	/**
	 * 
	 * Metodo encargado de consultar todos los proveedores
	 * <b>Caso de Uso</b>
	 * @author acer
	 * 
	 * @return
	 * @throws Exception
	 */
	@GET
	@Path("/consultarProveedores")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProveedorDTO> consultarProveedores() throws Exception {
		try {
			return gestionarProveedorEJB.consultarProveedores();
		}catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	/**
	 * 
	 * Metodo encargado de modificar el estado de un proveedor
	 * <b>Caso de Uso</b>
	 * @author acer
	 * 
	 * @param proveedorDTO
	 * @throws Exception
	 */
	@POST
	@Path("/desactivar")
	@Produces(MediaType.APPLICATION_JSON)
	public void desactivarProveedor(ProveedorDTO proveedorDTO) throws Exception {
		try {
			gestionarProveedorEJB.modificarEstadoProveedor(proveedorDTO.getId(), proveedorDTO.getEstado(), proveedorDTO);
		}catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * 
	 * Metodo encargado de modificar el monto de credito de un proveedor
	 * <b>Caso de Uso</b>
	 * @author acer
	 * 
	 * @param proveedorDTO
	 * @throws Exception
	 */
	@POST
	@Path("/modificar")
	@Produces(MediaType.APPLICATION_JSON)
	public void modificarProveedorr(ProveedorDTO proveedorDTO) throws Exception {
		try {
			gestionarProveedorEJB.modificarProveedor(proveedorDTO.getIdPersona(), proveedorDTO.getMontoCredito(), proveedorDTO);
		}catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}
	}
	/**
	 * 
	 * Metodo encargado de crear un nuevo proveedor en la base de datos
	 * <b>Caso de Uso</b>
	 * @author acer
	 * 
	 * @param proveedorDTO
	 * @throws Exception
	 */
	@POST
	@Path("/crear")
	@Produces(MediaType.APPLICATION_JSON)
	public void crearProveedor(ProveedorDTO proveedorDTO) throws Exception {
		try {
			gestionarProveedorEJB.modificarProveedor(proveedorDTO.getIdPersona(), proveedorDTO.getMontoCredito(), proveedorDTO);
		}catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
