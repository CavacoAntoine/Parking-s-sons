import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ParkingCreateComponent } from './parking-create.component';

describe('ParkingCreateComponent', () => {
  let component: ParkingCreateComponent;
  let fixture: ComponentFixture<ParkingCreateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ParkingCreateComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ParkingCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
