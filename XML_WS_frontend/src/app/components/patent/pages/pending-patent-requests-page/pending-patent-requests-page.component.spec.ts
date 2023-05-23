import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PendingPatentRequestsPageComponent } from './pending-patent-requests-page.component';

describe('PendingPatentRequestsPageComponent', () => {
  let component: PendingPatentRequestsPageComponent;
  let fixture: ComponentFixture<PendingPatentRequestsPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PendingPatentRequestsPageComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PendingPatentRequestsPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
