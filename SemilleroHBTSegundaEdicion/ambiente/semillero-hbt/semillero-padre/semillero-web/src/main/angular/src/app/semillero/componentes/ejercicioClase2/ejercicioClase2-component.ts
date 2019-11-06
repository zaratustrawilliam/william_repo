import {Component, OnInit} from '@angular/core';
import { Ejercicio2DTO } from '../../dto_propia/ejercicio2.dto';

@Component({
    selector: 'ejerClase_2',
    templateUrl : './ejercicioClase2-component.html'
})

/**
 * @description Componente que contiene la información paar el desarrollo del ejercicio 2
 * 
 * @author William Andres Vasquez Sanabria <willivasquez98@gmail.com>
 */
export class EjercicioClase2 implements OnInit {

    /**
     * parametro que contiene la lista de comics
     */
    public lista : Array<Ejercicio2DTO>;
    /**
     * parametro que tiene e nombre del comic eliminado
     */
    public comicEliminado : string = "";

    /**
     * parametro que contiene el comic eliminado
     */
    public comicEliminadoDTO : Ejercicio2DTO;

    /**
     * implementacion de la interfaz OnInit
     */
    ngOnInit(): void {
        this.lista = new Array<Ejercicio2DTO>();
        //instancia 1
        this.lista.push(new Ejercicio2DTO(1,"superman","dc comics","superheroes",
        20,15265,"autor1",false, new Date(),"ACTIVO"));

        //instancia 2
        this.lista.push(new Ejercicio2DTO(2,"batman","dc comics","accion",
        50,60500.99,"pedrito barrera",true, new Date("2019-10-10"),"ACTIVO"));

        //instacia 3
        this.lista.push(new Ejercicio2DTO(3,"cooler","atoi","guerra",
        25,26900.85," yamsha",false, new Date(),"INACTIVO"));

        //instancia 4
        this.lista.push(new Ejercicio2DTO(4,"popeye","moviv","aventura",
        60,19265,"carlos villamizar",true, new Date("2010-05-12"),"ACTIVO"));

        //instancia 5
        this.lista.push(new Ejercicio2DTO(5,"hunterxhunter","atoi","aventura",
        80,75000.99,"yamsha",false, new Date(),"ACTIVO"));
    }

    /**
     * 
     * @param numero elemento a eliminar de la lista
     */
    public eliminarTres(numero : number) : void{
        for (let index = 0; index < this.lista.length; index++) {
            const element = this.lista[index];
            if(element.id=== numero){
                this.comicEliminado = element.nombre;
                this.comicEliminadoDTO = this.lista.slice(numero,numero + 1)[0];
                console.log(this.comicEliminadoDTO);
            }
            
        }
      
    }

    /**
     * 
     * @param item Elemento a convertir en string
     */
    public conv(item :Ejercicio2DTO) : string{
        return JSON.stringify(item);
    }

}