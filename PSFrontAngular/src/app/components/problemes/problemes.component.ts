import {Component, OnInit} from '@angular/core';
import {Horodateur} from "../../models/horodateur/horodateur";
import {ParkingService} from "../../services/parking/parking.service";
import {HorodateurService} from "../../services/horodateur/horodateur.service";

@Component({
  selector: 'app-problemes',
  templateUrl: './problemes.component.html',
  styleUrls: ['./problemes.component.css']
})
export class ProblemesComponent implements OnInit {

  problemes: Map<string, Array<Horodateur>>;
  keys: Array<string>;
  wait = false;
  tpsDepassee: Map<number, Date>;

  constructor(private parkingService: ParkingService, private horodateurService: HorodateurService) {
    this.problemes = new Map<string, Array<Horodateur>>();
    this.keys = new Array<string>();
    this.tpsDepassee = new Map<number, Date>();
  }

  ngOnInit(): void {
    this.parkingService.getAllBadParkings().subscribe(
      parkings => {
        parkings.forEach(
          parking => {
            this.keys.push(parking.nom);
            this.horodateurService.getBadHorodateurFromParkingId(parking.id.toString()).subscribe(
              horodateurs => {
                horodateurs.forEach(horodateur => {
                  horodateur.dateDepart = new Date(horodateur.dateDepart);
                  horodateur.dateArrivee = new Date(horodateur.dateArrivee);
                  if(horodateur.dureeDepasse){
                    this.tpsDepassee.set(horodateur.id,this.depassement(horodateur));
                  }
                });
                this.problemes.set(parking.nom, horodateurs);
              }
            );
          });
      }
    );
  }

  depassement(horodateur: Horodateur): Date {
    let date = new Date();
    let diff = date.getTime() - horodateur.dateDepart.getTime();
    date = new Date(diff);
    return date;
  }

}
