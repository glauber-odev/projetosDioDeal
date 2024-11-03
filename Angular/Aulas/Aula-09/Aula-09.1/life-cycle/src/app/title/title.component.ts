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
  selector: 'app-title',
  standalone: true,
  imports: [],
  templateUrl: './title.component.html',
  styleUrl: './title.component.css'
})
export class TitleComponent implements 
OnInit, OnChanges, DoCheck, AfterContentInit, AfterContentChecked
, AfterViewInit, AfterViewChecked, OnDestroy {

  @Input() nome: string = "Uber";

  constructor(){
    console.log("Construtor");
  }
  ngOnDestroy(): void {
    console.log('Goodbye, my friend.');
  }
 
  ngOnInit():void {
    this.nome = `Olá, ${this.nome}`;
    console.log("OnInit");
  }

  ngOnChanges(): void {
      console.log("OnChanges");
  }

  ngAfterViewChecked(): void {
    console.log("ngAfterViewChecked");
  }

  ngAfterViewInit(): void {
    console.log("ngAfterContentInit");
  }

  ngAfterContentChecked(): void {
    console.log("ngAfterContectChecked");
  }

  ngAfterContentInit(): void {
    console.log("ngAfterContentInit");
  }

  ngDoCheck(): void {
    console.log("ngOnInit");
  }

}
