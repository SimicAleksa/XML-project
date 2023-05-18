import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { RegistrationComponent } from './components/registration/registration.component';
import { NewTrademarkFormComponent } from './components/trademark/new-trademark-form/new-trademark-form.component';
import { PendingRequestsPageComponent } from './components/trademark/pages/pending-requests-page/pending-requests-page.component';
import { TmBasicSearchPageComponent } from './components/trademark/pages/tm-basic-search-page/tm-basic-search-page.component';
import { UserProfileComponent } from './components/user-profile/user-profile.component';

const routes: Routes = [
  {path: 'registration', component: RegistrationComponent},
  {path: 'login', component: LoginComponent},
  {path: 'profile', component: UserProfileComponent},
  {path: 'trademark/new', component: NewTrademarkFormComponent},
  {path: 'trademark/pending', component: PendingRequestsPageComponent},
  {path: 'trademark/search/basic', component: TmBasicSearchPageComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
