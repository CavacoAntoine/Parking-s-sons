import { Component, OnInit } from '@angular/core';
import {ParkingCreator} from "../../models/parking/parking-creator";
import {ParkingService} from "../../services/parking/parking.service";

@Component({
  selector: 'app-parking-create',
  templateUrl: './parking-create.component.html',
  styleUrls: ['./parking-create.component.css']
})
export class ParkingCreateComponent implements OnInit {
  parking: ParkingCreator;
  ok = false;

  constructor(private parkingService: ParkingService) { }

  ngOnInit(): void {
    this.parking = new ParkingCreator();
  }

  onSubmit(): void {
    this.parkingService.addParking(this.parking).subscribe(
      _=>{
        this.ok = true;
      },
      error => {
        console.log(error);
        this.ok=false;
      }
    );
  }
}
