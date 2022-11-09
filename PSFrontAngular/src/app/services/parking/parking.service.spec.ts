import { TestBed } from '@angular/core/testing';

import { ParkingService } from './parking.service';
import {HttpClientTestingModule} from "@angular/common/http/testing";

describe('ParkingService', () => {
  let service: ParkingService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [ HttpClientTestingModule ],
    });
    service = TestBed.inject(ParkingService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
