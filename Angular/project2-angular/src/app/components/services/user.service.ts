import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from 'src/app/model/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  login(username:string, password:string): Observable<User> {
    let body: any =
    {
      username: username,
      password: password
    };

    return this.http.post<User>(('http://localhost:8080/'), body);

    
  }

  logout(){
    return this.http.post<void>("http://localhost:8080/", {});
  }

  newUser(username: string, password: string, f_name: string, l_name: string, email: string){
    let body: any = {
      name: username,
      password: password,
      f_name: f_name,
      l_name: l_name,
      email: email
    }
    return this.http.post<void>("http://localhost:8080/", body);
  }


}
