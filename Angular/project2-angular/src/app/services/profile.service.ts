import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Property } from '../model/property';
import { User } from '../model/user';
import { Preference } from '../model/preference';
import { LoginTemplate } from '../model/login-template';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {
  private usersUrl: string;
  private prefUrl: string;
  private getUserPropertiesUrl: string;

  constructor(private http: HttpClient) {
    this.usersUrl = '/RevatureRealocator/users'; // May need to change this URI 
    this.prefUrl = '/RevatureRealocator/preferences/update';
    this.getUserPropertiesUrl = '/RevatureRealocator/user/properties';
  }

  public savePreference(preference: Preference){
    this.http.post(this.prefUrl, preference);
  }
  // Create methods for saving and getting the profile information


  public getSavedProperties(user: User): Observable<Property[]>{
    let loginT = new LoginTemplate(user.email, user.password);
    return this.http.post<Property[]>(this.getUserPropertiesUrl, loginT);
  }
}
