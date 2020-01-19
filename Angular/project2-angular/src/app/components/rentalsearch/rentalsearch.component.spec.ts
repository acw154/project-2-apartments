import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RentalsearchComponent } from './rentalsearch.component';

describe('RentalsearchComponent', () => {
  let component: RentalsearchComponent;
  let fixture: ComponentFixture<RentalsearchComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RentalsearchComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RentalsearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
