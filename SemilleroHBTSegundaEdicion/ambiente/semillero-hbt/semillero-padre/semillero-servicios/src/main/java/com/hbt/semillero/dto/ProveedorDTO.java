/**
 * ProveedorDTO.java
 */
package com.hbt.semillero.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.hbt.semillero.entidades.EstadoEnum;

/**
 * <b>Descripción:<b> Clase que determina el objeto que contendra las reglas
 *  del negocio para el requerimiento 
 * <b>Caso de Uso:<b> 
 * @author acer
 * @version 
 */
public class ProveedorDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String direccion;
	private LocalDate fechaCreacion;
	private EstadoEnum estado;
	private Long idPersona;
	private BigDecimal montoCredito;
	private String nombreUsuario;

	private Long numIdentificacion;


	public ProveedorDTO() {
		super();
	}
	


	/**
	 * Constructor de la clase.
	 * @param id
	 * @param direccion
	 * @param fechaCreacion
	 * @param estado
	 * @param idPersona
	 * @param montoCredito
	 */
	public ProveedorDTO(Long id, String direccion, LocalDate fechaCreacion, EstadoEnum estado, Long idPersona,
			BigDecimal montoCredito) {
		super();
		this.id = id;
		this.direccion = direccion;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
		this.idPersona = idPersona;
		this.montoCredito = montoCredito;
	}


	/**
	 * Metodo encargado de retornar el valor del atributo id
	 * @return El id asociado a la clase
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo id
	 * @param id El nuevo id a modificar.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo direccion
	 * @return El direccion asociado a la clase
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo direccion
	 * @param direccion El nuevo direccion a modificar.
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo fechaCreacion
	 * @return El fechaCreacion asociado a la clase
	 */
	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo fechaCreacion
	 * @param fechaCreacion El nuevo fechaCreacion a modificar.
	 */
	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo estado
	 * @return El estado asociado a la clase
	 */
	public EstadoEnum getEstado() {
		return estado;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo estado
	 * @param estado El nuevo estado a modificar.
	 */
	public void setEstado(EstadoEnum estado) {
		this.estado = estado;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo idPersona
	 * @return El idPersona asociado a la clase
	 */
	public Long getIdPersona() {
		return idPersona;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo idPersona
	 * @param idPersona El nuevo idPersona a modificar.
	 */
	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo montoCredito
	 * @return El montoCredito asociado a la clase
	 */
	public BigDecimal getMontoCredito() {
		return montoCredito;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo montoCredito
	 * @param montoCredito El nuevo montoCredito a modificar.
	 */
	public void setMontoCredito(BigDecimal montoCredito) {
		this.montoCredito = montoCredito;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo serialVersionUID
	 * @return El serialversionuid asociado a la clase
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	/**
	 * Metodo encargado de retornar el valor del atributo nombreUsuario
	 * @return El nombreUsuario asociado a la clase
	 */
	public String getNombreUsuario() {
		return nombreUsuario;
	}



	/**
	 * Metodo encargado de modificar el valor del atributo nombreUsuario
	 * @param nombreUsuario El nuevo nombreUsuario a modificar.
	 */
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	
	/**
	 * Metodo encargado de retornar el valor del atributo numIdentificacion
	 * @return El numIdentificacion asociado a la clase
	 */
	public Long getNumIdentificacion() {
		return numIdentificacion;
	}



	/**
	 * Metodo encargado de modificar el valor del atributo numIdentificacion
	 * @param numIdentificacion El nuevo numIdentificacion a modificar.
	 */
	public void setNumIdentificacion(Long numIdentificacion) {
		this.numIdentificacion = numIdentificacion;
	}



	
}
