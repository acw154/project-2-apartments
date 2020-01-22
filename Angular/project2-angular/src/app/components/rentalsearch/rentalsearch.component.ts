import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-rentalsearch',
  templateUrl: './rentalsearch.component.html',
  styleUrls: ['./rentalsearch.component.css']
})
export class RentalsearchComponent implements OnInit {
  response: any;
  readonly APP_URL = 'http://localhost:8080/RevatureRealocator'; //not sure if this is right
  constructor(private _http: HttpClient) {}
   

  ngOnInit() {  
  }

  getAllProperties(){
    this._http.get(this.APP_URL + '/propsearch').subscribe(
      data => {
        this.response = data;
      },
      error => {
        console.log('Error', error);
      }
    );
  }

}
