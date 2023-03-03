import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { CommonModule } from '@angular/common';  
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialsModule } from './materials/materials.module';
import { RegistrationComponent } from './components/registration/registration.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RequestMaker } from 'src/app/services/request-maker.service';
import { LoginComponent } from './components/login/login.component';
import { TrademarkFormComponent } from './components/trademark-form/trademark-form.component';
import { XMLParser } from './utils/XMLParser';
import { LocalStorageManager } from './utils/LocalStorageManager';
import { MenuComponent } from './components/menu/menu.component';
import { MenuService } from './components/menu/service/menu-service';


@NgModule({
  declarations: [
    AppComponent,
    RegistrationComponent,
    LoginComponent,
    TrademarkFormComponent,
    MenuComponent
  ],
  imports: [
    NgbModule,
    CommonModule,
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MaterialsModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [
    RequestMaker, 
    XMLParser, 
    LocalStorageManager
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
