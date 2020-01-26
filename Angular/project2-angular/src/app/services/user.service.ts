import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../model/user';
import { Preference } from '../model/preference';
import { ThrowStmt } from '@angular/compiler';

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

  private findUserUrl: string;


  constructor(private http: HttpClient) {
    this.usersUrl = '/RevatureRealocator/preferences/user'; // May need to change this URI 
    this.prefUrl = '/RevatureRealocator/getpref'; // or whatever that uri is
    this.saveUserUrl = '/RevatureRealocator/user'; 
    this.findUserUrl = 'RevatureRealocator/state/'; //not finished after "/"
  }

  // Create methods for saving and getting the profile information
  public getUserPreference(user: User): Observable<Preference>{
    return this.http.post<Preference>(this.usersUrl,  JSON.stringify(user), this.headers);
  }

  public saveUser(user: User): Observable<User> {
    return this.http.post<User>(this.saveUserUrl,  JSON.stringify(user), this.headers);
  }


  public findByState(state: string): Observable<User[]> {
    return this.http.get<User[]>(this.findUserUrl + state, this.headers);
  }


}

