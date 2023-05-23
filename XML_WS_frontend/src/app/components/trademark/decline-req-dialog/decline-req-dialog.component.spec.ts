import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeclineReqDialogComponent } from './decline-req-dialog.component';

describe('DeclineReqDialogComponent', () => {
  let component: DeclineReqDialogComponent;
  let fixture: ComponentFixture<DeclineReqDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DeclineReqDialogComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DeclineReqDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
