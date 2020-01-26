import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/model/user';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';
import { SessionService } from 'src/app/services/session.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-usersearchpage',
  templateUrl: './usersearchpage.component.html',
  styleUrls: ['./usersearchpage.component.css']
})
export class UsersearchpageComponent implements OnInit {

  editForm: FormGroup;
  response: any;
  user: User; 
  submitted = false;
  simple = true;
  prefForm: FormGroup;

  constructor(
    private userService: UserService,
    private router: Router,
    private sessionService: SessionService,
    private fb: FormBuilder) {
      this.createForm();
  }
  
  createForm(){
    this.prefForm = this.fb.group({
      currant_state: ['', Validators.required],
    });
  }


  // findUsers(){
  //   this.user = new User(this.usearchForm.value);

  //   this.user.current_state;
  //   console.log(this.user);

  //   this.userService.findUsers(this.user).subscribe(
  //     data => {
  //       if(data != null){
  //           this.response = data;
  //           console.log('Found users');
  //       }
  //     }, error => {
  //         console.log('Error ', error);
  //       }
  //     )
  //   this.usearchForm.reset();
  // }

 



  ngOnInit() {
  }

}

