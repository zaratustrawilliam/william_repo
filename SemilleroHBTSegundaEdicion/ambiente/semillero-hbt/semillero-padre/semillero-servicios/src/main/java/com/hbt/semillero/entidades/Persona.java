/**
 * Persona.java
 */
package com.hbt.semillero.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * <b>Descripción:<b> Clase que determina la entidad a representar respecto a 
 * la tabla TC_PERSONA
 * <b>Caso de Uso:<b> 
 * @author acer
 * @version 
 */

@Entity
@Table(name = "TC_PERSONA")
public class Persona implements Serializable {
	
	private Long id;
	private String nombre;
	private Long numIdentificacion;
	
	/**
	 * 
	 * Constructor de la clase.
	 */
	public Persona () {
		
	}
	
	/** 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", num_identificacion=" + numIdentificacion + "]";
	}
	/**
	 * Metodo encargado de retornar el valor del atributo id
	 * @return El id asociado a la clase
	 */
	@Id
	@Column(name = "SCID")
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
	 * Metodo encargado de retornar el valor del atributo nombre
	 * @return El nombre asociado a la clase
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo nombre
	 * @param nombre El nuevo nombre a modificar.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo num_identificacion
	 * @return El num_identificacion asociado a la clase
	 */
	public Long getNum_identificacion() {
		return numIdentificacion;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo num_identificacion
	 * @param num_identificacion El nuevo num_identificacion a modificar.
	 */
	public void setNum_identificacion(Long num_identificacion) {
		this.numIdentificacion = num_identificacion;
	}
	/** 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((numIdentificacion == null) ? 0 : numIdentificacion.hashCode());
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
		Persona other = (Persona) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (numIdentificacion == null) {
			if (other.numIdentificacion != null)
				return false;
		} else if (!numIdentificacion.equals(other.numIdentificacion))
			return false;
		return true;
	}
	
	

}
