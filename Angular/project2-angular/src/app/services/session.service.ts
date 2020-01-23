import { Injectable } from '@angular/core';
import { Session } from 'protractor';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class SessionService {

  constructor() { 

  }

  public saveCurrentUser(user: User){
    sessionStorage.setItem('currentUser', JSON.stringify(user));
  }

  public getCurrentUser(): User{
    if(sessionStorage.getItem('currentUser') != null){
      return JSON.parse(sessionStorage.getItem('currentUser'));
    } else {
      return null;
    }
  }

  public invalidateSession(){
    sessionStorage.clear();
  }
}
