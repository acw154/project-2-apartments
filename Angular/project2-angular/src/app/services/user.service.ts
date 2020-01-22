import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {


  // this needs some work 

  
  // constructor(private http: HttpClient) { }

  // login(username: string, password: string): Observable<User> {
  //   let body: any =
  //   {
  //     username: username,
  //     password: password
  //   };

  //   return this.http.post<User>("http://localhost:8080/",body);
  // }

  // logout() {
  //   return this.http.post<void>("http://localhost:8080/", {});
  // }
}