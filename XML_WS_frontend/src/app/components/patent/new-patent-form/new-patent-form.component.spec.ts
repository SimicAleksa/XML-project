import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewPatentFormComponent } from './new-patent-form.component';

describe('NewPatentFormComponent', () => {
  let component: NewPatentFormComponent;
  let fixture: ComponentFixture<NewPatentFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NewPatentFormComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NewPatentFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
