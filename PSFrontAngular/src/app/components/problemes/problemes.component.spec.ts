import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProblemesComponent } from './problemes.component';
import {HttpClientTestingModule} from "@angular/common/http/testing";
import {RouterTestingModule} from "@angular/router/testing";

describe('ProblemesComponent', () => {
  let component: ProblemesComponent;
  let fixture: ComponentFixture<ProblemesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProblemesComponent ],
      imports: [ HttpClientTestingModule, RouterTestingModule ],
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProblemesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
