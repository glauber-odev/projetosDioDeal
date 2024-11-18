import { CanActivateFn } from '@angular/router';

export const authGuard: CanActivateFn = (route, state) => {

  // !!transforma em boelano se achar
  let hasToken = !!localStorage.getItem('token');

  return hasToken;
};
