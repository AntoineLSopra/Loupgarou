import { Directive } from '@angular/core';

@Directive({
  selector: '[personnage]'
})

export class Personnage {

  constructor(public id?: number, public libelle?: string) {}
}
