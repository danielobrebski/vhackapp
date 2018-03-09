import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';


import {AppComponent} from './app.component';
import {HelloPageComponent} from './hello-page/hello-page.component';
import {AppRoutingModule} from './/app-routing.module';
import {MatToolbarModule} from '@angular/material';


@NgModule({
  declarations: [
    AppComponent,
    HelloPageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatToolbarModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
