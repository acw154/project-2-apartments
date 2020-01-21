import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-resultspage',
  templateUrl: './resultspage.component.html',
  styleUrls: ['./resultspage.component.css']
})
export class ResultspageComponent implements OnInit {
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
