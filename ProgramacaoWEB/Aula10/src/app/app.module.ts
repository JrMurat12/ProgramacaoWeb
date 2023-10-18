import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { MenuSuperiorComponent } from './menu-superior/menu-superior.component';
import { CalculadoraComponent } from './calculadora/calculadora.component';
import { FormsModule } from '@angular/forms';
import { CalcularMediaComponent } from './calcular-media/calcular-media.component';
import { TelaPaiComponent } from './tela-pai/tela-pai.component';
import { TelaFilho1Component } from './tela-pai/tela-filho1/tela-filho1.component';
import { TelaFilho2Component } from './tela-pai/tela-filho2/tela-filho2.component';
import { CadastroAlunoComponent } from './cadastro-aluno/cadastro-aluno.component';
import { ApoliceSeguroComponent } from './apolice-seguro/apolice-seguro.component';

@NgModule({
  declarations: [AppComponent, MenuSuperiorComponent, CalculadoraComponent, CalcularMediaComponent, TelaPaiComponent, TelaFilho1Component, TelaFilho2Component, CadastroAlunoComponent, ApoliceSeguroComponent],
  imports: [BrowserModule, AppRoutingModule, NgbModule, FormsModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
