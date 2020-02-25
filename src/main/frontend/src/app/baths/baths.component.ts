import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {BathsService} from "./baths.service";
import {Bath} from "../model/bath";
import {Observable} from "rxjs";
import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule } from "@angular/common/http";

@Component({
  selector: 'app-baths',
  templateUrl: './baths.component.html',
  styleUrls: ['./baths.component.css']
})
export class BathsComponent implements OnInit{
  baths: Observable<Bath[]>;

    constructor(private bathsService: BathsService) {}

    ngOnInit() {
      this.reloadData();
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
}
