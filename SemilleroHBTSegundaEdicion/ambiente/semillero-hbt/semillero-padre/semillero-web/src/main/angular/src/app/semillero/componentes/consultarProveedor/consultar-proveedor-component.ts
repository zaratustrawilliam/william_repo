import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { ProveedorDTO } from '../../dto/proveedor.dto';

@Component({
    selector: 'consultar-proveedor',
    templateUrl: './consultar-proveedor-component.html'
})

export class ConsultarProveedorComponent implements OnInit{
   
   
    constructor( private router : Router, private activatedRoute: ActivatedRoute) { 
    }

    public proveedorDTO : ProveedorDTO;
   
    ngOnInit(): void {
        this.proveedorDTO = new ProveedorDTO();
        this.proveedorDTO.id = this.activatedRoute.snapshot.params.id;
        this.proveedorDTO.direccion = this.activatedRoute.snapshot.params.direccion;
        this.proveedorDTO.estadoProveedor = this.activatedRoute.snapshot.params.estadoProveedor;
        this.proveedorDTO.fechaContratacion = this.activatedRoute.snapshot.params.fechaContratacion;
        this.proveedorDTO.idPersona = this.activatedRoute.snapshot.params.idPersona;
        this.proveedorDTO.ValorCredito = this.activatedRoute.snapshot.params.ValorCredito;
    }

    /**
     * Nos permite ir a gestionar proveedor tras el evento click
     */
    public irAtras(): void{
        this.router.navigate(['gestionar-proveedor']);
    }


}