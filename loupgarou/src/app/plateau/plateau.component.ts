import { Component, OnInit } from '@angular/core';
import { Personnage } from './personnage';
import { PersonnageService } from '../personnage.service';


@Component({
  selector: 'app-plateau',
  templateUrl: './plateau.component.html',
  styleUrls: ['./plateau.component.css'],
  providers: [ PersonnageService]
})
export class PlateauComponent implements OnInit {

  constructor(private personnageService : PersonnageService) { }

  ngOnInit() {
  }

}
