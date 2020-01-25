import { Component, OnInit, createPlatformFactory } from '@angular/core';
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
import { Preference } from 'src/app/model/preference';

@Component({
  selector: 'app-loginpage',
  templateUrl: './loginpage.component.html',
  styleUrls: ['./loginpage.component.css']
})
export class LoginpageComponent implements OnInit {
  loginT: FormGroup;
  submitted=false;
  user: User;
  

  constructor(
      private loginService: LoginService,
      private router: Router,
      private userService: UserService,
      private sessionService: SessionService,
      private fb: FormBuilder,
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
      data => {
        if(data != null){
          this.user = new User(data);
          this.sessionService.saveCurrentUser(this.user);
          console.log(this.user);
          //console.log(this.sessionService.getCurrentUser().user_status);
          // this.userService.getUserPreference(data).subscribe(
          //   data => {
          //     if (data != null) {
          //       this.sessionService.storePreference(data);
          //     } else {
          //       console.log('User does not have a preference');
          //     }
          //   }, error => {
          //     console.log('Error ', error);
          //   }
          // );
          // save preference 
        } else {
          alert("Invalid Credentials");
          
        }
      }, error => {
        console.log("Error", error);
      });
    }
  }
    
         // Saved the user as current User 
        // Send the user value to some other service and save it as currentUser object
        // ex: this.profileService.setCurrentUser()
        // this.router.navigate([]) Navigate to profile of currentUser
  //     }, error => {
  //       alert("Error submitting login");
  //     }
  //   );
  //   console.log(this.submitted);
  //   console.log(this.loginT);
  // }

