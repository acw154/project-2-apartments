import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SessionService } from 'src/app/services/session.service';


@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  constructor(private sessionService: SessionService, private router: Router){ }

  ngOnInit() {}
  

  logout(){
    console.log(this.sessionService.getCurrentUser());
    if(this.sessionService.getCurrentUser() != null){
      this.sessionService.invalidateSession();
      alert("You have logged out");
      console.log(this.sessionService.getCurrentUser());
      
    } else {
      alert("You were not logged in");
    }
    return this.router.navigateByUrl('/loginpage');
  }

  toProfile(){
    if(this.sessionService.getCurrentUser() != null){
      console.log("Moving to user profile");
      //Something about profile service
      return this.router.navigateByUrl('/profile');
    } else {
      alert('You are not logged in');
      return this.router.navigateByUrl('/loginpage');
    }
  }
  
  toSearch(){
    // if(this.sessionService.getCurrentUser() != null){
    //   console.log("Moving to rental search");
    //   //Something about profile service
    //   return this.router.navigateByUrl('/rentalsearch');
    // } else {
    //   alert('You are not logged in');
    //   return this.router.navigateByUrl('/loginpage');
    // }
    return this.router.navigateByUrl('/rentalsearch');
  }

  toRegister(){
    if(this.sessionService.getCurrentUser() == null){
      console.log('Moving to Register Page');
      return this.router.navigateByUrl('/register');
    } else {
      alert('You are currently logged in as ' + this.sessionService.getCurrentUser() + ". Please logout to register");
    }
  }

  toLogin(){
    if(this.sessionService.getCurrentUser() == null){
      console.log('Moving to Login Page');
      return this.router.navigateByUrl('/loginpage');
    } else {
      alert('You are currently logged in as ' + this.sessionService.getCurrentUser() + ". Please logout to change user");
    }
  }

  toPropCreate(){
    // if(this.sessionService.getCurrentUser() != null){
    //   console.log('Moving to CreateProp page');
    //   return this.router.navigateByUrl('/propcreate');
    // } else {
    //   alert('You are not logged in');
    //   return this.router.navigateByUrl('/loginpage');
    // }
    this.router.navigateByUrl('/propcreate');
  }


  
}

