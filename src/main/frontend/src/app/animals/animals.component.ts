import {Component, EventEmitter, OnInit, Input, Output} from '@angular/core';
import {AnimalsService} from "./animals.service";
import {Animal} from "../model/animal";
import {BathsService} from "../baths/baths.service";
import {Bath} from "../model/bath";
import {SpeciesService} from "../species/species.service";
import {Species} from "../model/species";
import {Observable} from "rxjs";
import { filter, map } from 'rxjs/operators';
import { RouterModule, Routes, Router } from '@angular/router';
import { HttpClientModule } from "@angular/common/http";

@Component({
  selector: 'app-animals',
  templateUrl: './animals.component.html',
  styleUrls: ['./animals.component.css']
})
export class AnimalsComponent implements OnInit {
  @Input() key:string;
  @Output() setKey = new EventEmitter<string>();
  @Input() manager:boolean;
  @Input() id:number;
  animals: Observable<Animal[]>;
  selected: Animal;

  species: Observable<Species[]>;
  baths: Observable<Bath[]>;
  animal:Animal;

  select(element){
        this.selected = element;
  }

    constructor(private animalsService: AnimalsService, private speciesService: SpeciesService, private bathsService: BathsService, private router:Router) {
       this.animal=new Animal;
    }

    ngOnInit() {
      this.reloadData();
      this.species=this.speciesService.getAll();
      this.baths=this.bathsService.getAll();
    }

    reloadData() {
      this.animals = this.animalsService.getAll().pipe(map(animal=>animal.filter(ani=>ani.departure==null)));
    }

    deleteAnimal(id: number) {
      this.animalsService.deleteAnimal(id).subscribe(
                                                    data => {
                                                      console.log(data);
                                                      this.reloadData();
                                                    },
                                                    error => console.log(error));
    }

    onSubmit() {
            if(this.animal.arrival==null){
              let today = new Date();
              this.animal.arrival=today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate();
            }
            console.log(this.animal);
            this.animalsService.createAnimal(this.animal).subscribe(result => this.router.navigate(['']));
    }

    end(){
        console.log(this.selected);
        if(this.selected.arrival!=null && this.selected.departure==null){
            let today = new Date();
            this.selected.departure=today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate();
            //this.selected.bath=null;
        }
        this.animalsService.createAnimal(this.selected).subscribe(result => this.setKey.emit(this.key));
    }

    reset(){
            this.animal=new Animal();
    }
    edit(ani){
            this.animal=ani;
    }
}
