import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CopyRightRequestsPageComponent } from './copy-right-patent-requests-page.component';

describe('CopyRightPatentRequestsPageComponent', () => {
  let component: CopyRightRequestsPageComponent;
  let fixture: ComponentFixture<CopyRightRequestsPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CopyRightRequestsPageComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CopyRightRequestsPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
