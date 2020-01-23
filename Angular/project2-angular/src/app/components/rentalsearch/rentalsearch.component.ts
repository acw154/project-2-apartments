import { Component, OnInit } from '@angular/core';
import { PropertyService } from 'src/app/services/property.service';
import { Preference } from 'src/app/model/preference';
import { Router } from '@angular/router';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-rentalsearch',
  templateUrl: './rentalsearch.component.html',
  styleUrls: ['./rentalsearch.component.css']
})
export class RentalsearchComponent implements OnInit {
  response: any;
  //readonly APP_URL = 'http://localhost:8080/RevatureRealocator'; //not sure if this is right
  preference: Preference;
  submitted = false;
  simple = true;
  prefForm: FormGroup;

  constructor(private propertyService: PropertyService,
    private router: Router,
    private fb: FormBuilder) {
      this.createForm();
  }
  
  createForm(){
    this.prefForm = this.fb.group({
      city: ['', Validators.required],
      state_code: ['', Validators.required],
      max_price: ['', ],
      num_beds: ['', ],
      num_baths: ['', ],
    });
  }

  ngOnInit() {  
  }

  doSearch(){
    this.preference = new Preference(this.prefForm.value);
    this.preference.min_price = 0;
    console.log(this.preference);
    if(this.preference.max_price == null && this.preference.num_baths == null && this.preference.num_beds == null){
      this.propertyService.getPropertiesSimple(this.preference).subscribe(
        data => {
          if(data != null) {
            this.response = data;
          }
        }, error => {
          console.log('Error', error);
        }
      )
    } else {
      this.propertyService.getPropertiesByPref(this.preference).subscribe(
        data => {
          if(data != null){
            this.response = data;
          }
        }, error => {
          console.log('Error', error);
        }
      )
    }
    // this.propertyService.getPropertiesByPref(this.preference).subscribe(
    //   data => {
    //     if(data != null) {
    //       this.response = data;
    //       // Either have properties hide until search is clicked using ngIf or have some update button
    //     }
    //   },
    //   error => {
    //     console.log('Error', error);
    //   }
    // );
  }

}
