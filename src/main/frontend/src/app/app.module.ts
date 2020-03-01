import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BathsComponent } from './baths/baths.component';
import { RouterModule, Routes } from '@angular/router';
import {HttpClientModule} from '@angular/common/http';
import { AnimalsComponent } from './animals/animals.component';
import { EmployeesComponent } from './employees/employees.component';
import { PlanningsComponent } from './plannings/plannings.component';
import { SectorsComponent } from './sectors/sectors.component';
import { FormsModule } from '@angular/forms';
import { SpeciesComponent } from './species/species.component';

@NgModule({
  declarations: [
    AppComponent,
    BathsComponent,
    AnimalsComponent,
    EmployeesComponent,
    PlanningsComponent,
    SectorsComponent,
    SpeciesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
