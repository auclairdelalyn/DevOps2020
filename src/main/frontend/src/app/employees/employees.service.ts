import { Injectable } from '@angular/core';
import {HttpClient, HttpResponse, HttpClientModule} from "@angular/common/http";
import {Observable} from "rxjs";
import {Employee} from "../model/employee";
type EntityResponseType = HttpResponse<Employee>;
@Injectable({
  providedIn: 'root'
})
export class EmployeesService {
  private baseUrl = '/employees';
  constructor(private httpClient:HttpClient) { }
  getAll(): Observable<any> {
      return this.httpClient.get(`${this.baseUrl}`);
  }
  deleteEmployee(id: number): Observable<any> {
      return this.httpClient.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }
  /*getEmployee(id: number) : Observable<Employee> {
    return this.httpClient.get<Employee>('/employees/' + id);
  }
  deleteEmployee(id: number): Observable<EntityResponseType> {
    return this.httpClient.delete<Employee>('/employees/' + id, { observe: 'response' });
  }
  createEmployee(employee:Employee): Observable<EntityResponseType> {
    return this.httpClient.post<Employee>('/employees', employee, { observe: 'response' });
  }
  updateEmployee(employee: Employee): Observable<EntityResponseType> {
    return this.httpClient.post<Employee>('/employees' + '/' + employee.id, employee, { observe: 'response' });
  }*/
}
