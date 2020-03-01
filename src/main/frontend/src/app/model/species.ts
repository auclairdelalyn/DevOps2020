import {Animal} from './Animal';

export class Species{
  id:number;
  name:string;
  esperance:number;
  regime:string;
  endangered:number;
  animals:Array<Animal>;
    constructor(){};
}
