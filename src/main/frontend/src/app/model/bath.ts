import {Sector} from './Sector';
import {Animal} from './Animal';
import {Employee} from './Employee';
import {Planning} from './Planning';

export interface Bath{
  id:number;
  name:string;
  capacity:number;
  volume:number;
  state:number;
  sector:Sector;
  animals:Array<Animal>;
  planning:Array<Planning>;
  resp:Employee;
}
