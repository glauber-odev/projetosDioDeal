import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'transformador',
  standalone: true
})
export class TransformadorPipe implements PipeTransform {

  transform(value: unknown, name: string, token: string): unknown {
    return value + '' + name + '' + token;
  }

}
