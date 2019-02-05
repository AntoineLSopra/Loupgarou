import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { Personnage } from './personnage';
import { PersonnageService } from '../personnage.service';
import { Participation } from './participation';
import { ParticipationService } from '../participation.service';
import { Partie } from './partie';
import { Message } from './message';
import { ChatService } from '../chat.service';

@Component({
  selector: 'app-plateau',
  templateUrl: './plateau.component.html',
  styleUrls: ['./plateau.component.css'],
  providers: [ PersonnageService , ParticipationService, ChatService]
})
export class PlateauComponent {
  private message: Message = new Message();
  public vara=true;
  public id;
  setValue() { this.vara=false; }

  constructor(private route: ActivatedRoute, private personnageService : PersonnageService, private participationService : ParticipationService, private chatService: ChatService) {
    this.route.params.subscribe(params => {
      this.id = params.id;
            this.participationService.findById(params.id);
            this.chatService.findById(params.id);
        });
  }

  ajouterMessage() {
    this.message.partie = { id :this.id};
    this.message.joueur = { id: 37 };
    this.chatService.save(this.message, this.id);
  }

  // ngOnInit() {
  // }
  supprimerParticipation(participation: Participation) {
    this.participationService.delete(participation, this.id);

    // let index = this.produits.indexOf(produit);
    // this.produits.splice(index, 1);
    }

}
