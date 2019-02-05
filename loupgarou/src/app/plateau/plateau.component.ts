import { Component, OnInit } from '@angular/core';
import { Personnage } from './personnage';
import { PersonnageService } from '../personnage.service';
import { Message } from './message';
import { ChatService } from '../chat.service';


@Component({
  selector: 'app-plateau',
  templateUrl: './plateau.component.html',
  styleUrls: ['./plateau.component.css'],
  providers: [ ChatService, PersonnageService]
})
export class PlateauComponent implements OnInit {
  private message: Message = new Message();
  constructor(private personnageService : PersonnageService, private chatService : ChatService) { }

  ngOnInit() {
  }

  ajouterMessage() {
    this.message.partie = { id: 15 };
    this.message.joueur = { id: 37 };
    this.chatService.save(this.message);
  }

}
