import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule} from '@angular/http';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { APP_BASE_HREF } from '@angular/common';
import { GestionarComicComponent } from './semillero/componentes/gestionarComic/gestionar-comic';
import { MenuComponent } from './semillero/componentes/menu/menu-component';
import { BienvenidaComponent } from './semillero/componentes/home/bienvenida-component';
import { InfoPersonalComponent } from './semillero/componentes/agregarInfoPersonal/agregarInfoPersonal-component'
import { EjercicioClase2 } from './semillero/componentes/ejercicioClase2/ejercicioClase2-component'

// DTOs
export { ComicDTO } from './semillero/dto/comic.dto';
export { ResultadoDTO } from './semillero/dto/resultado.dto';
export { Ejercicio2DTO} from './semillero/dto_propia/ejercicio2.dto'

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    BienvenidaComponent,
    GestionarComicComponent,
    InfoPersonalComponent,
    EjercicioClase2
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpModule,
    HttpClientModule,
    FormsModule
    
  ],
  providers: [
  	{ provide: APP_BASE_HREF, useValue: '/SemilleroHBT' }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { 

}
