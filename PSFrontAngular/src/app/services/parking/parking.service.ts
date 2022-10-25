import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {catchError, Observable, of, tap} from "rxjs";
import {Parking} from "../../models/parking/parking";
import {ParkingCreator} from "../../models/parking/parking-creator";
import {Place} from "../../models/place/place";

const httpOptions = {
  headers: new HttpHeaders({'content-type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class ParkingService {

  private parkingUrl = 'http://localhost:8080/parking';

  constructor(private http: HttpClient) { }

  getAllParkings(): Observable<Array<Parking>>{
    return this.http.get<Array<Parking>>(this.parkingUrl).pipe(
      tap(),
      catchError(this.handleError<Array<Parking>>(`getAllParking `))
    );
  }

  addParking(parking: ParkingCreator): Observable<Parking>{
    return this.http.post<Parking>(this.parkingUrl, parking, httpOptions);
  }

  getPlaceLibre(id: number): Observable<Array<Place>>{
    const url = `${this.parkingUrl}/${id}/placelibre`;
    return this.http.get<Array<Place>>(url).pipe(
      tap(),
      catchError(this.handleError<Array<Place>>(`getPlaceLibre for parking : ${id}`))
    );
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      ParkingService.log(`${operation} failed : ${error.message}`);
      return of(result as T);
    };
  }

  private static log(message: string) {
    console.log('ParkingService: ' + message);
  }
}
