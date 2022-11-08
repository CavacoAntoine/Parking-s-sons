import { NgModule } from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {HomeComponent} from "./components/home/home.component";
import {ParkingsListComponent} from "./components/parkings-list/parkings-list.component";
import {ParkingCreateComponent} from "./components/parking-create/parking-create.component";
import {ParkingComponent} from "./components/parking/parking.component";
import {ProblemesComponent} from "./components/problemes/problemes.component";
import {HorodateurComponent} from "./components/horodateur/horodateur.component";

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'problemes', component: ProblemesComponent },
  { path: 'parkings-list', component: ParkingsListComponent },
  { path: 'parkings-create', component: ParkingCreateComponent },
  { path: 'parking/:id', component: ParkingComponent },
  { path: 'horodateur/:id', component: HorodateurComponent },
  { path: '**', component: HomeComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
