import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TmReportPageComponent } from './tm-report-page.component';

describe('TmReportPageComponent', () => {
  let component: TmReportPageComponent;
  let fixture: ComponentFixture<TmReportPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TmReportPageComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TmReportPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
