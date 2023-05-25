import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CrAdvancedSearchComponent } from './cr-advanced-search.component';

describe('CrAdvancedSearchComponent', () => {
  let component: CrAdvancedSearchComponent;
  let fixture: ComponentFixture<CrAdvancedSearchComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CrAdvancedSearchComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CrAdvancedSearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
