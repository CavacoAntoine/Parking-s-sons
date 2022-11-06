import {Component, OnInit} from '@angular/core';
import {Horrodateur} from "../../models/horrodateur/horrodateur";
import {ParkingService} from "../../services/parking/parking.service";
import {HorrodateurService} from "../../services/horrodateur/horrodateur.service";

@Component({
  selector: 'app-problemes',
  templateUrl: './problemes.component.html',
  styleUrls: ['./problemes.component.css']
})
export class ProblemesComponent implements OnInit {

  problemes: Map<string, Array<Horrodateur>>;
  keys: Array<string>;
  wait = false;

  constructor(private parkingService: ParkingService, private horrodateurService: HorrodateurService) {
    this.problemes = new Map<string, Array<Horrodateur>>();
    this.keys = new Array<string>();
  }

  ngOnInit(): void {
    this.parkingService.getAllBadParkings().subscribe(
      parkings => {
        parkings.forEach(
          parking => {
            this.keys.push(parking.nom);
            this.horrodateurService.getBadHorrodateurFromParkingId(parking.id.toString()).subscribe(
              horrodateurs => {
                horrodateurs.forEach(horrodateur => {
                  horrodateur.dateDepart = new Date(horrodateur.dateDepart);
                  horrodateur.dateArrivee = new Date(horrodateur.dateArrivee);
                });
                this.problemes.set(parking.nom, horrodateurs);
              }
            );
          });
      }
    );
  }

  depassement(horrodateur: Horrodateur): Date {
    let date = new Date();
    let diff = date.getTime() - horrodateur.dateDepart.getTime();
    date = new Date(diff);
    return date;
  }

}
