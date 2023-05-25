import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CrBasicSearchPageComponent } from './cr-basic-search-page.component';

describe('CrBasicSearchPageComponent', () => {
  let component: CrBasicSearchPageComponent;
  let fixture: ComponentFixture<CrBasicSearchPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CrBasicSearchPageComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CrBasicSearchPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
