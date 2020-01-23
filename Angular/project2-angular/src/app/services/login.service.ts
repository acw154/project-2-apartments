import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { User } from '../model/user';
import { Form } from '@angular/forms';
import { LoginTemplate } from '../model/login-template';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private usersUrl: string;

  constructor(private http: HttpClient) {
    this.usersUrl = 'http://localhost:8080/login';
  }

  public login(loginT: LoginTemplate): Observable<User> {
    return this.http.post<User>(this.usersUrl, loginT);
  }
}
