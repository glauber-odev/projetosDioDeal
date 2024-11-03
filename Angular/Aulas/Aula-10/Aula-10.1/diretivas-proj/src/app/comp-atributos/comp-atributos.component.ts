import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-comp-atributos',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './comp-atributos.component.html',
  styleUrl: './comp-atributos.component.css'
})
export class CompAtributosComponent {
  estilo: string = "enable";
  corFundo: string = "blue";
  corDaFonte: string = "yellow";
  item: string = "";
  lista: string[] = [];
  isEnableBlock: boolean = true;

  trocar(){
    if(this.estilo == "enable"){
      this.estilo = "disable";
    } else {
      this.estilo = "enable"
    }
  }

  adicionarLista(item: string):void{
    this.lista.push(item);
  }

}
