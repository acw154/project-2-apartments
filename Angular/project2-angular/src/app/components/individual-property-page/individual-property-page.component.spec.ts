import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IndividualPropertyPageComponent } from './individual-property-page.component';

describe('IndividualPropertyPageComponent', () => {
  let component: IndividualPropertyPageComponent;
  let fixture: ComponentFixture<IndividualPropertyPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IndividualPropertyPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IndividualPropertyPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
