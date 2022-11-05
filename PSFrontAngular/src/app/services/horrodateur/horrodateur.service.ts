import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {Horrodateur} from "../../models/horrodateur/horrodateur";

const httpOptions = {
  headers: new HttpHeaders({'content-type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class HorrodateurService {

  private horrodateurUrl = 'http://localhost:8080/horrodateur';

  constructor(private http: HttpClient) { }

  getBadHorrodateurFromParkingId(id : string) : Observable<Array<Horrodateur>> {
    const url = `${this.horrodateurUrl}/bad/${id}`;
    return this.http.get<Array<Horrodateur>>(url);
  }
}
