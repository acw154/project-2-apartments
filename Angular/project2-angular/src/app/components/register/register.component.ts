import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/model/user';
import { SessionService } from 'src/app/services/session.service';
import { UserService } from 'src/app/services/user.service';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  private user: User;
  private registerForm: FormGroup;
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
      
    })
  }

  ngOnInit() {
  }

}
