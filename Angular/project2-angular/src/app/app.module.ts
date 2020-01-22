import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { BackgroundComponent } from './components/background/background.component';
import { LoginwordsComponent } from './components/loginwords/loginwords.component';
import { LoginpageComponent } from './components/loginpage/loginpage.component';
import { UsersearchpageComponent } from './usersearchpage/usersearchpage.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    BackgroundComponent,
    LoginwordsComponent,
    LoginpageComponent,
    UsersearchpageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
