import { Component, OnInit } from '@angular/core';
import { PropertyService } from 'src/app/services/property.service';
import { Preference } from 'src/app/model/preference';
import { Router } from '@angular/router';

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

  constructor(private propertyService: PropertyService,
    private router: Router) {
      this.preference = new Preference();
      this.preference.min_price = 0;
    }
   

  ngOnInit() {  
  }

  getAllProperties(){
    this.propertyService.getProperties(this.preference).subscribe(
      data => {
        if(data != null) {
          this.response = data;
          // Either have properties hide until search is clicked using ngIf or have some update button
        }
      },
      error => {
        console.log('Error', error);
      }
    );
  }

}
