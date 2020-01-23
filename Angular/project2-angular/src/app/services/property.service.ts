import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Property } from '../model/property';
import { Preference } from '../model/preference';

@Injectable({
  providedIn: 'root'
})
export class PropertyService {
  private usersUrl: string;

  constructor(private http: HttpClient) {
    this.usersUrl = 'http://localhost:8080/propsearch';
  }

  public getProperties(preference: Preference): Observable<Property[]> {
    return this.http.post<Property[]>(this.usersUrl, preference);
  }
  // Create methods that take in the searchForm with all of its values and post it 
}
