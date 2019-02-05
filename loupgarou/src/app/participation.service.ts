import { Injectable } from '@angular/core';
import { Participation } from './plateau/participation';
import { AppConfigService } from './app-config.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ParticipationService {
  public participations: any = new Array<Participation>();
  public participation = new Participation();
  public participationAsync: any = null;
  private httpOptions: any;

  constructor(private appConfig: AppConfigService, private httpClient: HttpClient) {
    // entete http avec id
    let myHeaders: HttpHeaders = new HttpHeaders();
    //On applique les id à l'entete
    myHeaders = myHeaders.append('Authorization', "Basic " + btoa("maxime.gibert@sfr.fr:123456"));
    // options http pour la requete
    this.httpOptions = {
        headers: myHeaders
    };
   }

   refresh() {
       this.participationAsync = null;
   }

   findById(id: number) {

   this.httpClient
       .get("http://localhost:8080/api/participation/" + id , this.httpOptions)
         .subscribe(resp => this.participations = resp);
    }

  delete(participation: Participation, id) {

    this.httpClient
        .delete("http://localhost:8080/api/participation/" + participation.id, this.httpOptions)
        .subscribe(resp => this.findById(id));

    }
}
