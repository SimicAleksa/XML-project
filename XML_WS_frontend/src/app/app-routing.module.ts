import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { RegistrationComponent } from './components/registration/registration.component';
import { NewTrademarkFormComponent } from './components/trademark/new-trademark-form/new-trademark-form.component';
import { PendingRequestsPageComponent } from './components/trademark/pages/pending-requests-page/pending-requests-page.component';
import { TmAdvancedSearchComponent } from './components/trademark/pages/tm-advanced-search/tm-advanced-search.component';
import { TmBasicSearchPageComponent } from './components/trademark/pages/tm-basic-search-page/tm-basic-search-page.component';
import { TmReportPageComponent } from './components/trademark/pages/tm-report-page/tm-report-page.component';
import { UserProfileComponent } from './components/user-profile/user-profile.component';
import { NewPatentFormComponent } from './components/patent/new-patent-form/new-patent-form.component';
import { PendingPatentRequestsPageComponent } from './components/patent/pages/pending-patent-requests-page/pending-patent-requests-page.component';
import { NewCopyrightFormComponent } from './components/copyright/new-copyright-form/new-copyright-form.component';
import { CopyRightRequestsPageComponent } from './components/copyright/pages/copy-right-patent-requests-page/copy-right-patent-requests-page.component';
import { CrBasicSearchPageComponent } from './components/copyright/pages/cr-basic-search-page/cr-basic-search-page.component';
import { CrAdvancedSearchComponent } from './components/copyright/pages/cr-advanced-search/cr-advanced-search.component';
import { PatentBasicSearchPageComponent } from './components/patent/pages/patent-basic-search-page/patent-basic-search-page.component';
import { PatentAdvancedSearchComponent } from './components/patent/pages/patent-advanced-search/patent-advanced-search.component';
import { XonomyEditorComponent } from './components/patent/xonomy-editor/xonomy-editor.component';
import { PatentReportComponent } from './components/patent/patent-report/patent-report.component';
import { CopyrightReportComponent } from './components/copyright/copyright-report/copyright-report.component';

const routes: Routes = [
  {path: 'registration', component: RegistrationComponent},
  {path: 'login', component: LoginComponent},
  {path: 'profile', component: UserProfileComponent},

  {path: 'patent/new', component: NewPatentFormComponent},
  {path: 'patent/pending', component: PendingPatentRequestsPageComponent},
  {path: 'patent/search/basic', component: PatentBasicSearchPageComponent},
  {path: 'patent/search/advanced', component: PatentAdvancedSearchComponent},
  {path: 'patent/xonomy', component: XonomyEditorComponent},
  {path: 'patent/report', component: PatentReportComponent},


  {path: 'copyright/new', component: NewCopyrightFormComponent},
  {path: 'copyright/pending', component: CopyRightRequestsPageComponent},
  {path: 'copyright/search/basic', component: CrBasicSearchPageComponent},
  {path: 'copyright/search/advanced', component: CrAdvancedSearchComponent},
  {path: 'copyright/report', component: CopyrightReportComponent},

  {path: 'trademark/new', component: NewTrademarkFormComponent},
  {path: 'trademark/pending', component: PendingRequestsPageComponent},
  {path: 'trademark/search/basic', component: TmBasicSearchPageComponent},
  {path: 'trademark/search/advanced', component: TmAdvancedSearchComponent},
  {path: 'trademark/report', component: TmReportPageComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

