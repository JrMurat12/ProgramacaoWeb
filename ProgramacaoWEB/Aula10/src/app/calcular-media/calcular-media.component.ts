import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-calcular-media',
  templateUrl: './calcular-media.component.html',
  styleUrls: ['./calcular-media.component.css']
})
export class CalcularMediaComponent implements OnInit {
  ac1: number = 0;
  ac2: number = 0;
  ag: number = 0;
  af: number = 0;
  media: number | null = null;
  situacao: string | null = null;
  constructor() { }

  ngOnInit(): void {
  }

  calcularMedia() {
    if (this.ac1 && this.ac2 && this.ag && this.af) {
      this.media =
        this.ac1 * 0.15 + this.ac2 * 0.30 + this.ag * 0.10 + this.af * 0.45;
      this.situacao = this.media >= 5 ? 'Aprovado' : 'Reprovado';
    } else {
      this.media = null;
      this.situacao = null;
    }
  }
}
