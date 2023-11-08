import { Component, OnInit } from '@angular/core';
import { UsuarioService } from '../services/usuario.service';

@Component({
  selector: 'app-usuario',
  templateUrl: './usuario.component.html',
  styleUrls: ['./usuario.component.css']
})
export class UsuarioComponent implements OnInit {
  usuarios : any [];
  constructor(private usuarioService : UsuarioService) { }

  ngOnInit(): void {
    this.getUsuarios().subscribe((data:any) =>{
      this.usuarios = data;
    })
  }

  getUsuarios(){
    return this.usuarioService.obterUsuarios();
  }

}
