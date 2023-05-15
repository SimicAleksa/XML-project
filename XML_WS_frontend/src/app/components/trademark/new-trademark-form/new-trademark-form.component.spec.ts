import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewTrademarkFormComponent } from './new-trademark-form.component';

describe('NewTrademarkFormComponent', () => {
  let component: NewTrademarkFormComponent;
  let fixture: ComponentFixture<NewTrademarkFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NewTrademarkFormComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NewTrademarkFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
