import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';


import {AppComponent} from './app.component';
import {HelloPageComponent} from './hello-page/hello-page.component';
import {AppRoutingModule} from './/app-routing.module';
import {MatToolbarModule, MatButtonModule, MatInputModule} from '@angular/material';
import { SearchComponent } from './search/search.component';


@NgModule({
  declarations: [
    AppComponent,
    HelloPageComponent,
    SearchComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatToolbarModule,
    MatButtonModule,
    MatInputModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
