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

  response: any;
  user: User; 
  submitted = false;
  simple = true;
  prefForm: FormGroup;

  constructor(
    private UserService: UserService,
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


  findUsers(){
    this.user = new User(this.usearchForm.value);
    this.preference.min_price = 0;
    console.log(this.preference);
    this.propertyService.getPropertiesByPref(this.preference).subscribe(
      data => {
        if(data != null){
            this.response = data;
            console.log('Found users');
        }
      }, error => {
          console.log('Error ', error);
        }
      )
    this.prefForm.reset();
  }


  ngOnInit() {
  }

}

