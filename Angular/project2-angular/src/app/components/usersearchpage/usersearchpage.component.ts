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
      current_state: ['',[Validators.required, Validators.minLength(2), Validators.maxLength(2)]],
    });
  }


  findUsersByState(){
    this.state = this.usearchForm.controls.current_state.value;
    console.log(this.state);
    this.state = this.state.toUpperCase();
    this.userService.findByState(this.state).subscribe(
      data => {
        if(data != null){
            this.response = data;
            console.log('Found users');
            console.log(this.response);
        } 
      }, error => {
          console.log('Error ', error);
        }
      )
  }


  ngOnInit() {
  }

}
