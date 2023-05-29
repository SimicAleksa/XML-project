import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PatentAdvancedSearchComponent } from './patent-advanced-search.component';

describe('PatentAdvancedSearchComponent', () => {
  let component: PatentAdvancedSearchComponent;
  let fixture: ComponentFixture<PatentAdvancedSearchComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PatentAdvancedSearchComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PatentAdvancedSearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
