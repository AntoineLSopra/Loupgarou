import { Injectable } from '@angular/core';
import { Message } from './plateau/message';
import { AppConfigService } from './app-config.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ChatService {
  public messages: any = new Array<Message>();
  public message = new Message();
  public messageAsync: any = null;
  constructor(private appConfig: AppConfigService, private httpClient: HttpClient) {
        // //En-tête HTTP avec les identifiants
        // let myHeaders: HttpHeaders = new HttpHeaders();
        //
        // //On applique les identifiants a l'en-tête
        // myHeaders = myHeaders.append('Authorization', "Basic " + btoa("AntoineL:0000"));
        //
        // //OPTIONS HTTP POUR LA REQUETE
        // // let myOptions = {
        // //   headers:myHeaders
        // // };
        // this.httpOptions = {
        //   headers: myHeaders
        // };
    }



  findById(id: number) {

  this.httpClient
      .get("http://localhost:8080/api/chat/" + id )
        .subscribe(resp => this.messages = resp);
   }



  refresh() {
      this.messageAsync = null;
  }

  findByNom(nom: string) {
  }

  // findById(id: number) {
  //   this.personnage = this.httpClient.get("http://localhost:8080/api/personnages/" + id)
  //                 .subscribe(resp => this.personnage = resp);
  //   // return this.produit;
  // }

  save(message: Message, id) {
      this.httpClient
          .post("http://localhost:8080/api/chat", message)
          .subscribe(resp => this.findById(id));
  }

  // findAll() {
  //   this.httpClient
  //       .get<Message[]>("http://localhost:8080/api/chat")
  //       //.subscribe(resp => this.produits = resp) //VERSION 1 TRAITEMENT
  //       .subscribe(resp => { //VERSION 2 TRAITEMENTS
  //         console.log(resp);
  //         this.messages = resp;
  //       });
  //   // return this.produits; ON PEUT SEN PASSER
  // }
  //
  // findAllAsync() {
  //   if (this.messageAsync == null) {
  //   this.messageAsync =  this.httpClient
  //         .get("http://localhost:8080/api/chat");
  //   }
  //   return this.messageAsync;
  // }
}
