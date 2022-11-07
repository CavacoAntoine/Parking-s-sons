import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {Parking} from "../../models/parking/parking";
import {ParkingService} from "../../services/parking/parking.service";
import {TypeCar} from "../../models/type-car";
import {Horrodateur} from "../../models/horrodateur/horrodateur";
import {HorrodateurService} from "../../services/horrodateur/horrodateur.service";

@Component({
  selector: 'app-parking',
  templateUrl: './parking.component.html',
  styleUrls: ['./parking.component.css']
})
export class ParkingComponent implements OnInit {

  parking: Parking;
  nbrPlaceNormale = 0;
  nbrPlaceHandi = 0;
  nbrPlaceDeuxR = 0;
  nbrPlacePL = 0;
  nbrPlaceElec = 0;
  problematiques: Array<Horrodateur>;


  constructor(private activatedRoute : ActivatedRoute, private parkingService: ParkingService, private horrodateurService: HorrodateurService) {
    this.parking = new Parking();
    this.problematiques = new Array<Horrodateur>();
  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(params =>{
      this.parkingService.getParking(<string>params.get('id')).subscribe(
        parking =>{
          this.parking = parking;
          this.nbrPlaceNormale = this.parking.places.filter((value, index, array) => {
            return value.type == TypeCar.NORMALE && value.libre;
          }).length;
          this.nbrPlaceHandi = parking.places.filter((value, index, array) => {
            return value.type == TypeCar.HANDICAPE && value.libre;
          }).length;
          this.nbrPlaceDeuxR = parking.places.filter((value, index, array) => {
            return value.type == TypeCar.DEUX_ROUES && value.libre;
          }).length;
          this.nbrPlacePL = parking.places.filter((value, index, array) => {
            return value.type == TypeCar.LONG && value.libre;
          }).length;
          this.nbrPlaceElec = parking.places.filter((value, index, array) => {
            return value.type == TypeCar.ELECTRIQUE && value.libre;
          }).length;
        });

      this.horrodateurService.getBadHorrodateurFromParkingId(<string>params.get('id')).subscribe(
        horrodateurs => {
          horrodateurs.forEach(horrodateur => {
            horrodateur.dateDepart = new Date(horrodateur.dateDepart);
            horrodateur.dateArrivee = new Date(horrodateur.dateArrivee);
          });
          this.problematiques = horrodateurs;
        }
      );
    });
  }

  depassement(horrodateur: Horrodateur): Date {
    let date = new Date();
    let diff = date.getTime() - horrodateur.dateDepart.getTime();
    date = new Date(diff);
    return date;
  }

}
