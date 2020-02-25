import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BathsComponent } from "./baths/baths.component";
import { AnimalsComponent } from "./animals/animals.component";
import { EmployeesComponent } from "./employees/employees.component";
import { PlanningsComponent } from "./plannings/plannings.component";
import { SectorsComponent } from "./sectors/sectors.component";
import { SpeciesComponent } from "./species/species.component";

const routes: Routes = [
  {
      path: 'baths',
      component:BathsComponent
  },
  {
      path: 'animals',
      component:AnimalsComponent
  },
  {
      path: 'employees',
      component:EmployeesComponent
  },
  {
      path: 'plannings',
      component:PlanningsComponent
  },
  {
      path: 'sectors',
      component:SectorsComponent
  },
  {
      path: 'species',
      component:SpeciesComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
