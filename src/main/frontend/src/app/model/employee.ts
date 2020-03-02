import {Sector} from './Sector';
import {Bath} from './Bath';
import {Planning} from './Planning';

export class Employee{
  id:number;
  login:string;
  password:string;
  lastname:string;
  firstname:string;
  address:string;
  birthdate:string;
  ssnumber:string;
  sectors:Array<Sector>;
  manager:boolean;
  //baths:Array<Bath>;
  //plannings:Array<Planning>;
  constructor(){}
}
