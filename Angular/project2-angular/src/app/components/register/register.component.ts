import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserserviceService } from '../services/userservice.service';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  username : string;
  password : string;
  f_name : string;
  l_name : string;
  email : string;
  confirmpas : string;

  constructor(private us: UserserviceService, private router: Router) { }

  ngOnInit() {
  }

  newUser() {
    if(this.password != this.confirmpas){
      document.getElementById("attention").innerHTML = "Password does not match.";
    } else {
      this.us.newUser(this.username, this.password, this.f_name, this.l_name, this.email).subscribe();
      this.router.navigate(['/loginpage']);
    }
  }

}
