import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {BathsService} from "./baths.service";
import {Bath} from "../model/bath";
import {SectorsService} from "../sectors/sectors.service";
import {Sector} from "../model/sector";
import {EmployeesService} from "../employees/employees.service";
import {Employee} from "../model/employee";
import {Observable} from "rxjs";
import { filter, map } from 'rxjs/operators';
import { RouterModule, Routes, Router } from '@angular/router';
import { HttpClientModule } from "@angular/common/http";

@Component({
  selector: 'app-baths',
  templateUrl: './baths.component.html',
  styleUrls: ['./baths.component.css']
})
export class BathsComponent implements OnInit{
  baths: Observable<Bath[]>;
  selected: Bath;

  bath:Bath;

  sectors:Observable<Sector[]>;
  employees:Observable<Employee[]>;

    select(element){
          this.selected = element;
        }
    constructor(private bathsService: BathsService, private sectorsService:SectorsService, private employeesService:EmployeesService, private router:Router) {
      this.bath=new Bath();
    }

    ngOnInit() {
      this.reloadData();
      this.sectors=this.sectorsService.getAll();
      this.employees=this.employeesService.getAll();
    }

    reloadData() {
      this.baths = this.bathsService.getAll();
    }

    deleteBath(id: number) {
      this.bathsService.deleteBath(id).subscribe(
                data => {
                  console.log(data);
                  this.reloadData();
                },
                error => console.log(error));
    }

        onSubmit() {

                this.bathsService.createBath(this.bath).subscribe(result => this.router.navigate(['']));
        }

        reset(){
                this.bath=new Bath();
        }
        edit(bat){
                this.bath=bat;
        }
}
