import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {Horodateur} from "../../models/horodateur/horodateur";
import {HorodateurService} from "../../services/horodateur/horodateur.service";
import {ParkingService} from "../../services/parking/parking.service";
import {Parking} from "../../models/parking/parking";

@Component({
  selector: 'app-horodateur',
  templateUrl: './horodateur.component.html',
  styleUrls: ['./horodateur.component.css']
})
export class HorodateurComponent implements OnInit {

  horodateur: Horodateur
  parking: Parking;

  constructor(private activatedRoute : ActivatedRoute, private horodateurService: HorodateurService, private parkingService: ParkingService) {
    this.horodateur = new Horodateur();
    this.parking = new Parking();
  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(params =>{
      this.horodateurService.getHorodateurById(<string>params.get('id')).subscribe(horodateur => {
        this.horodateur = horodateur
        horodateur.dateDepart = new Date(horodateur.dateDepart);
        horodateur.dateArrivee = new Date(horodateur.dateArrivee);
        this.parkingService.getParkingByPlaceId(horodateur.place.id.toString()).subscribe( parking => this.parking = parking);
      });


    });
  }

  depassement(horodateur: Horodateur): Date {
    let date = new Date();
    let diff = date.getTime() - horodateur.dateDepart.getTime();
    date = new Date(diff);
    return date;
  }

}
