import { Injectable } from '@angular/core';
import {HttpClient, HttpResponse, HttpClientModule} from "@angular/common/http";
import {Observable} from "rxjs";
import {Species} from "../model/species";
type EntityResponseType = HttpResponse<Species>;
@Injectable({
  providedIn: 'root'
})
export class SpeciesService {
  private baseUrl = '/species';
  constructor(private httpClient:HttpClient) { }
  getAll(): Observable<any> {
      return this.httpClient.get(`${this.baseUrl}`);
  }
  deleteSpecies(id: number): Observable<any> {
      return this.httpClient.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }
  /*getSpecies(id: number) : Observable<Species> {
    return this.httpClient.get<Species>('/species/' + id);
  }
  deleteSpecies(id: number): Observable<EntityResponseType> {
    return this.httpClient.delete<Species>('/species/' + id, { observe: 'response' });
  }
  createSpecies(species:Species): Observable<EntityResponseType> {
    return this.httpClient.post<Species>('/species', species, { observe: 'response' });
  }
  updateSpecies(species: Species): Observable<EntityResponseType> {
    return this.httpClient.post<Species>('/species' + '/' + species.id, species, { observe: 'response' });
  }*/
}
