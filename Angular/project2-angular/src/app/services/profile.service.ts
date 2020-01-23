import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Property } from '../model/property';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {
  private usersUrl: string;

  constructor(private http: HttpClient) {
    this.usersUrl = 'http://localhost:8080/users'; // May need to change this URI 
  }

  // Create methods for saving and getting the profile information
}
