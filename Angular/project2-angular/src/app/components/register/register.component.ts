import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/model/user';
import { SessionService } from 'src/app/services/session.service';
import { UserService } from 'src/app/services/user.service';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Status } from 'src/app/model/status';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  private user: User;
  private registerForm: FormGroup;
  allStatus = [
    new Status(3, "not looking"),
    new Status(1, "searching for roommate"),
    new Status(2, "searching for room"),
  ];

  constructor(private sessionService: SessionService,
    private userService: UserService,
    private router: Router,

    private fb: FormBuilder,) {
      this.createForm();
  }

  createForm(){
    this.registerForm = this.fb.group({
      email: ['', Validators.required],
      password: ['', Validators.required],
      f_name: ['', Validators.required],
      l_name: ['', Validators.required],
      current_state: ['', [Validators.required, Validators.minLength(2), Validators.maxLength(2)]],
      user_status: ['', Validators.required]
    })
  }

  ngOnInit() {
  }

  registerUser(){
    this.user = new User(this.registerForm.value);
    this.user.user_status = this.registerForm.controls.user_status.value;
    this.user.current_state = this.user.current_state.toUpperCase();
    this.user.id = 0;
    console.log(this.user);
    // register user
    this.userService.saveUser(this.user).subscribe(
      data => {
        if(data != null){
          console.log('Successfully created user');
          alert('User successfully created');
        } else {
          alert('Error creating user');
          this.registerForm.reset();
        }
        this.router.navigateByUrl('/loginpage');
      }, error => {
        console.log('Error ', error);
        this.registerForm.reset();
      }
    );
  }
}
