import { TestBed } from '@angular/core/testing';

import { HorrodateurService } from './horrodateur.service';

describe('HorrodateurService', () => {
  let service: HorrodateurService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HorrodateurService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
