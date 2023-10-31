import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GerenciadorTarefasComponent } from './gerenciador-tarefas.component';

describe('GerenciadorTarefasComponent', () => {
  let component: GerenciadorTarefasComponent;
  let fixture: ComponentFixture<GerenciadorTarefasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GerenciadorTarefasComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GerenciadorTarefasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
