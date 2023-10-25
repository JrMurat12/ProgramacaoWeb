import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-template-driven',
  templateUrl: './template-driven.component.html',
  styleUrls: ['./template-driven.component.css']
})
export class TemplateDrivenComponent implements OnInit {

  nome: string = "";
  email: string = "";
  senha: string = "";

  constructor() { }

  ngOnInit(): void {
  }

  onSubmit(form: any){
    if(form.valid){
      alert("Formulário OK!")
    } else {
      alert("Preencha todos os campos corretamente!");
    }
  }
  
}
