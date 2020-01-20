import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginpageComponent } from './components/loginpage/loginpage.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { FooterComponent } from './components/footer/footer.component';
import { ProfileComponent } from './components/profile/profile.component';
import { LogoutComponent } from './components/logout/logout.component';
import { RentalsearchComponent } from './components/rentalsearch/rentalsearch.component';
import { RegisterComponent } from './components/register/register.component';


const routes: Routes = [
  { path: 'loginpage', component: LoginpageComponent },
  { path: 'navbar', component: NavbarComponent },
  { path: 'footer', component: FooterComponent },
  { path: 'profile', component: ProfileComponent },
  { path: 'logout', component: LogoutComponent },
  { path: 'rentalsearch', component: RentalsearchComponent },
  { path: 'register', component: RegisterComponent },
  { path: '', component: LoginpageComponent },
  { path: '**', redirectTo: 'loginpage', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents = [RentalsearchComponent, RegisterComponent];