import { Component, OnInit } from '@angular/core';
import { PropertyService } from 'src/app/services/property.service';
import { Router } from '@angular/router';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { SessionService } from 'src/app/services/session.service';
import { Property } from 'src/app/model/property';
import { Type } from 'src/app/model/type';

@Component({
  selector: 'app-createprop',
  templateUrl: './createprop.component.html',
  styleUrls: ['./createprop.component.css']
})
export class CreatepropComponent implements OnInit {
  property: Property;
  propcreateForm: FormGroup;
  allTypes = [
    new Type(1, "Single Family"),
    new Type(2, "Apartment"),
    new Type(3, "Condo"),
    new Type(4, "Town Home")
  ];

  

  constructor(private propertyService: PropertyService,
    private router: Router,
    private fb: FormBuilder,
    ) {
      this.createForm();
    }

  ngOnInit() {
  }

  createForm(){
    this.propcreateForm = this.fb.group({
      type: ['', Validators.required],
      street_num: ['', [Validators.required, Validators.min(0)]],
      street: ['', [Validators.required, Validators.min(0)]],
      apt_num: ['', Validators.min(0)],
      city: ['', [Validators.required, Validators.min(0)]],
      state: ['', Validators.required],
      zip: ['', [Validators.required, Validators.min(0)]],
      num_beds: ['', [Validators.required, Validators.min(0)]],
      num_baths: ['', [Validators.required, Validators.min(0)]],
      price: ['', [Validators.required, Validators.min(0)]],
      photo: ['', Validators.required],
      sq_ft: ['', [Validators.required, Validators.min(0)]],
    });
  }

  createProp(){
    this.property = new Property(this.propcreateForm.value);
    this.property.type = this.propcreateForm.controls.type.value[0];
    this.property.revemp_owned = true;
    console.log(this.property);
    this.propertyService.insertProperty(this.property).subscribe(
      data => {
        if(data === true) {
          alert('Property created');
       } else {
          alert('Property creation failed');
        }
      }, error => {
        console.log('Error ', error);
      }
    )
    this.propcreateForm.reset();
    // Prop service stuff
  }

}
