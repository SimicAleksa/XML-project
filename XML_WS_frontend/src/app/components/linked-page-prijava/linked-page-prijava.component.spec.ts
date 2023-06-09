import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LinkedPagePrijavaComponent } from './linked-page-prijava.component';

describe('LinkedPagePrijavaComponent', () => {
  let component: LinkedPagePrijavaComponent;
  let fixture: ComponentFixture<LinkedPagePrijavaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LinkedPagePrijavaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LinkedPagePrijavaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
