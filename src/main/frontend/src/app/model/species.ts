import {Animal} from './Animal';

export interface Species{
  id:number;
  name:string;
  esperance:number;
  regime:string;
  endangered:number;
  animals:Array<Animal>;
}
