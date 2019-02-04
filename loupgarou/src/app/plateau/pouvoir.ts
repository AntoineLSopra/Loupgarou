import { Directive } from '@angular/core';

@Directive({
  selector: '[pouvoir]'
})

export class Pouvoir {
  public id;

  constructor(public libelle?: string) {}
}
