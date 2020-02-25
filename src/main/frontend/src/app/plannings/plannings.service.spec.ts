import { TestBed } from '@angular/core/testing';

import { PlanningsService } from './plannings.service';

describe('PlanningsService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: PlanningsService = TestBed.get(PlanningsService);
    expect(service).toBeTruthy();
  });
});
