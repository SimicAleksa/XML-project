import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TrademarkFormComponent } from './trademark-form.component';

describe('TrademarkFormComponent', () => {
  let component: TrademarkFormComponent;
  let fixture: ComponentFixture<TrademarkFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TrademarkFormComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TrademarkFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
