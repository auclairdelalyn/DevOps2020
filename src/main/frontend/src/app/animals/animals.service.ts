import { Injectable } from '@angular/core';
import {HttpClient, HttpResponse, HttpClientModule} from "@angular/common/http";
import {Observable} from "rxjs";
import {Animal} from "../model/animal";
type EntityResponseType = HttpResponse<Animal>;
@Injectable({
  providedIn: 'root'
})
export class AnimalsService {
  private baseUrl = '/animals';
  constructor(private httpClient:HttpClient) { }
  getAll(): Observable<any> {
      return this.httpClient.get(`${this.baseUrl}`);
  }
  deleteAnimal(id: number): Observable<any> {
      return this.httpClient.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

  createAnimal(animal:Animal): Observable<EntityResponseType> {
      return this.httpClient.post<Animal>(`${this.baseUrl}`, animal, { observe: 'response' });
  }
  /*getAnimals(id: number) : Observable<Animals> {
    return this.httpClient.get<Animals>('/animals/' + id);
  }
  deleteAnimals(id: number): Observable<EntityResponseType> {
    return this.httpClient.delete<Animals>('/animals/' + id, { observe: 'response' });
  }
  createAnimals(animal:Animals): Observable<EntityResponseType> {
    return this.httpClient.post<Animals>('/animals', animal, { observe: 'response' });
  }
  updateAnimals(animal: Animals): Observable<EntityResponseType> {
    return this.httpClient.post<Animals>('/animals' + '/' + animal.id, animal, { observe: 'response' });
  }*/
}
