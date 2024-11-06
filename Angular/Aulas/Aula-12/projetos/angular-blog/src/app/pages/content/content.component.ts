import { Component, Input } from '@angular/core';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { dataFake } from '../../data/dataFake';

@Component({
  selector: 'app-content',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './content.component.html',
  styleUrl: './content.component.css'
})
export class ContentComponent {

  constructor( private route:ActivatedRoute ){    

  }

  @Input()
  id:string | null = "0";
  @Input()
  photoCover:string = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSvtlGg2MGI_InqbKa8ckaRW5PLsbT_Tvh7ThW229_2ZWpFBacC8INGSQJakotBP4u_Fsk&usqp=CAU";
  @Input()
  contentTitle:string = "NOTÍCIA EXEMPLO";
  @Input()
  contentDescription:string = "Bla bla bla blabla";

  ngOnInit(): void{
    this.route.paramMap.subscribe( value => {
      this.id = value.get("id");
    })
    this.setValuesToComponent(this.id);
  }

  setValuesToComponent(id: string | null){
    const result = dataFake.filter(article => article.id == id)[0]

    this.contentTitle = result.title;
    this.contentDescription = result.description;
    this.photoCover = result.photo;    
  }

  
}
