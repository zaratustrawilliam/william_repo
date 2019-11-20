/**
 * IGestionarProveedorLocal.java
 */
package com.htb.semillero.ejb;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.ejb.Local;

import com.hbt.semillero.dto.ProveedorDTO;
import com.hbt.semillero.entidades.EstadoEnum;

/**
 * <b>Descripción:<b> interfaz que nos permite definir la arquitectura del EJB
 * <b>Caso de Uso:<b> 
 * @author acer
 * @version 
 */
@Local
public interface IGestionarProveedorLocal {
	
	
	public void crearProveedor(ProveedorDTO proveedorDTO) throws Exception;
	
	public void modificarProveedor(Long id,BigDecimal montoCredito,ProveedorDTO nuevo)throws Exception;
	
	public void modificarEstadoProveedor(Long id, EstadoEnum estadoProveedor, ProveedorDTO nuevo)throws Exception;
	
	public ArrayList<ProveedorDTO> consultarProveedores() throws Exception;
}
