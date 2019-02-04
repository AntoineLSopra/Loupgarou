import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule , Routes } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { SprBoldComponent } from './spr-bold/spr-bold.component';
import { SprBoldProduitComponent } from './spr-bold-produit/spr-bold-produit.component';
import { SprTooltipComponent } from './spr-tooltip/spr-tooltip.component';
import { PlateauComponent } from './plateau/plateau.component';

const routes: Routes = [
  { path: 'plateau', component: PlateauComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' }
];

@NgModule({
  declarations: [
    AppComponent,
    SprBoldComponent,
    SprBoldProduitComponent,
    SprTooltipComponent,
    PlateauComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule.forRoot(routes),
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
