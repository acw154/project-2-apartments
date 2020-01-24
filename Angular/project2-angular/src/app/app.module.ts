import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { BackgroundComponent } from './components/background/background.component';
import { LoginwordsComponent } from './components/loginwords/loginwords.component';
import { LoginpageComponent } from './components/loginpage/loginpage.component';
import { RentalsearchComponent } from './components/rentalsearch/rentalsearch.component';
import { Background2Component } from './components/background2/background2.component';
import { RegisterComponent } from './components/register/register.component';
import { UsersearchpageComponent } from './components/usersearchpage/usersearchpage.component';
import { IndividualPropertyPageComponent } from './components/individual-property-page/individual-property-page.component';
import { ProfileComponent } from './components/profile/profile.component';
import { CreatepropComponent } from './components/createprop/createprop.component';




@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    BackgroundComponent,
    LoginwordsComponent,
    LoginpageComponent,
    RentalsearchComponent,
    Background2Component,
    ProfileComponent,
    RegisterComponent,
    UsersearchpageComponent,
    IndividualPropertyPageComponent,
    CreatepropComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
