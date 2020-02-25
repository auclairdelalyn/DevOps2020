import {Animal} from './Animal';

export interface Species{
  id:number;
  esperance:number;
  regime:string;
  endangered:number;
  animals:Array<Animal>;
}
