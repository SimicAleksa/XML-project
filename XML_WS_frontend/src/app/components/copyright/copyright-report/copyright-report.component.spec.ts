import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CopyrightReportComponent } from './copyright-report.component';

describe('CopyrightReportComponent', () => {
  let component: CopyrightReportComponent;
  let fixture: ComponentFixture<CopyrightReportComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CopyrightReportComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CopyrightReportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
