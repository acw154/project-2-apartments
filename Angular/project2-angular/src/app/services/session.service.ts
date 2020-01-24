import { Injectable } from '@angular/core';
import { Session } from 'protractor';
import { User } from '../model/user';
import { Preference } from '../model/preference';

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

  public savePreference(pref: Preference){
    sessionStorage.setItem('currPreference', JSON.stringify(pref));
  }

  public getPreference(): Preference {
    if(sessionStorage.getItem('currentUser') != null && sessionStorage.getItem('currPreference') != null){
      return JSON.parse(sessionStorage.getItem('currPreference'));
    } else {
      return null;
    }
  }
}
