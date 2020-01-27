import { Injectable } from '@angular/core';
import { Session } from 'protractor';
import { User } from '../model/user';
import { Preference } from '../model/preference';
import { Property } from '../model/property';

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

  public storePreference(pref: Preference){
    sessionStorage.setItem('currPreference', JSON.stringify(pref));
  }

  public getStoredPreference(): Preference {
    if(sessionStorage.getItem('currentUser') != null && sessionStorage.getItem('currPreference') != null){
      return JSON.parse(sessionStorage.getItem('currPreference'));
    } else {
      return null;
    }
  }

  public storeUserProperties(properties: Property[]){
    sessionStorage.setItem('userProperties', JSON.stringify(properties));
  }

  public getUserProperties(){
    if(sessionStorage.getItem('currentUser') != null && sessionStorage.getItem('userProperties') != null){
     return JSON.parse(sessionStorage.getItem('userProperties'));
    } else {
      return null;
    }
  }

  public storeSavedProperties(properties: Property[]){
    sessionStorage.setItem('savedProperties', JSON.stringify(properties));
  }

  public addSavedProperty(property: Property){
    sessionStorage.setItem('savedProperties', JSON.parse(sessionStorage.getItem('savedProperties')).push(property));
  }

  public getSavedProperties(): Property[]{
    if(sessionStorage.getItem('savedProperties') != null && sessionStorage.getItem('currentUser') != null){
      return JSON.parse(sessionStorage.getItem('savedProperties'));
    } else {
      return null;
    }
  }

}
