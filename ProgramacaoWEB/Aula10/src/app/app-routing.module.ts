import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CalculadoraComponent } from './calculadora/calculadora.component';
import { CalcularMediaComponent } from './calcular-media/calcular-media.component';
import { TelaPaiComponent } from './tela-pai/tela-pai.component';
import { TelaFilho1Component } from './tela-pai/tela-filho1/tela-filho1.component';
import { TelaFilho2Component } from './tela-pai/tela-filho2/tela-filho2.component';
import { CadastroAlunoComponent } from './cadastro-aluno/cadastro-aluno.component';
import { ApoliceSeguroComponent } from './apolice-seguro/apolice-seguro.component';
import { TemplateDrivenComponent } from './template-driven/template-driven.component';
import { GerenciadorTarefasComponent } from './gerenciador-tarefas/gerenciador-tarefas.component';
import { UsuarioComponent } from './usuario/usuario.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';

const routes: Routes = [
  { path: 'calculadora', component: CalculadoraComponent },
  { path: 'calcular-media', component: CalcularMediaComponent },
  { path: 'cadastro-aluno', component: CadastroAlunoComponent },
  { path: 'apolice-seguro', component: ApoliceSeguroComponent },
  { 
    path: 'tela-pai', 
    component: TelaPaiComponent, 
    children: [
      {path: 'tela-filho1', component: TelaFilho1Component },
      {path: 'tela-filho2', component: TelaFilho2Component },
  ] },
  { path: 'template-driven', component: TemplateDrivenComponent },
  { path: 'gerenciador-tarefas', component: GerenciadorTarefasComponent },
  { path: 'usuario', component: UsuarioComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes), HttpClientModule,],
  exports: [RouterModule],
})
export class AppRoutingModule { }
