/**
 * Proveedor.java
 */
package com.hbt.semillero.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * <b>Descripción:<b> Clase que determina la entidad que permite representar
 * la tabla TC_PROVEEDOR
 * <b>Caso de Uso:<b> 
 * @author acer
 * @version 
 */

@Entity
@Table(name = "TC_PROVEEDOR")
public class Proveedor implements Serializable{
	
	/**
	 * Atributo que determina  
	 *TODO PARA QUE SIRVE SERIALIZABLE -> nos permite pasar a bytes los objetos como nos permite recibir estos bytes para crearlos de nuevo
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String direccion;
	private LocalDate fechaCreacion;
	private EstadoEnum estado;
	private Long idPersona;
	private BigDecimal montoCredito;
	
	/**
	 * 
	 * Constructor de la clase.
	 */
	public Proveedor() {
		
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
	public Proveedor(Long id, String direccion, LocalDate fechaCreacion, EstadoEnum estado, Long idPersona,
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
	@Id
	@Column(name = "SPID")
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
	@Column(name = "SPDIRECCION")
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
	 * Metodo encargado de retornar el valor del atributo fecha_creacion
	 * @return El fecha_creacion asociado a la clase
	 */
	@Column(name = "SPFECHA_CREACION")
	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo fecha_creacion
	 * @param fecha_creacion El nuevo fecha_creacion a modificar.
	 */
	public void setFechaCreacion(LocalDate fecha_creacion) {
		this.fechaCreacion = fecha_creacion;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo estado
	 * @return El estado asociado a la clase
	 */
	@Column(name = "SPESTADO")
	@Enumerated(value = EnumType.STRING)
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
	@Column(name = "SPIDPERSONA")
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
	 * Metodo encargado de retornar el valor del atributo monto_credito
	 * @return El monto_credito asociado a la clase
	 */
	@Column(name = "SPMONTO_CREDITO")
	public BigDecimal getMontoCredito() {
		return montoCredito;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo monto_credito
	 * @param monto_credito El nuevo monto_credito a modificar.
	 */
	public void setMontoCredito(BigDecimal monto_credito) {
		this.montoCredito = monto_credito;
	}

	/** 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Proveedor [id=" + id + ", direccion=" + direccion + ", fecha_creacion=" + fechaCreacion + ", estado="
				+ estado + ", idPersona=" + idPersona + ", monto_credito=" + montoCredito + "]";
	}

	/** 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((fechaCreacion == null) ? 0 : fechaCreacion.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idPersona == null) ? 0 : idPersona.hashCode());
		result = prime * result + ((montoCredito == null) ? 0 : montoCredito.hashCode());
		return result;
	}

	/** 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Proveedor other = (Proveedor) obj;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		if (estado != other.estado)
			return false;
		if (fechaCreacion == null) {
			if (other.fechaCreacion != null)
				return false;
		} else if (!fechaCreacion.equals(other.fechaCreacion))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idPersona == null) {
			if (other.idPersona != null)
				return false;
		} else if (!idPersona.equals(other.idPersona))
			return false;
		if (montoCredito == null) {
			if (other.montoCredito != null)
				return false;
		} else if (!montoCredito.equals(other.montoCredito))
			return false;
		return true;
	}
	
	
	
	

}
