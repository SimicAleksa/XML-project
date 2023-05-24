import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewCopyrightFormComponent } from './new-copyright-form.component';

describe('NewCopyrightFormComponent', () => {
  let component: NewCopyrightFormComponent;
  let fixture: ComponentFixture<NewCopyrightFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NewCopyrightFormComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NewCopyrightFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
