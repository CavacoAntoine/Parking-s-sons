import { NgModule } from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {HomeComponent} from "./components/home/home.component";
import {ParkingsListComponent} from "./components/parkings-list/parkings-list.component";

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'parkings-list', component: ParkingsListComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
