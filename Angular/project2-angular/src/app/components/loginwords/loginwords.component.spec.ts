import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginwordsComponent } from './loginwords.component';

describe('LoginwordsComponent', () => {
  let component: LoginwordsComponent;
  let fixture: ComponentFixture<LoginwordsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LoginwordsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginwordsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
