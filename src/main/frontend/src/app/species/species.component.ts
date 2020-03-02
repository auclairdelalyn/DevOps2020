import {Component, EventEmitter, OnInit, Input, Output} from '@angular/core';
import {SpeciesService} from "./species.service";
import {Species} from "../model/species";
import {Observable} from "rxjs";
import { filter, map } from 'rxjs/operators';
import { RouterModule, Routes, ActivatedRoute } from '@angular/router';
import { HttpClientModule } from "@angular/common/http";

@Component({
  selector: 'app-species',
  templateUrl: './species.component.html',
  styleUrls: ['./species.component.css']
})
export class SpeciesComponent implements OnInit {
  @Input() key:string;
  @Output() setKey = new EventEmitter<string>();
  @Input() manager:boolean;
  @Input() id:number;
  species: Observable<Species[]>;
  selected: Species;

    connectKey:string;

    select(element){
          this.selected = element;
        }

    constructor(private speciesService: SpeciesService, private route:ActivatedRoute) {}

    ngOnInit() {
      this.reloadData();
      let id = this.route.snapshot.paramMap.get('id');
      console.log(id);
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
