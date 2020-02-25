import {Sector} from './Sector';
import {Bath} from './Bath';
import {Planning} from './Planning';

export interface Employee{
  id:number;
  lastname:string;
  firstname:string;
  address:string;
  birthDate:string;
  ssNumber:string;
  manager:string;
  sectors:Array<Sector>;
  baths:Array<Bath>;
  plannings:Array<Planning>;
}
