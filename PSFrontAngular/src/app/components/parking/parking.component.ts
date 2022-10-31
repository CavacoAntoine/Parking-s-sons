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

  constructor(private parkingService: ParkingService) { }

  ngOnInit(): void {
  }

}
