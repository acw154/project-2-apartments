import { Component, OnInit } from '@angular/core';
import { SessionService } from 'src/app/services/session.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {
  private router: Router;

  constructor(private sessionService: SessionService,
    router: Router,
    ) { }

  ngOnInit() {
  }

  logout(){
    console.log(this.sessionService.getCurrentUser());
    if(this.sessionService.getCurrentUser() != null){
      this.sessionService.invalidateSession();
      alert("You have logged out");
      console.log(this.sessionService.getCurrentUser());
    } else {
      alert("You were not logged in");
    }
  }

}
