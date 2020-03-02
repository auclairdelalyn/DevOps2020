import { Injectable } from '@angular/core';
import {HttpClient, HttpResponse, HttpClientModule} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ConnexionService {
  private baseUrl = '/connect';
  private manaUrl='/manager';
  private idUrl='/id';
  private decoUrl = '/disconnect';
  constructor(private httpClient:HttpClient) { }

  connect(login:string, password:string): Observable<any> {
        return this.httpClient.get(`${this.baseUrl}/${login}/${password}`, { responseType: 'text' });
  }

  id(login:string, password:string): Observable<any> {
        return this.httpClient.get(`${this.idUrl}/${login}/${password}`);
  }

  manager(login:string, password:string): Observable<any> {
          return this.httpClient.get(`${this.manaUrl}/${login}/${password}`);
  }

  disconnect(key:string): Observable<any> {
          return this.httpClient.get(`${this.decoUrl}/${key}`, { responseType: 'text' });
  }
}
