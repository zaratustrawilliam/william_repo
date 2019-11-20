/**
 * GestionarProveedoresBean.java
 */
package com.htb.semillero.ejb;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.hbt.semillero.dto.ProveedorDTO;
import com.hbt.semillero.entidades.EstadoEnum;
import com.hbt.semillero.entidades.Proveedor;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author acer
 * @version 
 */
@Stateless
public class GestionarProveedoresBean implements IGestionarProveedorLocal{
	
	@PersistenceContext
	private EntityManager en;

	/** 
	 * @see com.htb.semillero.ejb.IGestionarProveedorLocal#crearProveedor(com.hbt.semillero.dto.ProveedorDTO)
	 * Metodo encargado de anexar el provedor a la base de datos si la cantidad de proveedores es menor a 10
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void crearProveedor(ProveedorDTO proveedorDTO) throws Exception {
		
		if(Integer.parseInt(en.createQuery("select COUNT(p) from Proveedor p").getSingleResult().toString()) < 30 ) {
			if(proveedorDTO == null) {
				throw new NullPointerException("El objeto ProveedorDTO es nulo");
			}else {
				en.persist(convertirProveedorDTOToProveedor(proveedorDTO));
			}
		}else {
			throw new  Exception("YA NO HAY ESPACIO PARA MAS PROVEEDORES");
		}
		
	}

	/** 
	 * @see com.htb.semillero.ejb.IGestionarProveedorLocal#modificarProveedor(java.lang.Long, java.math.BigDecimal, java.lang.String)
	 * el metodo nos permite modificar el parametro montoCredito de la base de datos
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void modificarProveedor(Long id, BigDecimal montoCredito,ProveedorDTO nuevo) throws Exception {
		
		Proveedor proveedorModificar;
		if(id == null || montoCredito == null) {
			throw new NullPointerException("Los parametros ingresados son nulos");
		}else {
			if(nuevo == null) {
				proveedorModificar = en.find(Proveedor.class,id);
			}else {
				proveedorModificar = convertirProveedorDTOToProveedor(nuevo);
			}
			proveedorModificar.setMontoCredito(montoCredito);
			en.merge(proveedorModificar);
		}
	}

	/** 
	 * @see com.htb.semillero.ejb.IGestionarProveedorLocal#modificarEstadoProveedor(java.lang.Long, com.hbt.semillero.entidades.EstadoEnum)
	 * el metodo nos permite modificar el parametro estadoproveedor de la base de datos
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void modificarEstadoProveedor(Long id, EstadoEnum estadoProveedor, ProveedorDTO nuevo) throws Exception {
		
		Proveedor proveedorModificar;
		if(id == null || estadoProveedor == null) {
			throw new NullPointerException("Los parametros ingresados son nulos");
		}else {
			if(nuevo == null) {
				proveedorModificar = en.find(Proveedor.class,id);
			}else {
				proveedorModificar = convertirProveedorDTOToProveedor(nuevo);
			}
			proveedorModificar.setEstado(estadoProveedor);
			en.merge(proveedorModificar);
		}
	}

	/** 
	 * @see com.htb.semillero.ejb.IGestionarProveedorLocal#consultarComics()
	 * el metodo nos permite consultar todos los proveedores
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ArrayList<ProveedorDTO> consultarProveedores() throws Exception{
		
		ArrayList<ProveedorDTO> listaProveedores = new ArrayList<ProveedorDTO>();
		List<Proveedor> resultados = en.createQuery("select c from Proveedor c").getResultList();
		if(resultados == null) {
			throw new NullPointerException ("La consulta arrojo como valor null");
		}else {
			for(Proveedor proveedor : resultados) {
				listaProveedores.add(convertirProveedorToProveedorDTO(proveedor));
			}
		}
		return listaProveedores;
	}
	
	/**
	 * 
	 * Metodo encargado de indicar si el contarto se encuentra en vigencia o no
	 * <b>Caso de Uso</b>
	 * @author acer
	 * 
	 * @param id
	 * @return
	 */
	public Boolean vigenciaContrato(Long id){
		LocalDate fechaContrato =  LocalDate.parse(en.createQuery("select p.getFechaCreacion() "
				+ "from Proveedor p where p.getId() == id").getSingleResult().toString());
		return LocalDate.now().getYear() - fechaContrato.getYear() < 1;
	}
	
	/**
	 * 
	 * Metodo encargado de retornar true si el credito proveedor excede los 15000000
	 * <b>Caso de Uso</b>
	 * @author acer
	 * 
	 * @param monto
	 * @return
	 */
	private Boolean excedeUmbral(BigDecimal monto) {
		return monto.compareTo(new BigDecimal(15000000)) == 1;
	}
	
	/**
	 * 
	 * Metodo encargado de convertir un objeto del tipo Proveedor a ProveedorDTO
	 * <b>Caso de Uso</b>
	 * @author acer
	 * 
	 * @param proveedor
	 * @return
	 */
	private ProveedorDTO convertirProveedorToProveedorDTO(Proveedor proveedor) {
		return new ProveedorDTO(proveedor.getId(),proveedor.getDireccion(),
				proveedor.getFechaCreacion(),proveedor.getEstado(),proveedor.getIdPersona(),proveedor.getMontoCredito());
	}
	
	/**
	 * 
	 * Metodo encargado de convertir un objeto del tipo proveedorDTO a proveedor
	 * <b>Caso de Uso</b>
	 * @author acer
	 * 
	 * @param proveedorDTO
	 * @return
	 */
	private Proveedor convertirProveedorDTOToProveedor(ProveedorDTO proveedorDTO) {
		return new Proveedor(proveedorDTO.getId(),proveedorDTO.getDireccion(),
				proveedorDTO.getFechaCreacion(),proveedorDTO.getEstado(),proveedorDTO.getIdPersona(),proveedorDTO.getMontoCredito());
	}

}
