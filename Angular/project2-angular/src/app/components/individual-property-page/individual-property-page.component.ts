import { Component, OnInit } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { Property } from '../../model/Property';
import { PropertyService } from 'src/app/services/property.service';

@Component({
  selector: 'app-individual-property-page',
  templateUrl: './individual-property-page.component.html',
  styleUrls: ['./individual-property-page.component.css']
})
export class IndividualPropertyPageComponent implements OnInit {
  viewedProperty: Property;
  propertyService: PropertyService;

  constructor(
  ) { 
  }

  ngOnInit() {
    this.viewedProperty = this.propertyService.getViewedProperty();
  }
  
  ngOnDestroy(){
    this.propertyService.closePropertyPage();
  }

}
