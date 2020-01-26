import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
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
  headers={
    headers : new HttpHeaders({
      'Content-Type': 'application/json',
    })
  };
  
  constructor(private http: HttpClient) {
    this.usersUrl = '/RevatureRealocator/users'; // May need to change this URI 
    this.prefUrl = '/RevatureRealocator/preferences/update';
    this.getUserPropertiesUrl = '/RevatureRealocator/user/properties';
  }

  public savePreference(preference: Preference): Observable<Preference>{
    return this.http.post<Preference>(this.prefUrl,  JSON.stringify(preference), this.headers);
  }

  // Create methods for saving and getting the profile information


  public getSavedProperties(user: User): Observable<Property[]>{
    let loginT = new LoginTemplate(user.email, user.password);
    return this.http.post<Property[]>(this.getUserPropertiesUrl,  JSON.stringify(loginT), this.headers);
  }
}
