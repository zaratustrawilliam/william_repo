import { Component } from '@angular/core';

/**
 * @description Componente que contiene la información personal del aprendiz
 * 
 * @author William Andres Vasquez Sanabria <willivasquez98@gmail.com>
 */
@Component({
    selector: 'agregarInfoPersonal',
    templateUrl: './agregarInfoPersonal-component.html'
})

export class InfoPersonalComponent {
    
    /**
     * Atributo que lleva el nombre del aprendiz
     */
    nombre : string 
    /**
     * Atributo que lleva el nombre de la ciudad
     */
    ciudad : string
    /**
     * Atributo que lleva el link del repositorio
     */
    repo : string
    
    /**
     * Constructor de la clase 
     */
    constructor( ){
        this.nombre =  "William Andres Vasquez Sanabria"
        this.ciudad = "Manizales"
        this.repo = "https://github.com/zaratustrawilliam/william_repo.git"
    }

}
