import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {AnimalsService} from "./animals.service";
import {Animal} from "../model/animal";
import {Observable} from "rxjs";
import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule } from "@angular/common/http";

@Component({
  selector: 'app-animals',
  templateUrl: './animals.component.html',
  styleUrls: ['./animals.component.css']
})
export class AnimalsComponent implements OnInit {
  animals: Observable<Animal[]>;

    constructor(private animalsService: AnimalsService) {}

    ngOnInit() {
      this.reloadData();
    }

    reloadData() {
      this.animals = this.animalsService.getAll();
    }

    deleteAnimal(id: number) {
      this.animalsService.deleteAnimal(id).subscribe(
                                                    data => {
                                                      console.log(data);
                                                      this.reloadData();
                                                    },
                                                    error => console.log(error));
    }
}
