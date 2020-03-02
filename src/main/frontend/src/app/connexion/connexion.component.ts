import {Component, EventEmitter, OnInit, Input, Output} from '@angular/core';
import {ConnexionService} from "./connexion.service"
import {Observable} from "rxjs";
import { filter, map } from 'rxjs/operators';
import { RouterModule, Routes, Router } from '@angular/router';
import { HttpClientModule } from "@angular/common/http";

@Component({
  selector: 'app-connexion',
  templateUrl: './connexion.component.html',
  styleUrls: ['./connexion.component.css']
})
export class ConnexionComponent implements OnInit {
  @Input() key:string;
  @Output() setKey = new EventEmitter<string>();
  @Input() manager:boolean;
  @Output() setManager = new EventEmitter<boolean>();
  @Input() id:number;
  @Output() setId = new EventEmitter<number>();
  login:string;
  password:string;
  constructor(private connexionService:ConnexionService, private router:Router) { }

  ngOnInit() {
  }

  onSubmit(){
    console.log(this.login);
    console.log(this.password);
    //this.key="aaaaa";

    this.connexionService.manager(this.login, this.password).subscribe(result => {this.manager=result;this.setManager.emit(this.manager);});
    this.connexionService.id(this.login, this.password).subscribe(result => {this.id=result;this.setId.emit(this.id);});
    this.connexionService.connect(this.login, this.password).subscribe(result => {this.key=result;this.setKey.emit(this.key);});
  }
}
