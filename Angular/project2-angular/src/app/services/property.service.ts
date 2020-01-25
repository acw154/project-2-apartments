import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Property } from '../model/property';
import { Preference } from '../model/preference';

@Injectable({
  providedIn: 'root'
})
export class PropertyService {
  private getPropUrl: string;
  private createPropUrl: string;
  private savePropUrl: string;
  private viewedProperty: Property;

  constructor(private http: HttpClient) {
    this.getPropUrl = 'http://localhost:8080/propsearch';
    this.createPropUrl = 'http://localhost:8080/propsave';
    this.savePropUrl = 'http://localhost:8080/propusersave'; //idk what it is
  }

  public getPropertiesByPref(preference: Preference): Observable<Property[]> {
    return this.http.post<Property[]>(this.getPropUrl + 'pref', preference);
  }

  public getPropertiesSimple(preference: Preference): Observable<Property[]> {
    return this.http.post<Property[]>(this.getPropUrl + 'simple', preference);
  }

  public insertProperty(property: Property): Observable<Boolean> {
    return this.http.post<Boolean>(this.createPropUrl, property);
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

  public saveProperty(property: Property){
    this.http.post(this.savePropUrl, property);
  }

  // Create methods that take in the searchForm with all of its values and post it 
}
