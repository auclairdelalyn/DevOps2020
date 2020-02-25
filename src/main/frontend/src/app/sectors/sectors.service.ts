import { Injectable } from '@angular/core';
import {HttpClient, HttpResponse, HttpClientModule} from "@angular/common/http";
import {Observable} from "rxjs";
import {Sector} from "../model/sector";
type EntityResponseType = HttpResponse<Sector>;
@Injectable({
  providedIn: 'root'
})
export class SectorsService {
  private baseUrl = '/sectors';
  constructor(private httpClient:HttpClient) { }
  getAll(): Observable<any> {
      return this.httpClient.get(`${this.baseUrl}`);
  }
  deleteSector(id: number): Observable<any> {
      return this.httpClient.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }
  /*getSector(id: number) : Observable<Sector> {
    return this.httpClient.get<Sector>('/sectors/' + id);
  }
  deleteSector(id: number): Observable<EntityResponseType> {
    return this.httpClient.delete<Sector>('/sectors/' + id, { observe: 'response' });
  }
  createSector(sector:Sector): Observable<EntityResponseType> {
    return this.httpClient.post<Sector>('/sectors', sector, { observe: 'response' });
  }
  updateSector(sector: Sector): Observable<EntityResponseType> {
    return this.httpClient.post<Sector>('/sectors' + '/' + sector.id, sector, { observe: 'response' });
  }*/
}
