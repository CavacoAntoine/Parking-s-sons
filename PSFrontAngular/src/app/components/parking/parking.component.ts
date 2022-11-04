import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {Parking} from "../../models/parking/parking";
import {ParkingService} from "../../services/parking/parking.service";
import {TypeCar} from "../../models/type-car";

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


  constructor(private activatedRoute : ActivatedRoute, private parkingService: ParkingService) {
    this.parking = new Parking();
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

    });
  }
}
