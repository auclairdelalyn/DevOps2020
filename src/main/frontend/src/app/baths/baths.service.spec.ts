import { TestBed } from '@angular/core/testing';

import { BathsService } from './baths.service';

describe('BathsService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: BathsService = TestBed.get(BathsService);
    expect(service).toBeTruthy();
  });
});
