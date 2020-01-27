import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../model/user';
import { LoginTemplate } from '../model/login-template';
import { UserFull } from '../model/user-full';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private usersUrl = "/RevatureRealocator/login";
  headers={
    headers : new HttpHeaders({
      'Content-Type': 'application/json',
    })
  }
  constructor(private http: HttpClient) {
  }

  public login(loginT: LoginTemplate): Observable<UserFull> {
    return this.http.post<UserFull>(this.usersUrl, JSON.stringify(loginT), this.headers);
  }
}
