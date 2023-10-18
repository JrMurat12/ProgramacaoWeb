import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-cadastro-aluno',
  templateUrl: './cadastro-aluno.component.html',
  styleUrls: ['./cadastro-aluno.component.css']
})
export class CadastroAlunoComponent implements OnInit {
  ra: string;
  nome: string;
  email: string;
  celular: string;
  alunos: any[] = [];
  constructor() { }

  ngOnInit(): void {
  }

  cadastrarAluno() {
    const novoAluno = {
      ra: this.ra,
      nome: this.nome,
      email: this.email,
      celular: this.celular
    };

    this.alunos.push(novoAluno);

    this.ra = '';
    this.nome = '';
    this.email = '';
    this.celular = '';
  }

}
