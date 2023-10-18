import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-apolice-seguro',
  templateUrl: './apolice-seguro.component.html',
  styleUrls: ['./apolice-seguro.component.css']
})
export class ApoliceSeguroComponent implements OnInit {
  nome: string;
  sexo: string = 'masculino';
  idade: number = 0;
  valor: number = 0;
  resultado: number = 0;
  constructor() { }

  ngOnInit(): void {
  }

  calcular(){
    if (this.sexo === 'masculino') {
      if (this.idade <= 25) {
        this.resultado = 0.15 * this.valor;
      } else {
        this.resultado = 0.10 * this.valor;
      }
    } else if (this.sexo === 'feminino') {
      this.resultado = 0.08 * this.valor;
    }
  }

}
