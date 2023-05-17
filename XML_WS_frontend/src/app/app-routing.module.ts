import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { RegistrationComponent } from './components/registration/registration.component';
import { NewTrademarkFormComponent } from './components/trademark/new-trademark-form/new-trademark-form.component';
import { UserProfileComponent } from './components/user-profile/user-profile.component';
import { NewPatentFormComponent } from './components/patent/new-patent-form/new-patent-form.component';

const routes: Routes = [
  {path: 'registration', component: RegistrationComponent},
  {path: 'login', component: LoginComponent},
  {path: 'profile', component: UserProfileComponent},
  {path: 'trademark/new', component: NewTrademarkFormComponent},
  {path: 'patent/new', component: NewPatentFormComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

