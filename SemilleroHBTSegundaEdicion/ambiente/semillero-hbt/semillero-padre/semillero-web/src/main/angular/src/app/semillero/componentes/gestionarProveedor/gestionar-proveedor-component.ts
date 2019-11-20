import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { GestionarProveedorService } from '../../services/gestionar.proveedor.service';
import { ProveedorDTO } from '../../dto/proveedor.dto';
import { error } from '@angular/compiler/src/util';

@Component({
    selector: 'gestionar-proveedor-component',
    templateUrl: './gestionar-proveedor-component.html'
})
/**
 * Clase que nos permite gestionar a los proveedores
 */
export class GestionarProveedorComponent implements OnInit{

    public gestionarProveedorForm : FormGroup;

    public listaProveedores : Array<ProveedorDTO>;

    public proveedorDTO : ProveedorDTO ;

    /**
     * Constructor
     * @param fb 
     * @param router 
     * @param gestionarProveedorService 
     */
    constructor(private fb: FormBuilder,
        private router: Router, private gestionarProveedorService : GestionarProveedorService){
            this.gestionarProveedorForm = this.fb.group({
                id : [null],
                direccion : [null],
                estado : [null],
                fechaCreacion : [null],
                idPersona : [null],
                montoCredito : [null] });
        }

    ngOnInit(): void {
        this.listaProveedores = new Array<ProveedorDTO>();
    }
    /**
     * metodo encargado de traer los proveedores 
     */
    public consultarProveedores():void{
        this.gestionarProveedorService.consultarProveedores().subscribe(resultado =>{
            this.listaProveedores = resultado;
        },error =>{
            console.log(error);
        });
    }
    /**
     * Metodo encargado de modificar el parametro estado de proveedor
     */
    public modificarEstado():void{
        this.proveedorDTO = new ProveedorDTO();
        this.proveedorDTO.id = this.gestionarProveedorForm.controls.id.value;
        this.gestionarProveedorForm.controls.estado.value === "ACTIVO" ?
        this.proveedorDTO.estadoProveedor = "INACTIVO" :  this.proveedorDTO.estadoProveedor = "ACTIVO" ;

        this.gestionarProveedorService.desactivarEstado(this.proveedorDTO).subscribe( res =>{
            this.consultarProveedores();
            this.limpiar();
        },error =>{
            console.log(error);
        });
    }
    /**
     * metodo encargado de modificar em monto credito del proveedor
     */
    public modificarMontoCredito():void{
        this.proveedorDTO = new ProveedorDTO();
        this.proveedorDTO.id = this.gestionarProveedorForm.controls.id.value;
        this.proveedorDTO.ValorCredito = this.gestionarProveedorForm.controls.montoCredito.value;

        this.gestionarProveedorService.modificarProveedor(this.proveedorDTO).subscribe( res =>{
            this.consultarProveedores();
            this.limpiar();
        },error =>{
            console.log(error);
        });
    }
    /**
     * Metodo que ubica la informacion del proveedor en la pantalla para syu respectiva modificacion
     * @param pos 
     */
    public editarProveedor(pos : number): void{
        this.gestionarProveedorForm.controls.id.setValue(this.listaProveedores[pos].id);
        this.gestionarProveedorForm.controls.idPersona.setValue(this.listaProveedores[pos].idPersona);
        this.gestionarProveedorForm.controls.montoCredito.setValue(this.listaProveedores[pos].ValorCredito);
        this.gestionarProveedorForm.controls.estado.setValue(this.listaProveedores[pos].estadoProveedor);
        this.gestionarProveedorForm.controls.direccion.setValue(this.listaProveedores[pos].direccion);
        this.gestionarProveedorForm.controls.fechaContratacion.setValue(this.listaProveedores[pos].fechaContratacion);
    }
    
    /**
     * metodo para modificar el estado del proveedor
     * @param pos 
     */
    public eliminarProveedor(pos:number){
        this.modificarEstado();
       this.listaProveedores[pos].estadoProveedor === "INACTIVO" ?  
       this.listaProveedores[pos].estadoProveedor = "ACTIVO" :  
       this.listaProveedores[pos].estadoProveedor = "INACTIVO" ;
    }
    /**
     * Metodo encargado de enviar bjetos del tipo dto
     */
    public crearProveedor():void{
        this.proveedorDTO = new ProveedorDTO();
        this.proveedorDTO.id = this.listaProveedores.length + 1;
        this.proveedorDTO.direccion = this.gestionarProveedorForm.controls.direccion.value;
        this.proveedorDTO.fechaContratacion = this.gestionarProveedorForm.controls.fechaContratacion.value;
        this.proveedorDTO.idPersona = this.gestionarProveedorForm.controls.idPersona.value;
        this.proveedorDTO.ValorCredito = 20000;
        this.proveedorDTO.estadoProveedor = this.gestionarProveedorForm.controls.estado.value;

        this.gestionarProveedorService.crearProveedor(this.proveedorDTO).subscribe( res =>{
            this.consultarProveedores();
            this.listaProveedores.push(this.proveedorDTO);
            this.limpiar();
        },error =>{
            console.log(error);
        });
    }

    public limpiar():void{
        this.gestionarProveedorForm.controls.id.setValue(null);
        this.gestionarProveedorForm.controls.idPersona.setValue(null);
        this.gestionarProveedorForm.controls.montoCredito.setValue(null);
        this.gestionarProveedorForm.controls.estado.setValue(null);
        this.gestionarProveedorForm.controls.direccion.setValue(null);
        this.gestionarProveedorForm.controls.fechaContratacion.setValue(null);
    }

    /**
     * metodo que permite desplegar la info del proveedor en otra pantalla
     * @param posicion 
     */
    public consultarProveedor(posicion: number): void {
        let proveedor = this.listaProveedores[posicion];
        this.router.navigate(['consultar-proveedor',proveedor]);
    }
}