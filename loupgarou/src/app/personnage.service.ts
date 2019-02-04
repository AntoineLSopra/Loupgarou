import { Injectable } from '@angular/core';
import { Personnage } from './plateau/personnage';
import { AppConfigService } from './app-config.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PersonnageService {
  public personnages: Array<Personnage> = new Array<Personnage>();
  public personnage = new Personnage();
  public personnageAsync: any = null;
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

  findAll() {
    this.httpClient
        .get<Personnage[]>("http://localhost:8080/api/personnage")
        //.subscribe(resp => this.produits = resp) //VERSION 1 TRAITEMENT
        .subscribe(resp => { //VERSION 2 TRAITEMENTS
          console.log(resp);
          this.personnages = resp;
        });
    // return this.produits; ON PEUT SEN PASSER
  }

  findAllAsync() {
    if (this.personnageAsync == null) {
    this.personnageAsync =  this.httpClient
          .get("http://localhost:8080/api/personnage");
    }
    return this.personnageAsync;
  }

  refresh() {
      this.personnageAsync = null;
  }

  findByNom(nom: string) {
  }

  // findById(id: number) {
  //   this.personnage = this.httpClient.get("http://localhost:8080/api/personnages/" + id)
  //                 .subscribe(resp => this.personnage = resp);
  //   // return this.produit;
  // }

  // save(personnage: Personnage) {
  //   if (personnage.id > 0) {
  //     this.httpClient
  //         .put("http://localhost:8080/api/personnages/"+ personnage.id, personnage)
  //         .subscribe(resp => this.refresh());
  //   }
  //   else{
  //     this.httpClient
  //         .post("http://localhost:8080/api/personnages", personnage)
  //         .subscribe(resp => this.refresh());
  //   }
  // }
  //
  // delete(personnage: Personnage) {
  //   this.httpClient
  //       .delete("http://localhost:8080/api/personnages/" +personnage.id)
  //       .subscribe(resp => this.refresh());
  // }
}
