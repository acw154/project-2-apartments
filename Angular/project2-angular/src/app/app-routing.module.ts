import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginpageComponent } from './components/loginpage/loginpage.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { RentalsearchComponent } from './components/rentalsearch/rentalsearch.component';
import { RegisterComponent } from './components/register/register.component';
import { ProfileComponent } from './components/profile/profile.component';
import { IndividualPropertyPageComponent } from './components/individual-property-page/individual-property-page.component';
import { EditprofileComponent } from './components/editprofile/editprofile.component';
import { CreatepropComponent } from './components/createprop/createprop.component';
import { UsersearchpageComponent } from './components/usersearchpage/usersearchpage.component';


const routes: Routes = [
  { path: 'loginpage', component: LoginpageComponent },
  { path: 'navbar', component: NavbarComponent },
  { path: 'profile', component: ProfileComponent },
  { path: 'rentalsearch', component: RentalsearchComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'usersearchpage', component: UsersearchpageComponent },
  { path: 'editprofile', component: EditprofileComponent },
  { path: '', component: LoginpageComponent },
  { path: 'individualpropertypage', component: IndividualPropertyPageComponent },
  { path: 'propcreate', component: CreatepropComponent },
  { path: '**', redirectTo: 'loginpage', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

// export const routingComponents = [RentalsearchComponent, RegisterComponent];
