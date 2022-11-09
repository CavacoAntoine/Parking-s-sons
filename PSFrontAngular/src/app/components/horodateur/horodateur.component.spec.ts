import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HorodateurComponent } from './horodateur.component';
import {HttpClientTestingModule} from "@angular/common/http/testing";
import {RouterTestingModule} from "@angular/router/testing";

describe('HorodateurComponent', () => {
  let component: HorodateurComponent;
  let fixture: ComponentFixture<HorodateurComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HorodateurComponent ],
      imports: [ HttpClientTestingModule, RouterTestingModule ],
    })
    .compileComponents();

    fixture = TestBed.createComponent(HorodateurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
