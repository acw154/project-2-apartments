import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/model/user';
import { FormBuilder } from '@angular/forms';
import { UserService } from 'src/app/services/user.service';
import { SessionService } from 'src/app/services/session.service';
import { Preference } from 'src/app/model/preference';
import { Property } from 'src/app/model/property';
import { ProfileService } from 'src/app/services/profile.service';
import { PropertyService } from 'src/app/services/property.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  currentUser: User;
  // searchedUser: User;
  savedProperties: Property[];

  currentUserPref: Preference;

  showSaved: boolean;
  showPref: boolean;
  // searchedUserPref: Preference;

  // preferences

  //saved ="sdfsdfsdfs";


  constructor(
    private formBuilder: FormBuilder,
    private userService: UserService,
    private sessionService: SessionService,
    private profileService: ProfileService,
    private propertyService: PropertyService,
    private router: Router,
  ) { 
    this.currentUser = this.sessionService.getCurrentUser();
    this.currentUserPref = this.sessionService.getStoredPreference();
    this.savedProperties = this.sessionService.getSavedProperties();
    if(this.savedProperties.length == 0){
      this.showSaved = false;
    } else {
      this.showSaved = true;
    }
    if(this.currentUserPref == null){
      this.showPref = false;
    } else {
      this.showPref = true;
    }
    console.log(this.currentUserPref);
    console.log(this.showPref);
  }

  goToIndividualPropertyPage(property: Property){
    this.propertyService.openPropertyPage(property);
     //Saves property within propertyservice so that individual property page can pull that information
    this.router.navigateByUrl('/individualpropertypage');
  }



  ngOnInit() { 
  }

}
