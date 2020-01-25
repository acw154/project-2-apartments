import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreatepropComponent } from './createprop.component';

describe('CreatepropComponent', () => {
  let component: CreatepropComponent;
  let fixture: ComponentFixture<CreatepropComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreatepropComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreatepropComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
