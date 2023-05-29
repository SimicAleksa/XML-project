import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PatentBasicSearchPageComponent } from './patent-basic-search-page.component';

describe('PatentBasicSearchPageComponent', () => {
  let component: PatentBasicSearchPageComponent;
  let fixture: ComponentFixture<PatentBasicSearchPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PatentBasicSearchPageComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PatentBasicSearchPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
