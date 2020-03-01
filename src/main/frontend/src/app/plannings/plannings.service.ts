import { Injectable } from '@angular/core';
import {HttpClient, HttpResponse, HttpClientModule} from "@angular/common/http";
import {Observable} from "rxjs";
import {Planning} from "../model/planning";
type EntityResponseType = HttpResponse<Planning>;
@Injectable({
  providedIn: 'root'
})
export class PlanningsService {
  private baseUrl = '/plannings';
  constructor(private httpClient:HttpClient) { }
  getAll(): Observable<any> {
      return this.httpClient.get(`${this.baseUrl}`);
  }
  deletePlanning(id: number): Observable<any> {
      return this.httpClient.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }
  createPlanning(planning:Planning): Observable<EntityResponseType> {
      return this.httpClient.post<Planning>(`${this.baseUrl}`, planning, { observe: 'response' });
  }
  /*getPlanning(id: number) : Observable<Planning> {
    return this.httpClient.get<Planning>('/plannings/' + id);
  }
  deletePlanning(id: number): Observable<EntityResponseType> {
    return this.httpClient.delete<Planning>('/plannings/' + id, { observe: 'response' });
  }
  createPlanning(planning:Planning): Observable<EntityResponseType> {
    return this.httpClient.post<Planning>('/plannings', planning, { observe: 'response' });
  }
  updatePlanning(planning: Planning): Observable<EntityResponseType> {
    return this.httpClient.post<Planning>('/plannings' + '/' + planning.id, planning, { observe: 'response' });
  }*/
}
