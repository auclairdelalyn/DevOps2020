import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {SectorsService} from "./sectors.service";
import {Sector} from "../model/sector";
import {Observable} from "rxjs";
import { filter, map } from 'rxjs/operators';
import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule } from "@angular/common/http";

@Component({
  selector: 'app-sectors',
  templateUrl: './sectors.component.html',
  styleUrls: ['./sectors.component.css']
})
export class SectorsComponent implements OnInit {
  sectors: Observable<Sector[]>;
  selected: Sector;
    select(element){
          this.selected = element;
        }

    constructor(private sectorsService: SectorsService) {}

    ngOnInit() {
      this.reloadData();
    }

    reloadData() {
      this.sectors = this.sectorsService.getAll();
    }

    deleteSector(id: number) {
      this.sectorsService.deleteSector(id).subscribe(
                                                    data => {
                                                      console.log(data);
                                                      this.reloadData();
                                                    },
                                                    error => console.log(error));
    }
}
