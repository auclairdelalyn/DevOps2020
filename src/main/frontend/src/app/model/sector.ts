import {Bath} from './Bath';
import {Employee} from './Employee';

export interface Sector{
  id:number;
  name:string;
  localisation:string;
  baths:Array<Bath>;
  persons:Array<Employee>
}
