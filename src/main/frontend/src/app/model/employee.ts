import {Sector} from './Sector';
import {Bath} from './Bath';
import {Planning} from './Planning';

export class Employee{
  id:number;
  lastname:string;
  firstname:string;
  address:string;
  birthdate:string;
  ssnumber:string;
  sectors:Array<Sector>;
  //baths:Array<Bath>;
  //plannings:Array<Planning>;
  constructor(){}
}
