import {Adresse} from "../adresse/adresse";

export class ParkingCreator {
  nom: string;
  nbrNormPlace: number;
  nbrHandiPlace: number;
  nbrDeuxRPlace: number;
  nbrLongPlace: number;
  nbrElecPlace: number;
  adresse: Adresse;

  constructor() {
    this.adresse = new Adresse();
  }

}
