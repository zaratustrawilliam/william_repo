import { Injectable } from '@angular/core';
import { Injector } from "@angular/core";
import { Observable } from 'rxjs';
import 'rxjs/add/operator/toPromise';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AbstractService } from '../services/template.service';
import { ProveedorDTO } from '../dto/proveedor.dto';

@Injectable({
    providedIn: 'root'
  })

  /**
   * Esta clase tiene los servicios que van hacer consumidos para satisfacer LA GESTION DE LOS PROVEEDORES
   */
  export class GestionarProveedorService extends AbstractService {
       /**
         * Constructor de la clase
        */
        constructor(injector: Injector, private httpClient : HttpClient) {
            super(injector);
        }

        /**
         * metodo consultar los proveedores, retorna una lista
         */
        public consultarProveedores(): Observable<any>{
            return this.httpClient.get('http://localhost:8085/semillero-servicios/rest/GestionarProveedor/consultarProveedores');
        }
        /**
         * metodo para desactivar o activar el campo estado del proveedor
         * @param proveedorDTO objeto que contiene los valores a mod
         */
        public desactivarEstado(proveedorDTO : ProveedorDTO ):Observable<any>{
            return this.httpClient.post('http://localhost:8085/semillero-servicios/rest/GestionarProveedor/desactivar',proveedorDTO);
        }

        /**
         * metodo para modificar el parametro del monto de credito del proveedor
         * @param proveedorDTO 
         */
        public modificarProveedor(proveedorDTO : ProveedorDTO ):Observable<any>{
            return this.httpClient.post('http://localhost:8085/semillero-servicios/rest/GestionarProveedor/modificar',proveedorDTO);
        }

        /**
         * metodo para crear un nuevo proveedor
         * 
         * @param proveedorDTO 
         */
        public crearProveedor(proveedorDTO:ProveedorDTO):Observable<any>{
            return this.httpClient.post('http://localhost:8085/semillero-servicios/rest/GestionarProveedor/crear',proveedorDTO);
        }
  }