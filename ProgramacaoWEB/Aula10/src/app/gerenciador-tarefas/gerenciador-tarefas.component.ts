import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-gerenciador-tarefas',
  templateUrl: './gerenciador-tarefas.component.html',
  styleUrls: ['./gerenciador-tarefas.component.css']
})
export class GerenciadorTarefasComponent implements OnInit {

  tasks = [];

  newTask: string = '';

  toggleTaskStatus(task) {
    task.concluida = !task.concluida;
  }

  addTask() {
    if (this.newTask.trim() !== '') {
      this.tasks.push({ description: this.newTask, concluida: false });
      this.newTask = ''; // Limpar o campo após adicionar a tarefa
    }
  }

  deleteTask(task) {
    const index = this.tasks.indexOf(task);
    if (index > -1) {
      this.tasks.splice(index, 1);
    }
  }

  constructor() { }

  ngOnInit(): void {
  }

}
