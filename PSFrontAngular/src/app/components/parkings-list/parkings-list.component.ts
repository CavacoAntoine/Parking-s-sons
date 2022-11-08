import { Component, OnInit } from '@angular/core';
import {Parking} from "../../models/parking/parking";
import {ParkingService} from "../../services/parking/parking.service";

@Component({
  selector: 'app-parkings-list',
  templateUrl: './parkings-list.component.html',
  styleUrls: ['./parkings-list.component.css']
})
export class ParkingsListComponent implements OnInit {

  listParkingsLibres: Array<Parking> = new Array<Parking>();
  listParkingsComplets: Array<Parking> = new Array<Parking>();
  tab: boolean = true;

  constructor(private parkingService: ParkingService) { }

  ngOnInit(): void {
    this.tab = true;
    this.parkingService.getParkingsLibres().subscribe(parkings => {
      this.listParkingsLibres = parkings;
    });

    this.parkingService.getParkingsComplets().subscribe(parkings => {
      this.listParkingsComplets = parkings;
    });
  }

  placeLibre(parking : Parking) : number {
    return parking.places.filter(function (value) {
      return value.libre;
    }).length;
  }

  tab1() : void {
    this.tab = true;
  }

  tab2() : void {
    this.tab = false;
  }

}
