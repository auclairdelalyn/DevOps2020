import {Species} from './Species';
import {Bath} from './Bath';

export interface Animal{
      id:number;
      name:string;
      sex:string;
      distinction:string;
      arrival:string;
      departure:string;
      species:Species;
      bath:Bath;
}
