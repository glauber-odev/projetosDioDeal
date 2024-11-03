import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CompAtributosComponent } from './comp-atributos.component';

describe('CompAtributosComponent', () => {
  let component: CompAtributosComponent;
  let fixture: ComponentFixture<CompAtributosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CompAtributosComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CompAtributosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
