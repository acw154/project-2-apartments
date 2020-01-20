import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-background2',
  templateUrl: './background2.component.html',
  styleUrls: ['./background2.component.css']
})
export class Background2Component implements OnInit {

  bgrimage1:string ="assets/img2.jpg";
  
  constructor() { }

  ngOnInit() {
  }

}
