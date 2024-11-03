import { 
  Component,
  OnInit,
  OnChanges,
  DoCheck,
  AfterContentInit,
  AfterContentChecked,
  AfterViewInit,
  AfterViewChecked,
  Input, 
  OnDestroy} from '@angular/core';

@Component({
  selector: 'app-check-sample',
  standalone: true,
  imports: [],
  templateUrl: './check-sample.component.html',
  styleUrl: './check-sample.component.css'
})
export class CheckSampleComponent implements 
OnInit, OnChanges, DoCheck, AfterContentInit, AfterContentChecked
, AfterViewInit, AfterViewChecked, OnDestroy {

  @Input() nome: string = "Uber";

  quantidade: number = 0;

  constructor(){
    console.log("Construtor");
  }
  ngOnDestroy(): void {
    throw new Error('Method not implemented.');
  }

  adicionar(){
    this.quantidade++;
  }

  decrementar(){
    this.quantidade--;
  }
 
  ngOnInit():void {
    this.nome = `Olá, ${this.nome}`;
    console.log("OnInit");
  }

  ngOnChanges(): void {
      console.log("OnChanges");
  }

  //após a visualização
  ngAfterViewChecked(): void {
    console.log("ngAfterViewChecked");
  }

  //2após a inicialização da view
  ngAfterViewInit(): void {
    console.log("ngAfterContentInit");
  }

  ngAfterContentChecked(): void {
    console.log("ngAfterContectChecked");
  }

  //1depois do primeiro conteúdo iniciado
  ngAfterContentInit(): void {
    console.log("ngAfterContentInit");
  }

  ngDoCheck(): void {
    console.log("ngOnInit");
  }

}