import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {catchError, Observable, of, tap} from "rxjs";
import {Parking} from "../../models/parking/parking";
import {ParkingCreator} from "../../models/parking/parking-creator";

const httpOptions = {
  headers: new HttpHeaders({'content-type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class ParkingService {

  private parkingUrl = 'http://localhost:8080/parking';

  constructor(private http: HttpClient) { }

  getParking(id: string) : Observable<Parking> {
    const url = `${this.parkingUrl}/${id}`;
    return this.http.get<Parking>(url);
  }

  getParkingByPlaceId(id: string) : Observable<Parking> {
    const url = `${this.parkingUrl}/place/${id}`;
    return this.http.get<Parking>(url);
  }

  getAllParkings(): Observable<Array<Parking>>{
    return this.http.get<Array<Parking>>(this.parkingUrl).pipe(
      tap(),
      catchError(this.handleError<Array<Parking>>(`getAllParking `))
    );
  }

  getAllBadParkings(): Observable<Array<Parking>>{
    const url = `${this.parkingUrl}/bad`;
    return this.http.get<Array<Parking>>(url).pipe(
      tap(),
      catchError(this.handleError<Array<Parking>>(`getAllBadParking `))
    );
  }

  getParkingsLibres(): Observable<Array<Parking>>{
    const url = `${this.parkingUrl}/libres`;
    return this.http.get<Array<Parking>>(url).pipe(
      tap(),
      catchError(this.handleError<Array<Parking>>(`getParkingsLibres `))
    );
  }

  getParkingsComplets(): Observable<Array<Parking>>{
    const url = `${this.parkingUrl}/complets`;
    return this.http.get<Array<Parking>>(url).pipe(
      tap(),
      catchError(this.handleError<Array<Parking>>(`getParkingsComplets `))
    );
  }

  addParking(parking: ParkingCreator): Observable<Parking>{
    return this.http.post<Parking>(this.parkingUrl, parking, httpOptions);
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
