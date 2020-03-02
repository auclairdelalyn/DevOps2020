import {Component, EventEmitter, OnInit, Input, Output} from '@angular/core';
import {PlanningsService} from "./plannings.service";
import {Planning} from "../model/planning";
import {BathsService} from "../baths/baths.service";
import {Bath} from "../model/bath";
import {EmployeesService} from "../employees/employees.service";
import {Employee} from "../model/employee";
import {Observable} from "rxjs";
import { filter, map } from 'rxjs/operators';
import { RouterModule, Routes, Router } from '@angular/router';
import { HttpClientModule } from "@angular/common/http";

@Component({
  selector: 'app-plannings',
  templateUrl: './plannings.component.html',
  styleUrls: ['./plannings.component.css']
})
export class PlanningsComponent implements OnInit {
  @Input() key:string;
  @Output() setKey = new EventEmitter<string>();
  @Input() manager:boolean;
  @Input() id:number;
  plannings: Observable<Planning[]>;
  selected: Planning;

  planning : Planning;/*{id, name, hour, minutes, day, ispublic, bath, employees} =
    {id:null, name: "", hour: null, minutes:null, day:null, ispublic:false, bath:null, employees:null};*/

  baths: Observable<Bath[]>;
  selectedBath: Bath;

  employees: Observable<Employee[]>;

    select(element){
       this.selected = element;
    }

    constructor(private planningsService: PlanningsService, private router: Router, private bathsService: BathsService, private employeesService: EmployeesService) {
      this.planning=new Planning();
    }

    ngOnInit() {
      console.log(this.key);
      this.reloadData();
      this.baths=this.bathsService.getAll();
      this.employees = this.employeesService.getAll();
    }

    reloadData() {
      this.plannings = this.planningsService.getAll();
    }

    deletePlanning(id:number) {
      console.log(id);
      this.planningsService.deletePlanning(id).subscribe(
                                                        data => {
                                                          console.log(data);
                                                          this.reloadData();
                                                        },
                                                        error => console.log(error));
    }

    onSubmit() {
        console.log(this.planning);
        this.planningsService.createPlanning(this.planning).subscribe(result => this.setKey.emit(this.key));
    }

    onBathChange(event){
        console.log(this.planning.bath);
        //this.selectedBath=event.value;
        this.employees = this.employeesService.getAll()
        .pipe(map(employee=>employee.filter(empl=>{
            let s=empl.sectors;
            for(let i=0;i<s.length;i++){
              if(s[i].id==this.planning.bath.sector.id)
              return true;
            }
            return false;
        })));
    }

    reset(){
        this.planning=new Planning();
    }
    edit(plan){
        this.planning=plan;
    }

    getPlannings(){
        if(this.key!=null && !this.manager){
          this.plannings=this.planningsService.getAll()
            .pipe(map(planning=>planning.filter(plan=>{
              for(let i=0;i<plan.employees;i++)
              {
                if(plan.employees[i].id==this.id){
                 return true;
                }
              }
              return false;
            }
          )));
        }else if(this.key!=null && this.manager){
            this.plannings=this.planningsService.getAll()
            .pipe(map(planning=>planning.filter(plan=>{
              for(let i=0;i<plan.employees;i++)
              {
                if(plan.employees[i].id==this.id || plan.bath.resp.id==this.id){
                 return true;
                }
              }
              return false;
            }
          )));
        }
        return this.plannings;
    }

    getBaths(){
      if(this.key!=null && !this.manager){
        this.baths=this.bathsService.getAll()
          .pipe(map(bath=>bath.filter(bat=>{
            if(bat.resp.id==this.id){
              return true;
            }
            return false;
          }
        )));
      }
      return this.baths;
    }
}

