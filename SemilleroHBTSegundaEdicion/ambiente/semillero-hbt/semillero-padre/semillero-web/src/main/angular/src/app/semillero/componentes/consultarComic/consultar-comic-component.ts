import { ComicDTO } from '../../dto/comic.dto';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
    selector: 'consultar-comic',
    templateUrl: './consultar-comic-component.html'
})

export class ConsultarComicComponent implements OnInit{
      /**
     * Atributo que contiene los controles del formulario
     */
    public gestionarComicForm : FormGroup;

    /**
     * Atributo que contendra la informacion del comic
     */
    public comic: ComicDTO;

    /**
     * Constructor 
     * @param fb 
     * @param router 
     * @param activatedRoute 
     */
    constructor(private fb : FormBuilder,
        private router : Router, private activatedRoute: ActivatedRoute) { 
        this.gestionarComicForm = this.fb.group({
            nombre: [null],
            editorial: [null],
            tematica: [null],
            coleccion: [null],
            numeroPaginas: [null],
            precio: [null],
            autores: [null],
            color: [null]
        });
    }

    ngOnInit(): void {
        this.comic = new ComicDTO();
        console.log(JSON.stringify(this.activatedRoute.snapshot.params));
        this.comic.id = this.activatedRoute.snapshot.params.id;
        this.comic.nombre = this.activatedRoute.snapshot.params.nombre;
        this.comic.coleccion = this.activatedRoute.snapshot.params.coleccion;
        this.comic.editorial = this.activatedRoute.snapshot.params.editorial;
        this.comic.tematica = this.activatedRoute.snapshot.params.tematica;
        this.comic.color = this.activatedRoute.snapshot.params.color;
        this.comic.numeroPaginas = this.activatedRoute.snapshot.params.numeroPaginas;
        this.comic.autores = this.activatedRoute.snapshot.params.autores;
        this.comic.precio = this.activatedRoute.snapshot.params.precio;
        this.mostrarInfo();
    }

    /**
     * Metodo encargado de mostrar toda la informacion del comic
     */
    public mostrarInfo():void{
        this.gestionarComicForm.controls.nombre.setValue(this.comic.nombre);
        this.gestionarComicForm.controls.editorial.setValue(this.comic.editorial);
        this.gestionarComicForm.controls.tematica.setValue(this.comic.tematica);
        this.gestionarComicForm.controls.coleccion.setValue(this.comic.coleccion);
        this.gestionarComicForm.controls.numeroPaginas.setValue(this.comic.numeroPaginas);
        this.gestionarComicForm.controls.precio.setValue(this.comic.precio);
        this.gestionarComicForm.controls.autores.setValue(this.comic.autores);
        this.gestionarComicForm.controls.color.setValue(this.comic.color);
        this.gestionarComicForm.controls.nombre.disable();
        this.gestionarComicForm.controls.editorial.disable();
        this.gestionarComicForm.controls.tematica.disable();
        this.gestionarComicForm.controls.coleccion.disable();
        this.gestionarComicForm.controls.numeroPaginas.disable();
        this.gestionarComicForm.controls.precio.disable();
        this.gestionarComicForm.controls.autores.disable();
        this.gestionarComicForm.controls.color.disable();
    }

    /**
     * Nos permite ir a gestionar comic tras el evento click
     */
    public irAtras(): void{
        this.router.navigate(['gestionar-comic']);
    }

}