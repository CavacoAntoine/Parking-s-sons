import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HorodateurComponent } from './horodateur.component';

describe('HorodateurComponent', () => {
  let component: HorodateurComponent;
  let fixture: ComponentFixture<HorodateurComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HorodateurComponent ]
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
