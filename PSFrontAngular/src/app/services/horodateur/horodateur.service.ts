import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Horodateur} from "../../models/horodateur/horodateur";

@Injectable({
  providedIn: 'root'
})
export class HorodateurService {

  private horodateurUrl = 'http://localhost:8080/horrodateur';

  constructor(private http: HttpClient) { }

  getBadHorodateurFromParkingId(id : string) : Observable<Array<Horodateur>> {
    const url = `${this.horodateurUrl}/bad/${id}`;
    return this.http.get<Array<Horodateur>>(url);
  }
}
