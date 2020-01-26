import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/model/user';
import { FormBuilder } from '@angular/forms';
import { UserService } from 'src/app/services/user.service';
import { Session } from 'protractor';
import { SessionService } from 'src/app/services/session.service';
import { Preference } from 'src/app/model/preference';
import { Property } from 'src/app/model/property';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  currentUser: User;
  // searchedUser: User;
  savedProperty: Property;

  currentUserPref: Preference;
  // searchedUserPref: Preference;

  // preferences

  saved ="sdfsdfsdfs";


  constructor(
    private formBuilder: FormBuilder,
    private userService: UserService,
    private sessionService: SessionService,
  ) { 
    this.currentUser = this.sessionService.getCurrentUser();
  }




  ngOnInit() { 
  }

}
