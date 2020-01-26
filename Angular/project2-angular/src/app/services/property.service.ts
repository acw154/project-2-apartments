import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Property } from '../model/property';
import { Preference } from '../model/preference';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class PropertyService {
  private getPropUrl: string;
  private createPropUrl: string;
  private savePropUrl: string;
  private viewedProperty: Property;
  headers={
    headers : new HttpHeaders({
      'Content-Type': 'application/json',
    })
  };

  constructor(private http: HttpClient) {
    this.getPropUrl = '/RevatureRealocator/propsearch';
    this.createPropUrl = '/RevatureRealocator/propsave';
    this.savePropUrl = '/RevatureRealocator/userpropsave'; 
  }

  public getPropertiesByPref(preference: Preference): Observable<Property[]> {
    return this.http.post<Property[]>(this.getPropUrl + 'pref', JSON.stringify(preference), this.headers);
  }

  public getPropertiesSimple(preference: Preference): Observable<Property[]> {
    return this.http.post<Property[]>(this.getPropUrl + 'simple', JSON.stringify(preference), this.headers);
  }

  public insertProperty(property: Property): Observable<Property> {
    return this.http.post<Property>(this.createPropUrl,  JSON.stringify(property), this.headers);
  }

  public openPropertyPage(property: Property){
    this.viewedProperty = property;
  }

  public closePropertyPage(){
    this.viewedProperty = null;
  }

  public getViewedProperty(){
    return this.viewedProperty;
  }

  public saveProperty(property: Property): Observable<User>{
    return this.http.post<User>(this.savePropUrl, property);
  }

  // Create methods that take in the searchForm with all of its values and post it 
}
