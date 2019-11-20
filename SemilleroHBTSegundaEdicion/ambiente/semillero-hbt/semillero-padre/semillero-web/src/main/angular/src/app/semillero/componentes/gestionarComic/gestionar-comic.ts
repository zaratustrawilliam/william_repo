
import { ComicDTO } from '../../dto/comic.dto';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { GestionarComicService } from '../../services/gestionar.comic.service';
import { ResultadoDTO } from '../../dto/resultado.dto';

/**
 * @description Componenete gestionar comic, el cual contiene la logica CRUD
 * 
 * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
 */
@Component({
    selector: 'gestionar-comic',
    templateUrl: './gestionar-comic.html',
    styleUrls: ['./gestionar-comic.css']
})
export class GestionarComicComponent implements OnInit {

    /**
     * Atributo que contiene los controles del formulario
     */
    public gestionarComicForm: FormGroup;

    /**
     * Atributo que contendra la informacion del comic
     */
    public comic: ComicDTO;

    /**
     * Atributo que contendra la lista de comics creados
     */
    public listaComics: Array<ComicDTO>;

    public idComic: number = 20;

    /**
     * Atributo que indica si se envio a validar el formulario
     */
    public submitted: boolean;

    /**
     * Atributo bandera que indica que estamos editando un comic
     */
    public modoEdicion : boolean;
    /**
     * Atributo que indica el indice en la lista del elemento editado
     */
    public indiceEditado : number;

    /**
     * Atributo bandera que indica que estamos eliminando un comic 
     */
    public modoElimado : boolean;


    /**
   * @description Este es el constructor del componente GestionarComicComponent
   * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
   */
    constructor(private fb: FormBuilder,
        private router: Router,
        private gestionarComicService : GestionarComicService) {
        this.gestionarComicForm = this.fb.group({
            nombre: [null, Validators.required],
            editorial: [null],
            tematica: [null],
            coleccion: [null],
            numeroPaginas: [null],
            precio: [null],
            autores: [null],
            color: [null]
        });
    }

    /**
     * @description Evento angular que se ejecuta al invocar el componente
     * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
     */
    ngOnInit(): void {
        console.log("Ingreso al al evento oninit");
        this.comic = new ComicDTO();
        this.listaComics = new Array<ComicDTO>();
        this.consultarComics();
    }

     /**
     * @description Metodo encargado de consultar los comics existentes
     * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
     */
    public consultarComics() : void {
        this.gestionarComicService.consultarComics().subscribe(listaComics => {
            this.listaComics = listaComics;
        }, error => {
            console.log(error);
        });
    }

    /**
     * @description Metodo que permite validar el formulario y crear o actulizar un comic
     */
    public crearActualizarComic(): void {
        this.submitted = true;

        console.log(this.modoEdicion);
        if (this.gestionarComicForm.invalid) {
            return;
        }
        if(this.modoEdicion){
            this.listaComics[this.indiceEditado].nombre = this.gestionarComicForm.controls.nombre.value;
            this.listaComics[this.indiceEditado].editorial = this.gestionarComicForm.controls.editorial.value;
            this.listaComics[this.indiceEditado].tematica = this.gestionarComicForm.controls.tematica.value;
            this.listaComics[this.indiceEditado].coleccion = this.gestionarComicForm.controls.coleccion.value;
            this.listaComics[this.indiceEditado].numeroPaginas = this.gestionarComicForm.controls.numeroPaginas.value;
            this.listaComics[this.indiceEditado].precio = this.gestionarComicForm.controls.precio.value;
            this.listaComics[this.indiceEditado].autores = this.gestionarComicForm.controls.autores.value;
            this.listaComics[this.indiceEditado].color = this.gestionarComicForm.controls.color.value;
            this.listaComics[this.indiceEditado].cantidad = 12;
           
            this.gestionarComicService.actualizarComic(this.listaComics[this.indiceEditado]).subscribe(resultado =>
                {
                    this.consultarComics();
                    this.limpiarFormulario();
                }, error=>{
                    console.log(error);
                });

            this.modoEdicion = false;

        }else{
            
            this.comic = new ComicDTO();
            
            this.comic.nombre = this.gestionarComicForm.controls.nombre.value;
            this.comic.editorial = this.gestionarComicForm.controls.editorial.value;
            this.comic.tematica = this.gestionarComicForm.controls.tematica.value;
            this.comic.coleccion = this.gestionarComicForm.controls.coleccion.value;
            this.comic.numeroPaginas = this.gestionarComicForm.controls.numeroPaginas.value;
            this.comic.precio = this.gestionarComicForm.controls.precio.value;
            this.comic.autores = this.gestionarComicForm.controls.autores.value;
            this.comic.color = this.gestionarComicForm.controls.color.value;
            this.comic.cantidad = 12;

         //   this.listaComics.push(this.comic);

            
            this.gestionarComicService.crearComic(this.comic).subscribe(resultado => {
                
                    this.consultarComics();
                    this.limpiarFormulario();
                
            }, error => {
                console.log(error);
            });

        }

       

    }

    /**
     * Metodo que permite consultar un comic de la tabla y sus detalles e inhabilitar el formulario
     * @param posicion en la lista del comic seleccionado
     */
    public consultarComic(posicion: number): void {
        let comic = this.listaComics[posicion];
        this.router.navigate(['consultar-comic',comic]);
    }

    /**
     * Metodo que permite editar el comic de la lista 
     * @param posicion 
     */
    public editarComic(posicion: number): void {
        this.comic = this.listaComics[posicion];
        this.gestionarComicForm.controls.nombre.setValue(this.comic.nombre);
        this.gestionarComicForm.controls.editorial.setValue(this.comic.editorial);
        this.gestionarComicForm.controls.tematica.setValue(this.comic.tematica);
        this.gestionarComicForm.controls.coleccion.setValue(this.comic.coleccion);
        this.gestionarComicForm.controls.numeroPaginas.setValue(this.comic.numeroPaginas);
        this.gestionarComicForm.controls.precio.setValue(this.comic.precio);
        this.gestionarComicForm.controls.autores.setValue(this.comic.autores);
        this.gestionarComicForm.controls.color.setValue(this.comic.color);

        this.modoEdicion = true;
        this.indiceEditado = posicion;

      
    }
    /**
     * Metodo encargado de eliminar un comic
     * @param posicion 
     */
    public eliminarComic(posicion:number):void{
        this.comic = new ComicDTO();
        console.log("entro _" + this.listaComics.length);
        this.comic = this.listaComics.splice(posicion,1)[0];
        this.gestionarComicService.eliminarComic(this.comic).subscribe(resultado => {
            console.log("entro_1 _" + this.listaComics.length);
            this.consultarComics();
        }, error => {
            console.log(error);
        });
        this.modoElimado = true;
    }

    private limpiarFormulario(): void {
        this.submitted = false;
        this.gestionarComicForm.controls.nombre.setValue(null);
        this.gestionarComicForm.controls.editorial.setValue(null);
        this.gestionarComicForm.controls.tematica.setValue(null);
        this.gestionarComicForm.controls.coleccion.setValue(null);
        this.gestionarComicForm.controls.numeroPaginas.setValue(null);
        this.gestionarComicForm.controls.precio.setValue(null);
        this.gestionarComicForm.controls.autores.setValue(null);
        this.gestionarComicForm.controls.color.setValue(null);
    }

    /**
     * @description Metodo que obtiene los controles y sus propiedades
     * @author Diego Fernando Alvarez Silva
     */
    get f() {
        return this.gestionarComicForm.controls;
    }
}