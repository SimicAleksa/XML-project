import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TmBasicSearchPageComponent } from './tm-basic-search-page.component';

describe('TmBasicSearchPageComponent', () => {
  let component: TmBasicSearchPageComponent;
  let fixture: ComponentFixture<TmBasicSearchPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TmBasicSearchPageComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TmBasicSearchPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
