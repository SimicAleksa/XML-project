import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { RegistrationComponent } from './components/registration/registration.component';
import { NewTrademarkFormComponent } from './components/trademark/new-trademark-form/new-trademark-form.component';
import { PendingRequestsPageComponent } from './components/trademark/pages/pending-requests-page/pending-requests-page.component';
import { TmAdvancedSearchComponent } from './components/trademark/pages/tm-advanced-search/tm-advanced-search.component';
import { TmBasicSearchPageComponent } from './components/trademark/pages/tm-basic-search-page/tm-basic-search-page.component';
import { UserProfileComponent } from './components/user-profile/user-profile.component';
import { NewPatentFormComponent } from './components/patent/new-patent-form/new-patent-form.component';

const routes: Routes = [
  {path: 'registration', component: RegistrationComponent},
  {path: 'login', component: LoginComponent},
  {path: 'profile', component: UserProfileComponent},
  {path: 'trademark/new', component: NewTrademarkFormComponent},
  {path: 'patent/new', component: NewPatentFormComponent},
  {path: 'trademark/pending', component: PendingRequestsPageComponent},
  {path: 'trademark/search/basic', component: TmBasicSearchPageComponent},
  {path: 'trademark/search/advanced', component: TmAdvancedSearchComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

