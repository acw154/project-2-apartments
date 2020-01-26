import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/model/user';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-usersearchpage',
  templateUrl: './usersearchpage.component.html',
  styleUrls: ['./usersearchpage.component.css']
})
export class UsersearchpageComponent implements OnInit {

  users: User[];
  constructor(private rs: UserService, private router: Router) { }

  // getUserReim() {
  //   this.rs.findByState(this.currentUser.).subscribe(
  //     (response:Reimbursement[]) => {
  //      this.reimbursements=response;
  //     }
  //   )
  // }

  ngOnInit() {
  }

}
