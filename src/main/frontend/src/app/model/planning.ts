import {Bath} from './Bath';
import {Employee} from './Employee';

export interface Planning{
  id:number;
  name:string;
  hour:number;
  minutes:number;
  day:string;
  isPublic:string;
  bath:Bath;
  employees:Array<Employee>;
}
