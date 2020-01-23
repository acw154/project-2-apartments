import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/model/user';
import { FormBuilder } from '@angular/forms';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  currentUser: User;
  searchedUser: User;

  
  constructor(
    private formBuilder: FormBuilder,
    private userService: UserService,
  ) { 
    this.currentUser = this.userService.getCurrentUser();
  }

  ngOnInit() { 
  }

}
