import { Component, OnInit, createPlatformFactory } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from '../../services/login.service';
import { User } from '../../model/user';
import { UserService } from '../../services/user.service';
import { SessionService } from 'src/app/services/session.service';
import { Preference } from 'src/app/model/preference';
import { ProfileService } from '../../services/profile.service';

@Component({
  selector: 'app-loginpage',
  templateUrl: './loginpage.component.html',
  styleUrls: ['./loginpage.component.css']
})
export class LoginpageComponent implements OnInit {
  loginT: FormGroup;
  submitted=false;
  user: User;
  preference: Preference;
  

  constructor(
      private loginService: LoginService,
      private router: Router,
      private userService: UserService,
      private sessionService: SessionService,
      private fb: FormBuilder,
      private profileService: ProfileService,
      //private profileService: ProfileService,
  ) { 
    this.createForm();
  }

  createForm(){
    this.loginT = this.fb.group({
      email: ['', Validators.required],
      password: ['', Validators.required]
    })
  }

  ngOnInit() {
  }

  onSubmit() {
    this.submitted = true;
    console.log(this.submitted);
    console.log(this.loginT);
    this.loginService.login(this.loginT.value).subscribe(
      async data => {
        if(data != null){
          this.user = new User(data);
          this.sessionService.saveCurrentUser(this.user);
          console.log(this.user);
          this.checkPref();
          this.checkProps();
          while(this.sessionService.getSavedProperties() == undefined){

          }
          this.router.navigateByUrl('/profile');
        } else {
          alert("Invalid Credentials");
          
        }
      }, error => {
        alert('Invalid Credentials');
        console.log("Error", error);
      });
      
    }


    async checkPref(){
      if(this.sessionService.getCurrentUser() != null){
        this.userService.getUserPreference(this.sessionService.getCurrentUser()).subscribe(
          data => {
            if(data != null){
              this.preference = data;
              this.sessionService.storePreference(this.preference);
              console.log(this.preference);
            } else {
              console.log('User does not have a preference');
              this.sessionService.storePreference(null);
            }
          }, error => {
            console.log('Error ', error);
          }
        );

        
      }
    }

    async checkProps(){
      let u = this.sessionService.getCurrentUser();
      if(u != null){
        this.profileService.getSavedProperties(u).subscribe(
          data => {
            if(data != null){
              this.sessionService.storeSavedProperties(data);
              console.log('Got saved properties');
            } else {
              console.log('No properties');
              this.sessionService.storeSavedProperties(null);
            }
          }, error => {
            console.log('Error ', error);
          }
        )
      }
    }
  

  delay(ms: number) {
    return new Promise( resolve => setTimeout(resolve, ms) );
  }
}
    
    
        