import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {PlanningsService} from "./plannings.service";
import {Planning} from "../model/planning";
import {Observable} from "rxjs";
import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule } from "@angular/common/http";

@Component({
  selector: 'app-plannings',
  templateUrl: './plannings.component.html',
  styleUrls: ['./plannings.component.css']
})
export class PlanningsComponent implements OnInit {
  plannings: Observable<Planning[]>;
  selected: Planning;
    select(element){
          this.selected = element;
        }

    constructor(private planningsService: PlanningsService) {}

    ngOnInit() {
      this.reloadData();
    }

    reloadData() {
      this.plannings = this.planningsService.getAll();
    }

    deletePlanning(id: number) {
      this.planningsService.deletePlanning(id).subscribe(
                                                        data => {
                                                          console.log(data);
                                                          this.reloadData();
                                                        },
                                                        error => console.log(error));
    }
}

