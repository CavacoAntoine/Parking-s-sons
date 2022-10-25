import { Component, OnInit } from '@angular/core';
import {Parking} from "../../models/parking/parking";
import {ParkingService} from "../../services/parking/parking.service";
import {ParkingCreator} from "../../models/parking/parking-creator";

@Component({
  selector: 'app-parking',
  templateUrl: './parking.component.html',
  styleUrls: ['./parking.component.css']
})
export class ParkingComponent implements OnInit {

  listParkings: Array<Parking> = new Array<Parking>();
  parking: ParkingCreator;
  ok = false;

  constructor(private parkingService: ParkingService) { }

  ngOnInit(): void {
    this.parkingService.getAllParkings().subscribe(parkings => {
      this.listParkings = parkings;
    });
    this.parking = new ParkingCreator();
  }

  onSubmit(): void {
    this.parkingService.addParking(this.parking).subscribe(
      data=>{
        this.listParkings.push(data);
        this.ok = true;
      },
      error => {
        console.log(error);
        this.ok=false;
      }
    );
  }

  placeLibre(parking : Parking) : number {
    return parking.places.filter(function (value,index, array) {
      return value.libre;
    }).length;
  }

}
