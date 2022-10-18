import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Personne} from "./personne";
import {catchError, Observable, of, tap} from "rxjs";

const httpOptions = {
  headers: new HttpHeaders({'content-type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class PersonneService {

  private personneUrl = 'http://localhost:8080/personne';

  constructor(private http: HttpClient) { }

  getPersonneByEmail(email: string): Observable<Personne>{
    const url =`${this.personneUrl}/${email}`;
    return this.http.get<Personne>(url).pipe(
      tap(),
      catchError(this.handleError<Personne>(`getPersonneByEmail email=${email}`))
    );
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      this.log(`${operation} failed : ${error.message}`);
      return of(result as T);
    };
  }

  private log(message: string) {
    console.log('PersonneService: ' + message);
  }

}
