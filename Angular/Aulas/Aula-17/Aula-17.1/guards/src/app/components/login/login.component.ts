import { Component } from '@angular/core';
import { LoginService } from '../../services/login.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  constructor(
    private service: LoginService
  ){

  }

  logar(){
    this.service.doLogin();    
  }

  logout(){
    this.service.doLogout();
  }

}
