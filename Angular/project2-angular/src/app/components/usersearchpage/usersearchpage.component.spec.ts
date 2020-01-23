import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UsersearchpageComponent } from './usersearchpage.component';

describe('UsersearchpageComponent', () => {
  let component: UsersearchpageComponent;
  let fixture: ComponentFixture<UsersearchpageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UsersearchpageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UsersearchpageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
