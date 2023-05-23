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
import { XMLParser } from './utils/XMLParser';
import { LocalStorageManager } from './utils/LocalStorageManager';
import { MenuComponent } from './components/menu/menu.component';
import { UserProfileComponent } from './components/user-profile/user-profile.component';
import { NewTrademarkFormComponent } from './components/trademark/new-trademark-form/new-trademark-form.component';
import { TrademarkListComponent } from './components/trademark/trademark-list/trademark-list.component';
import { PendingRequestsPageComponent } from './components/trademark/pages/pending-requests-page/pending-requests-page.component';
import { DeclineReqDialogComponent } from './components/trademark/decline-req-dialog/decline-req-dialog.component';
import { TmBasicSearchPageComponent } from './components/trademark/pages/tm-basic-search-page/tm-basic-search-page.component';
import { TmAdvancedSearchComponent } from './components/trademark/pages/tm-advanced-search/tm-advanced-search.component';
import { MAT_DATE_LOCALE } from '@angular/material/core';
import { NewPatentFormComponent } from './components/patent/new-patent-form/new-patent-form.component';
import { PendingPatentRequestsPageComponent } from './components/patent/pages/pending-patent-requests-page/pending-patent-requests-page.component';
import { PatentListComponent } from './components/patent/pages/patent-list/patent-list.component';



@NgModule({
  declarations: [
    AppComponent,
    RegistrationComponent,
    LoginComponent,
    MenuComponent,
    UserProfileComponent,
    NewTrademarkFormComponent,
    NewPatentFormComponent,
    TrademarkListComponent,
    PendingRequestsPageComponent,
    DeclineReqDialogComponent,
    TmBasicSearchPageComponent,
    TmAdvancedSearchComponent,
    PendingPatentRequestsPageComponent,
    PatentListComponent
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
    { provide: MAT_DATE_LOCALE, useValue: 'en-GB' },
    RequestMaker,
    XMLParser,
    LocalStorageManager
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
