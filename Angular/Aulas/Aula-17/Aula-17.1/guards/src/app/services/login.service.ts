import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor() { }

  doLogin(){
    localStorage.setItem('token','algum6754_token');
  }

  doLogout(){
    localStorage.clear();
  }

}
