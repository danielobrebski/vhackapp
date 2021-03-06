import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';


import {AppComponent} from './app.component';
import {HelloPageComponent} from './hello-page/hello-page.component';
import {AppRoutingModule} from './/app-routing.module';
import {
  MatAutocompleteModule,
  MatButtonModule,
  MatCardModule,
  MatInputModule,
  MatToolbarModule
} from '@angular/material';
import {MatIconModule} from '@angular/material/icon';
import {SearchComponent} from './search/search.component';
import {PostService} from './post/post.service';
import {HttpClientModule} from '@angular/common/http';
import {PostCardComponent} from './post-card/post-card.component';
import {PostDetailComponent} from './post-detail/post-detail.component';
import {UserService} from './user/user.service';
import {AnswerService} from './answer/answer.service';
import { ChartsComponent } from './charts/charts.component';
import {ChartDataService} from './charts/chart-data.service';


@NgModule({
  declarations: [
    AppComponent,
    HelloPageComponent,
    SearchComponent,
    PostCardComponent,
    PostDetailComponent,
    ChartsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatToolbarModule,
    MatButtonModule,
    MatInputModule,
    MatAutocompleteModule,
    HttpClientModule,
    MatCardModule,
    MatIconModule
  ],
  providers: [
    PostService,
    UserService,
    AnswerService,
    ChartDataService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
