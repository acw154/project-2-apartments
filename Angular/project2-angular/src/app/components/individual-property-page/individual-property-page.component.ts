import { Component, OnInit } from '@angular/core';
import { PropertyService } from 'src/app/services/property.service';
import { Property } from 'src/app/model/property';
import { SessionService } from 'src/app/services/session.service';


@Component({
  selector: 'app-individual-property-page',
  templateUrl: './individual-property-page.component.html',
  styleUrls: ['./individual-property-page.component.css']
})
export class IndividualPropertyPageComponent implements OnInit {
  
  viewedProperty: Property;
  alreadySaved: boolean;


  constructor(private propertyService: PropertyService,
    private sessionService: SessionService,
  ) { 
    this.viewedProperty = this.propertyService.getViewedProperty();
    let savedProperties = this.sessionService.getSavedProperties();
    console.log(savedProperties);
    if(savedProperties != null){
      for(let i=0; i < savedProperties.length; i++){
        if(savedProperties[i].street_num === this.viewedProperty.street_num && savedProperties[i].street === this.viewedProperty.street){
          this.alreadySaved = true;
          break;
        }
      }
    }
    if(this.alreadySaved === undefined){
      this.alreadySaved = false;
    }
    console.log(this.alreadySaved);
  }

  ngOnInit() {
  }
  
  ngOnDestroy(){
    this.propertyService.closePropertyPage();
  }

  saveProperty(){
    this.viewedProperty.email = this.sessionService.getCurrentUser().email;
    this.propertyService.saveProperty(this.viewedProperty).subscribe(
      data => {
        if(data != null ){
          console.log(data);
          alert("Saved Property");
          this.sessionService.addSavedProperty(this.viewedProperty);
        } else {
          console.log("Not saved")
          alert("Error saving property");
        }
      }, error => {
        console.log('Error ', error);
        alert("Error saving property");
      }
    )

  }



}
