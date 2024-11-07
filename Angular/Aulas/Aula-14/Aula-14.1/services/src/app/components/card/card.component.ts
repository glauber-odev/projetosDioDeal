import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { PokemonService } from '../../services/pokemon.service';
import { PokemonData } from '../../models/pokemonData';



@Component({
  selector: 'app-card',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './card.component.html',
  styleUrl: './card.component.css'
})
export class CardComponent {
  pokemon:PokemonData | any = {
  };
  atributesType: string[] = ["FIRE","ROCK"];

  constructor(
    private service: PokemonService
  ){

    this.pokemon = {
      id:0,
      name:'',
      sprites:{
        front_default: ''
      },
      types: []
    }
  }

  ngOnInit(): void{
    this.getPokemon("pikachu");
  }

  getPokemon(pokemonName: string): void{
    this.service.getPokemon(pokemonName).subscribe(
      {

        next: res => {

          this.pokemon = {
            id: res.id,
            name: res.name,
            sprites: res.sprites,
            types: res.types
          }

          console.log(res)
          console.log(res.types)
          console.log(this.pokemon.types)
          console.log(this.pokemon)
        }, 
        error: err => console.log(err)
      }
    );
  }

}
