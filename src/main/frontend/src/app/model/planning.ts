import {Bath} from './Bath';
import {Employee} from './Employee';

export class Planning{
  id:number;
  name:string;
  hour:number;
  minutes:number;
  day:string;
  ispublic:boolean;
  bath:Bath;
  employees:Array<Employee>;
  constructor(){}
}
