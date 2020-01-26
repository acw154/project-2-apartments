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
  state: string;
  response: any;
  submitted = false;
  simple = true;
  usearchForm: FormGroup;
  // --------------------

	
	// f_name ="sdfsdfsdfs";
	// l_name = "sdfsdfsdfs";
	// email = "sdfsdfsdfs";
	// password = "sdfsdfsdfs";
	// user_status = "sdfsdfsdfs";
	// current_state = "sdfsdfsdfs";
  // --------------------

  constructor(
    private userService: UserService,
    private router: Router,
    private sessionService: SessionService,
    private fb: FormBuilder) {
      this.createForm();
  }
  
  createForm(){
    this.usearchForm = this.fb.group({
      f_name: ['', Validators.required],
      l_name: ['', Validators.required],
      email: ['', Validators.required],
      user_status: ['', Validators.required],
      current_state: ['', Validators.required],
    });
  }


  findUsersByState(){
    this.state = this.usearchForm.value.toUpperCase();
    this.userService.findByState(this.state).subscribe(
      data => {
        if(data != null){
            this.response = data;
            console.log('Found users');
        }
      }, error => {
          console.log('Error ', error);
        }
      )
    this.usearchForm.reset();
  }


  ngOnInit() {
  }

}
