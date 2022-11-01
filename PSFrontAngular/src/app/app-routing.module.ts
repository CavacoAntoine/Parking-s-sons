import { NgModule } from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {HomeComponent} from "./components/home/home.component";
import {ParkingsListComponent} from "./components/parkings-list/parkings-list.component";
import {ParkingCreateComponent} from "./components/parking-create/parking-create.component";

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'parkings-list', component: ParkingsListComponent },
  { path: 'parkings-create', component: ParkingCreateComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
