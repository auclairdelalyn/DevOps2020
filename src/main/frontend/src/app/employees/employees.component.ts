import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {EmployeesService} from "./employees.service";
import {Employee} from "../model/employee";
import {Observable} from "rxjs";
import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule } from "@angular/common/http";

@Component({
  selector: 'app-employees',
  templateUrl: './employees.component.html',
  styleUrls: ['./employees.component.css']
})
export class EmployeesComponent implements OnInit {
  employees: Observable<Employee[]>;

    constructor(private employeesService: EmployeesService) {}

    ngOnInit() {
      this.reloadData();
    }

    reloadData() {
      this.employees = this.employeesService.getAll();
    }

    deleteEmployee(id: number) {
      this.employeesService.deleteEmployee(id).subscribe(
          data => {
            console.log(data);
            this.reloadData();
          },
          error => console.log(error));
    }
}
