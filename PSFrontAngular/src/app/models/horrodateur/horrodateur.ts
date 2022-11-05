import {Place} from "../place/place";
import {Voiture} from "../Voiture/voiture";

export class Horrodateur {

  id: number;
  voiture: Voiture;
  place: Place;
  dateArrivee: Date;
  dateDepart: Date;
  dureeDepasse: boolean;
  malGare: boolean;
}
