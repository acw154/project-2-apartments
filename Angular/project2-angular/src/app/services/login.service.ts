import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../model/user';
import { LoginTemplate } from '../model/login-template';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private usersUrl = "/api/login";
  headers={
    headers : new HttpHeaders({
      'Content-Type': 'application/json',
    })
  }
  constructor(private http: HttpClient) {
  }

  public login(loginT: LoginTemplate): Observable<User> {
    return this.http.post<User>(this.usersUrl, JSON.stringify(loginT), this.headers);
  }
}
