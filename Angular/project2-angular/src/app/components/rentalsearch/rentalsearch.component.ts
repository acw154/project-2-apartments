import { Component, OnInit } from '@angular/core';
import { PropertyService } from 'src/app/services/property.service';
import { Preference } from 'src/app/model/preference';
import { Router } from '@angular/router';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { SessionService } from 'src/app/services/session.service';
import { Property } from 'src/app/model/property';

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
  // dummy: Property;

  constructor(private propertyService: PropertyService,
    private router: Router,
    private sessionService: SessionService,
    private fb: FormBuilder) {
      this.createForm();
      // this.dummy = new Property();
      // this.dummy.type = "apartment";
      // this.dummy.street_num = 2224;
      // this.dummy.street = "Astoria Circle";
      // this.dummy.zip = 20170;
      // this.dummy.city = "Herndon";
      // this.dummy.num_baths = 2;
      // this.dummy.num_beds = 3;
      // this.dummy.photo = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSO2VsXHibPII0M9jCDlH9h019dEXrWF2JQ6p7JuySoW0BB2o1-&s"
      // this.dummy.price = 2700;
      // this.dummy.revemp_owned = true;
      // this.dummy.sq_ft = 1200;
      

  }
  
  createForm(){
    this.prefForm = this.fb.group({
      city: ['', Validators.required],
      state_code: ['', [Validators.required, Validators.minLength(2), Validators.maxLength(2)]],
      min_price: ['', [Validators.required, Validators.min(0)]],
      max_price: ['', [Validators.required, Validators.min(0), Validators.max(50000)]],
      num_beds: ['', Validators.min(0)],
      num_baths: ['', Validators.min(0)],
    });
  }

  ngOnInit() {  
  }

  searchTable() {
    var input, filter, found, table, tr, td, i, j;
    input = document.getElementById("myInput");
    filter = input.value.toUpperCase();
    table = document.getElementById("resultsbody");
    tr = table.getElementsByTagName("tr");
    for (i = 0; i < tr.length; i++) {
        td = tr[i].getElementsByTagName("td");
        for (j = 0; j < td.length; j++) {
            if (td[j].innerHTML.toUpperCase().indexOf(filter) > -1) {
                found = true;
            }
        }
        if (found) {
            tr[i].style.display = "";
            found = false;
        } else {
            tr[i].style.display = "none";
        }
    }
}  



  sortTable(n) {
    var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
    table = document.getElementById("resulttable");
    switching = true;
    // Set the sorting direction to ascending:
    dir = "asc";
    /* Make a loop that will continue until
    no switching has been done: */
    while (switching) {
      // Start by saying: no switching is done:
      switching = false;
      rows = table.rows;
      /* Loop through all table rows (except the
      first, which contains table headers): */
      for (i = 1; i < (rows.length - 1); i++) {
        // Start by saying there should be no switching:
        shouldSwitch = false;
        /* Get the two elements you want to compare,
        one from current row and one from the next: */
        x = rows[i].getElementsByTagName("td")[n];
        y = rows[i + 1].getElementsByTagName("td")[n];
        /* Check if the two rows should switch place,
        based on the direction, asc or desc: */
        if (dir == "asc") {												
          if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
            // If so, mark as a switch and break the loop:
            shouldSwitch = true;
            break;
          }
        } else if (dir == "desc") {
          if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
            // If so, mark as a switch and break the loop:
            shouldSwitch = true;
            break;
          }
        }
      }
      if (shouldSwitch) {
        /* If a switch has been marked, make the switch
        and mark that a switch has been done: */
        rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
        switching = true;
        // Each time a switch is done, increase this count by 1:
        switchcount ++;
      } else {
        /* If no switching has been done AND the direction is "asc",
        set the direction to "desc" and run the while loop again. */
        if (switchcount == 0 && dir == "asc") {
          dir = "desc";
          switching = true;
        }
      }
    }
  }

  


  doSearch(){
    this.preference = new Preference(this.prefForm.value);
    this.preference.state_code = this.preference.state_code.toUpperCase();
    console.log(this.preference);
    this.propertyService.getPropertiesByPref(this.preference).subscribe(
      data => {
        if(data != null){
            this.response = data;
            console.log('Found properties');
        }
      }, error => {
          console.log('Error ', error);
        }
      )
  }

  
    searchWithSavedPref(){
      console.log(this.sessionService.getStoredPreference());
      this.preference = this.sessionService.getStoredPreference();
      this.propertyService.getPropertiesByPref(this.preference).subscribe(
        data => {
          if(data != null){
              this.response = data;
              console.log('Found properties');
          }
        }, error => {
            console.log('Error ', error);
          }
        )
      // if(this.preference.max_price == null && this.preference.num_baths == null && this.preference.num_beds == null){
      //   this.propertyService.getPropertiesSimple(this.preference).subscribe(
      //     data => {
      //       if(data != null) {
      //         this.response = data;
      //       }
      //     }, error => {
      //       console.log('Error', error);
      //     }
      //   )
      // } else {
      //   this.propertyService.getPropertiesByPref(this.preference).subscribe(
      //     data => {
      //       if(data != null){
      //         this.response = data;
      //       }
      //     }, error => {
      //       console.log('Error', error);
      //     }
      //   )
      // }
    }

    goToIndividualPropertyPage(property: Property){
      this.propertyService.openPropertyPage(property);
       //Saves property within propertyservice so that individual property page can pull that information
      this.router.navigateByUrl('/individualpropertypage');
    }
  }
