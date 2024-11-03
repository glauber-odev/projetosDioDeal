import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ListaModule } from "./lista/lista.module";


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, ListaModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'modulo-proj';
}
