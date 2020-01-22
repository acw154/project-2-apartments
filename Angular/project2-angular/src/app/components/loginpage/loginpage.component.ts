import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { LoginService } from '../../services/login.service';
import { Observable } from 'rxjs';
import { User } from '../../model/user';
import { stringify } from 'querystring';

@Component({
  selector: 'app-loginpage',
  templateUrl: './loginpage.component.html',
  styleUrls: ['./loginpage.component.css']
})
export class LoginpageComponent implements OnInit {
  loginForm: FormGroup;
  user: Observable<User>;
  submitted=false;
  

  constructor(
      private formBuilder: FormBuilder,
      private loginService: LoginService,
      private router: Router,
      //private profileService: ProfileService,
  ) { }

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      email: 'email',
      password: 'password',
    });
  }

  get f() { return this.loginForm.controls; }

  onSubmit() {
    this.submitted = true;
    this.loginService.login(this.loginForm.value).subscribe(
      data => {
        // Send the user value to some other service and save it as currentUser object
        // ex: this.profileService.setCurrentUser()
        // this.router.navigate([]) Navigate to profile of currentUser
      }
    );
  }
}
