import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Preference } from 'src/app/model/preference';
import { Router } from '@angular/router';
import { ProfileService } from 'src/app/services/profile.service';
import { SessionService } from 'src/app/services/session.service';

@Component({
  selector: 'app-editprofile',
  templateUrl: './editprofile.component.html',
  styleUrls: ['./editprofile.component.css']
})
export class EditprofileComponent implements OnInit {

  preference: Preference;
  editForm: FormGroup;


  constructor(
    private sessionService: SessionService, //?
    private profileService: ProfileService,
    private router: Router,
    private fb: FormBuilder,) {
      this.createForm();
  }

  
  createForm(){
    this.editForm = this.fb.group({
      minPrice: ['', [Validators.required, Validators.min(0)]],
      maxPrice: ['', [Validators.required, Validators.max(50000)]],
      numBeds: ['', [Validators.required, Validators.min(0)]],
      numBaths: ['', [Validators.required, Validators.min(0)]],
      city: ['', [Validators.required]],
      state_code: ['', [Validators.required]],
    })
  }

  ngOnInit() {
  }

 
  editUser(){
    this.preference = new Preference(this.editForm.value);
    this.preference.email = this.sessionService.getCurrentUser().email;
    console.log(this.preference);

    this.profileService.savePreference(this.preference).subscribe(
      data => {
        if(data != null){
          console.log('Successfully changed preferences');
          this.sessionService.storePreference(data);
          alert('Successfylly changed preferences');
        } else {
          alert('Error editing preference');
          this.editForm.reset();
        }
        this.router.navigateByUrl('/profile');
      }, error => {
        alert('hitting error')
        console.log('Error ', error);
        this.editForm.reset();
      }
    );
}
}

