import { Component } from '@angular/core';
import { RouterModule, Routes, ActivatedRoute } from '@angular/router';
import { BathsComponent } from "./baths/baths.component";
import { AnimalsComponent } from "./animals/animals.component";
import { EmployeesComponent } from "./employees/employees.component";
import { PlanningsComponent } from "./plannings/plannings.component";
import { SectorsComponent } from "./sectors/sectors.component";
import { SpeciesComponent } from "./species/species.component";
import { ConnexionComponent } from "./connexion/connexion.component";
import { ConnexionService } from "./connexion/connexion.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'frontend';
  connexionKey:string;
  manager:boolean;
  id:number;

  species=0;
  sectors=0;
  employees=0;
  animals=0;
  connexion=0;
  plannings=0;
  baths=0;
  constructor(private connexionService:ConnexionService){}

  endConnexion(){
    this.connexionService.disconnect(this.connexionKey);
    this.setBlank(null);
  }
  setSpecies(){
    this.species=1;
    this.sectors=0;
    this.employees=0;
    this.animals=0;
    this.connexion=0;
    this.plannings=0;
    this.baths=0;
  }
  setSectors(){
    this.species=0;
    this.sectors=1;
    this.employees=0;
    this.animals=0;
    this.connexion=0;
    this.plannings=0;
    this.baths=0;
  }
    setEmployees(){
      this.species=0;
      this.sectors=0;
      this.employees=1;
      this.animals=0;
      this.connexion=0;
      this.plannings=0;
      this.baths=0;
    }
    setAnimals(){
      this.species=0;
      this.sectors=0;
      this.employees=0;
      this.animals=1;
      this.connexion=0;
      this.plannings=0;
      this.baths=0;
    }
  setConnexion(){
        this.species=0;
        this.sectors=0;
        this.employees=0;
        this.animals=0;
        this.connexion=1;
        this.plannings=0;
        this.baths=0;
      }
  setPlannings(){
        this.species=0;
        this.sectors=0;
        this.employees=0;
        this.animals=0;
        this.connexion=0;
        this.plannings=1;
        this.baths=0;
      }
  setBaths(){
        this.species=0;
        this.sectors=0;
        this.employees=0;
        this.animals=0;
        this.connexion=0;
        this.plannings=0;
        this.baths=1;
      }

  setBlank(event){
          this.species=0;
          this.sectors=0;
          this.employees=0;
          this.animals=0;
          this.connexion=0;
          this.plannings=0;
          this.baths=0;
          this.connexionKey=event;
        }

  setManager(event){
    this.manager=event;
    console.log(this.manager);
  }
  setId(event){
    this.id=event;
    console.log(this.id);
  }
}
