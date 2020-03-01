import {Sector} from './Sector';
import {Animal} from './Animal';
import {Employee} from './Employee';
import {Planning} from './Planning';

export class Bath{
  id:number;
  name:string;
  capacity:number;
  volume:number;
  state:string;
  sector:Sector;
  animals:Array<Animal>;
  //plannings:Array<Planning>;
  resp:Employee;
    constructor(){}
}
