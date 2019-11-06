
/**
 *  @description Clase que tiene el objeto para el ejercicio 2
 * 
 * @author William Andres Vasquez Sanabria <willivasquez98@gmail.com>
 */
export class Ejercicio2DTO {
    public id : number;
    public nombre :string;
    public editorial : string;
    public tematica : string;
    public numeroDePaginas : number;
    public precio : number;
    public autores : string;
    public aColor : boolean;
    public fechaVenta : Date;
    public estado : string;

    /**
     * Constructor para crear las instacias de la clase
     * @param id 
     * @param nombre 
     * @param editorial 
     * @param tematica 
     * @param numeroDepagina 
     * @param precio 
     * @param autores 
     * @param aColor 
     * @param fechaVenta 
     * @param estado 
     */
    public constructor (id : number, nombre : string, editorial : string, tematica : string ,
        numeroDepagina : number, precio : number, autores : string, aColor : boolean, 
        fechaVenta : Date , estado : string){
            this.id = id;
            this.nombre =  nombre;
            this.editorial = editorial;
            this.tematica  =tematica;
            this.numeroDePaginas = numeroDepagina;
            this.precio = precio;
            this.autores = autores;
            this.aColor = aColor;
            this.fechaVenta = fechaVenta;
            this.estado =  estado;
    }
    
}