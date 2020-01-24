import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { User } from '../model/user';
import { Preference } from '../model/preference';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private usersUrl: string;
  private prefUrl: string;
  private currentUser: User;

  constructor(private http: HttpClient) {
    this.usersUrl = 'http://localhost:8080/users'; // May need to change this URI 
    this.prefUrl = 'http://localhost:8080/getpref'; // or whatever that uri is
  }

  // Create methods for saving and getting the profile information
  public getUserPreference(user: User): Observable<Preference>{
    return this.http.post<Preference>(this.usersUrl, user);
  }

  public saveUser(user: User): Observable<User> {
    return this.http.post<User>(this.usersUrl, user);
  }
  
}