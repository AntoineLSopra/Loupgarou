import { Directive } from '@angular/core';

@Directive({
  selector: '[personnages]'
})

export class Personnages {
  public id;

  constructor(public libelle?: string, public prix?: number) {}
}
