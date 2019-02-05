import { Directive } from '@angular/core';

@Directive({
  selector: '[message]'
})

export class Message {
  public Partie;
  public Joueur;
  constructor(public id?: number, public contenu?: string) {}
}
