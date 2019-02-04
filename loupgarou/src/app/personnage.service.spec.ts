import { TestBed } from '@angular/core/testing';

import { PersonnagesService } from './personnages.service';

describe('PersonnagesService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: PersonnagesService = TestBed.get(PersonnagesService);
    expect(service).toBeTruthy();
  });
});
