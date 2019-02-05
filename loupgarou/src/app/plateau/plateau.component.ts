import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { Personnage } from './personnage';
import { PersonnageService } from '../personnage.service';
import { Participation } from './participation';
import { ParticipationService } from '../participation.service';
import { Partie } from './partie';

@Component({
  selector: 'app-plateau',
  templateUrl: './plateau.component.html',
  styleUrls: ['./plateau.component.css'],
  providers: [ PersonnageService , ParticipationService]
})

export class PlateauComponent {
public vara=true;
public id;
 setValue() { this.vara=false; }

  constructor(private route: ActivatedRoute, private personnageService : PersonnageService, private participationService : ParticipationService) {

      this.route.params.subscribe(params => {
        this.id = params.id;
              this.participationService.findById(params.id);
          });
    }
  // ngOnInit() {
  // }
  supprimerParticipation(participation: Participation) {
    this.participationService.delete(participation, this.id);

    // let index = this.produits.indexOf(produit);
    // this.produits.splice(index, 1);
    }

}
