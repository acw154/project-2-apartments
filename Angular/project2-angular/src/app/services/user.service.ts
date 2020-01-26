import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../model/user';
import { Preference } from '../model/preference';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private usersUrl: string;
  private saveUserUrl: string;
  private prefUrl: string;
  private currentUser: User;
  headers={
    headers : new HttpHeaders({
      'Content-Type': 'application/json',
    })
  };
  
  constructor(private http: HttpClient) {
    this.usersUrl = '/RevatureRealocator/preferences/users'; // May need to change this URI 
    this.prefUrl = '/RevatureRealocator/getpref'; // or whatever that uri is
    this.saveUserUrl = '/RevatureRealocator/user';
  }

  // Create methods for saving and getting the profile information
  public getUserPreference(user: User): Observable<Preference>{
    return this.http.post<Preference>(this.usersUrl,  JSON.stringify(user), this.headers);
  }

  public saveUser(user: User): Observable<User> {
    return this.http.post<User>(this.saveUserUrl,  JSON.stringify(user), this.headers);
  }
  
}