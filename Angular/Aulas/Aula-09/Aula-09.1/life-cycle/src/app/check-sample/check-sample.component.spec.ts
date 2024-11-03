import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CheckSampleComponent } from './check-sample.component';

describe('CheckSampleComponent', () => {
  let component: CheckSampleComponent;
  let fixture: ComponentFixture<CheckSampleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CheckSampleComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CheckSampleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
