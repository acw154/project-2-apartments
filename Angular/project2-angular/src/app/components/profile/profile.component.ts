import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/model/user';
import { FormBuilder } from '@angular/forms';
import { UserService } from 'src/app/services/user.service';
import { Session } from 'protractor';
import { SessionService } from 'src/app/services/session.service';
import { Preference } from 'src/app/model/preference';
import { Property } from 'src/app/model/property';
import { ProfileService } from 'src/app/services/profile.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  currentUser: User;
  currentUserPref: Preference;
  currentUserProperties: Property[];
  // preferences

// toggle
isShow = false;
 
toggleDisplay() {
  this.isShow = !this.isShow;
}
// end
  
  constructor(
    private formBuilder: FormBuilder,
    private userService: UserService,
    private sessionService: SessionService,
    private profileService: ProfileService,
  ) { 
    this.currentUser = this.sessionService.getCurrentUser();
    this.currentUserPref = this.sessionService.getStoredPreference();
    this.profileService.getSavedProperties(this.currentUser).subscribe(
      data => {
        if(data != null){
          this.currentUserProperties = data;
          console.log(this.currentUserProperties);
        } else {
          this.currentUserProperties = null;
        }
      }, error => {
        console.log('Error ', error);
      }
      );   

  }

  // display on button click
  // isShow = false;
 
  // toggleDisplay() {
  //   this.isShow = !this.isShow;
  // }

  ngOnInit() { 
  }

}
