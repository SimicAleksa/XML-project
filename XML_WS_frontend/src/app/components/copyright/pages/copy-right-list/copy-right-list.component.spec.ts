import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CopyRightListComponent } from './copy-right-list.component';

describe('CopyRightListComponent', () => {
  let component: CopyRightListComponent;
  let fixture: ComponentFixture<CopyRightListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CopyRightListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CopyRightListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
