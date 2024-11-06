import { Component, Input } from '@angular/core';
import { MenuTitleComponent } from "../menu-title/menu-title.component";
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-big-card',
  standalone: true,
  imports: [MenuTitleComponent, RouterLink],
  templateUrl: './big-card.component.html',
  styleUrl: './big-card.component.css'
})
export class BigCardComponent {

  @Input()
  id:string = "";
  @Input()
  photoCover: string = "";
  @Input()
  cardTitle: string = "";
  @Input()
  cardDescrition: string = "";

}
