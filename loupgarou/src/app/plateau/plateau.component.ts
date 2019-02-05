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
 setValue() { this.vara=false; }

  constructor(private route: ActivatedRoute, private personnageService : PersonnageService, private participationService : ParticipationService) {

      this.route.params.subscribe(params => {
              this.participationService.findById(params.id);
          });
    }
  // ngOnInit() {
  // }

}
