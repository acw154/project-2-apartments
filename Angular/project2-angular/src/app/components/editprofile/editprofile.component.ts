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
      type: ['', Validators.required],
      min_price: ['', [Validators.required, Validators.min(0)]],
      max_price: ['', [Validators.required, Validators.max(50000)]],
      num_beds: ['', [Validators.required, Validators.min(0)]],
      num_baths: ['', [Validators.required, Validators.min(0)]],
      city: ['', [Validators.required, Validators.min(0)]],
      state_code: ['', [Validators.required, Validators.min(0)]],
    })
  }

  ngOnInit() {
  }

  // ========================================================================================
  registerUser(){
    // this.user = new User(this.registerForm.value);

    this.user.user_status = this.registerForm.controls.user_status.value;
    console.log(this.user);
    // register user
    this.profileService.savePreference(this.preference).subscribe(
      data => {
        if(data != null){
          console.log('Successfully created user');
          alert('User successfully created');
        } else {
          alert('Error creating user');
          this.editForm.reset();
        }
        this.router.navigateByUrl('/loginpage');
      }, error => {
        console.log('Error ', error);
        this.registerForm.reset();
      }
    );
  }

  // -------------------------------------------------------------
  savePreference(){
    this.preference = new Preference(this.editForm.value);

    this.profileService.savePreference(this.preference).subscribe(
      data => {
        if(data != null){
          console.log('Successfully created user');
          alert('User successfully created');
        } else {
          alert('Error creating user');
          this.registerForm.reset();
        }
        this.router.navigateByUrl('/loginpage');
      }, error => {
        console.log('Error ', error);
        this.registerForm.reset();
      }
    );
}
