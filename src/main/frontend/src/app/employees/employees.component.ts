import {Component, EventEmitter, OnInit, Input, Output} from '@angular/core';
import {EmployeesService} from "./employees.service";
import {Employee} from "../model/employee";
import {SectorsService} from "../sectors/sectors.service";
import {Sector} from "../model/sector";
import {BathsService} from "../baths/baths.service";
import {Bath} from "../model/bath";
import {Observable} from "rxjs";
import { filter, map } from 'rxjs/operators';
import { RouterModule, Routes, Router } from '@angular/router';
import { HttpClientModule } from "@angular/common/http";

@Component({
  selector: 'app-employees',
  templateUrl: './employees.component.html',
  styleUrls: ['./employees.component.css']
})
export class EmployeesComponent implements OnInit {
  @Input() key:string;
  @Output() setKey = new EventEmitter<string>();
  @Input() manager:boolean;
  @Input() id:number;
  employees: Observable<Employee[]>;
  selected: Employee;

  employee:Employee;

  sectors: Observable<Sector[]>;
    select(element){
          this.selected = element;
        }

    constructor(private employeesService: EmployeesService, private sectorsService:SectorsService, private bathsService: BathsService, private router:Router) {
        this.employee=new Employee();
    }

    ngOnInit() {
      this.reloadData();
      this.sectors=this.sectorsService.getAll();
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

    onSubmit() {
                //this.employee.baths=this.baths;
                console.log(this.employee);
                this.employeesService.createEmployee(this.employee).subscribe(result => this.setKey.emit(this.key));
    }

    reset(){
                this.employee=new Employee();
        }

        edit(empl){
                this.employee=empl;

        }
}
