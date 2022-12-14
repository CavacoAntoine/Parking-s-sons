import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { HttpClientModule } from "@angular/common/http";
import { ParkingComponent } from './components/parking/parking.component';
import { FormsModule } from "@angular/forms";
import { ParkingsListComponent } from './components/parkings-list/parkings-list.component';
import { ParkingCreateComponent } from './components/parking-create/parking-create.component';
import { HomeComponent } from './components/home/home.component';
import {AppRoutingModule} from "./app-routing.module";
import { ProblemesComponent } from './components/problemes/problemes.component';
import { HorodateurComponent } from './components/horodateur/horodateur.component';
import { RouterModule } from "@angular/router";

@NgModule({
  declarations: [
    AppComponent,
    ParkingComponent,
    ParkingsListComponent,
    ParkingCreateComponent,
    HomeComponent,
    ProblemesComponent,
    HorodateurComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
