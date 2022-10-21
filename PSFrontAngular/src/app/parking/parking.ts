import {Place} from "./place/place";
import {Adresse} from "../adresse/adresse";

export class Parking {

  id: number;
  nom: string;
  places: Array<Place>;
  adresse: Adresse;

  constructor() {
    this.adresse = new Adresse();
    this.places = new Array<Place>();
  }

}
