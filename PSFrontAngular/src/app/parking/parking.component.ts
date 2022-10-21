import { Component, OnInit } from '@angular/core';
import {Parking} from "./parking";
import {ParkingService} from "./parking.service";
import {ParkingCreator} from "./parking-creator";

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

}
