import { TestBed } from '@angular/core/testing';

import { HorodateurService } from './horodateur.service';
import {HttpClientTestingModule} from "@angular/common/http/testing";
import {RouterTestingModule} from "@angular/router/testing";

describe('HorrodateurService', () => {
  let service: HorodateurService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [ HttpClientTestingModule ],
    });
    service = TestBed.inject(HorodateurService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
