import { Directive } from '@angular/core';

@Directive({
  selector: '[participation]'
})

export class Participation {
  public partie;

  constructor(public id?: number) {}
}
