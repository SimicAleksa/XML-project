import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TmAdvancedSearchComponent } from './tm-advanced-search.component';

describe('TmAdvancedSearchComponent', () => {
  let component: TmAdvancedSearchComponent;
  let fixture: ComponentFixture<TmAdvancedSearchComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TmAdvancedSearchComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TmAdvancedSearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
