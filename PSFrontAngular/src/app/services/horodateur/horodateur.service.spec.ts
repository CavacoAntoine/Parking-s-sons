import { TestBed } from '@angular/core/testing';

import { HorodateurService } from './horodateur.service';

describe('HorrodateurService', () => {
  let service: HorodateurService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HorodateurService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
