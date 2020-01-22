import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private usersUrl: string;
  private currentUser: User;

  constructor(private http: HttpClient) {
    this.usersUrl = 'http://localhost:8080/users'; // May need to change this URI 
  }

  // Create methods for saving and getting the profile information
  public saveCurrentUser(user: User){
    this.currentUser = user;
  }

  public getCurrentUser(){
    if(this.currentUser.email != null){
      return this.currentUser;
    } else {
      return null;
    }
  }
}