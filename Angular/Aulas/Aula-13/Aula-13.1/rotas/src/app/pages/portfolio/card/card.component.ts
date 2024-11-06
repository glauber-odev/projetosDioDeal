import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrl: './card.component.css'
})
export class CardComponent {

  //http://localhost:4200/portfolio/{id}
  constructor(
    private activeRoute: ActivatedRoute,
    private redirecionador: Router  
  ){
    this.activeRoute.params.subscribe(
      res => console.log(res)
    )

  //http://localhost:4200/portfolio/id?{name=Gláuber&token=123}
    this.activeRoute.queryParams.subscribe(
      res => console.log(res)
    )

    this.activeRoute.firstChild?.queryParams.subscribe(
      res => console.log(res)
    )
    
  }

  ngOnInit(): void{
    setInterval(()=>{
      this.redirecionador.navigate(['/'])
    }, 5000)
  }

}
