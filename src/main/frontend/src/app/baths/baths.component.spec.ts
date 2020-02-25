import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BathsComponent } from './baths.component';

describe('BathsComponent', () => {
  let component: BathsComponent;
  let fixture: ComponentFixture<BathsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BathsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BathsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
