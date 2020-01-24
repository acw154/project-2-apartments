import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { LoginService } from '../../services/login.service';
import { Observable } from 'rxjs';
import { User } from '../../model/user';
import { stringify } from 'querystring';
import { ProfileService } from 'src/app/services/profile.service';
import { UserService } from '../../services/user.service';
import { LoginTemplate } from 'src/app/model/login-template';
import { SessionService } from 'src/app/services/session.service';

@Component({
  selector: 'app-loginpage',
  templateUrl: './loginpage.component.html',
  styleUrls: ['./loginpage.component.css']
})
export class LoginpageComponent implements OnInit {
  loginT: LoginTemplate;
  submitted=false;
  

  constructor(
      private loginService: LoginService,
      private router: Router,
      private userService: UserService,
      private sessionService: SessionService,
      //private profileService: ProfileService,
  ) { 
    this.loginT = new LoginTemplate();
  }

  ngOnInit() {
  }

  onSubmit() {
    
    this.submitted = true;
    console.log(this.submitted);
    console.log(this.loginT);
    this.loginService.login(this.loginT).subscribe(
      data => {
        if(data != null){
          this.sessionService.saveCurrentUser(data);
          // save preference 
        } else {
          alert("Invalid Credentials");
          
        }
         // Saved the user as current User 
        // Send the user value to some other service and save it as currentUser object
        // ex: this.profileService.setCurrentUser()
        // this.router.navigate([]) Navigate to profile of currentUser
      }, error => {
        alert("Error submitting login");
      }
    );
    if(this.sessionService.getCurrentUser() != null){
      this.userService.getUserPreference(this.sessionService.getCurrentUser()).subscribe(
        data => {
          if(data != null){
            this.sessionService.savePreference(data);
          } else {
            this.sessionService.savePreference(null); 
          }
        }, error => {
          alert("Error grabbing preference");
        }
      );
      this.router.navigate(['/profile']);
    }

  }
}
