import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from 'src/app/models/user';


@Injectable({
  providedIn: 'root'
})
export class UserserviceService {

  constructor(private http: HttpClient) { }

  login(username:string, password:string): Observable<User> {
    let body: any =
    {
      username: username,
      password: password
    };

    

    return this.http.post<User>(('http://localhost:8080/project2/loginpage'), body);

    
  }

  logout(){
    return this.http.post<void>("http://localhost:8080/project2/logout", {});
  }

  newUser(username: string, password: string, f_name: string, l_name: string, email: string){
    let body: any = {
      username: username,
      password: password,
      f_name: f_name,
      l_name: l_name,
      email: email
    }
    return this.http.post<void>("http://localhost:8080/project2/register", body);
  }

}
