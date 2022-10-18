import { Component, OnInit } from '@angular/core';
import {Personne} from "./personne";
import {PersonneService} from "./personne.service";

@Component({
  selector: 'app-personne',
  templateUrl: './personne.component.html',
  styleUrls: ['./personne.component.css']
})
export class PersonneComponent implements OnInit {

  personne: Personne;

  constructor(private personneService: PersonneService) { }

  ngOnInit(): void {
    this.personne = new Personne();
  }

  search(event: KeyboardEvent): void {
    let email = (<HTMLInputElement>event.target).value;
    if (email.length > 4) {
      this.personneService.getPersonneByEmail(email).subscribe(personne =>{
        if(personne != null) {
          this.personne = personne;
        } else {
          this.personne.email ="";
          this.personne.prenom="";
          this.personne.nom ="";
          this.personne.age= -1;
        }
      });
    }
  }



}
