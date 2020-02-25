import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {SpeciesService} from "./species.service";
import {Species} from "../model/species";
import {Observable} from "rxjs";
import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule } from "@angular/common/http";

@Component({
  selector: 'app-species',
  templateUrl: './species.component.html',
  styleUrls: ['./species.component.css']
})
export class SpeciesComponent implements OnInit {
  species: Observable<Species[]>;

    constructor(private speciesService: SpeciesService) {}

    ngOnInit() {
      this.reloadData();
    }

    reloadData() {
      this.species = this.speciesService.getAll();
    }

    deleteSpecies(id: number) {
      this.speciesService.deleteSpecies(id).subscribe(
                                                     data => {
                                                       console.log(data);
                                                       this.reloadData();
                                                     },
                                                     error => console.log(error));
    }
}
