import { Injectable } from '@angular/core';
import {HttpClient, HttpResponse, HttpClientModule} from "@angular/common/http";
import {Observable} from "rxjs";
import {Bath} from "../model/bath";
type EntityResponseType = HttpResponse<Bath>;
@Injectable({
  providedIn: 'root'
})
export class BathsService {
  private baseUrl = '/baths';
  constructor(private httpClient:HttpClient) { }
  getAll(): Observable<any> {
      return this.httpClient.get(`${this.baseUrl}`);
  }
  deleteBath(id: number): Observable<any> {
      return this.httpClient.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }
  /*getBath(id: number) : Observable<Bath> {
    return this.httpClient.get<Bath>('/baths/' + id);
  }
  deleteBath(id: number): Observable<EntityResponseType> {
    return this.httpClient.delete<Bath>('/baths/' + id, { observe: 'response' });
  }
  createBath(bath:Bath): Observable<EntityResponseType> {
    return this.httpClient.post<Bath>('/baths', bath, { observe: 'response' });
  }
  updateBath(bath: Bath): Observable<EntityResponseType> {
    return this.httpClient.post<Bath>('/baths' + '/' + bath.id, bath, { observe: 'response' });
  }*/
}

