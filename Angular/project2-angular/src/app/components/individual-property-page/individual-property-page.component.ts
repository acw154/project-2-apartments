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
  alreadySaved = false;


  constructor(private propertyService: PropertyService,
    private sessionService: SessionService,
  ) { 
    this.viewedProperty = this.propertyService.getViewedProperty();
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
