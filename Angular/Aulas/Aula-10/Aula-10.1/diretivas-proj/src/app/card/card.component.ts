import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-card',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './card.component.html',
  styleUrl: './card.component.css'
})
export class CardComponent {

  produtos: string[] = [];
  menuType: string = "admin";

  constructor(){
    this.produtos = [
      "Mouse",
      "Teclado",
      "Cabo",
      "Fonte"
    ]
  }

  adicionar(){
    this.produtos.push("Gláuber");
  }

  remover(index: number): void{
    this.produtos.splice(index,1);
  }

}
