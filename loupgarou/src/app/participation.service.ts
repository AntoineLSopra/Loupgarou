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



  constructor(private appConfig: AppConfigService, private httpClient: HttpClient) {

   }

   // findAllAsync() {
   //   if (this.participationAsync == null) {
   //   this.participationAsync =  this.httpClient
   //         .get("http://localhost:8080/api/participation/{id}");
   //   }
   //   return this.participationAsync;
   // }
   //
   // refresh() {
   //     this.participationAsync = null;
   // }


   findById(id: number) {

   this.httpClient
       .get("http://localhost:8080/api/participation/" + id )
         .subscribe(resp => this.participations = resp);
  }

}
