import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';


import {AppComponent} from './app.component';
import {HelloPageComponent} from './hello-page/hello-page.component';
import {AppRoutingModule} from './/app-routing.module';
import {MatToolbarModule, MatButtonModule, MatInputModule, MatAutocompleteModule, MatCardModule} from '@angular/material';
import { SearchComponent } from './search/search.component';
import {PostService} from './post/post.service';
import {HttpClientModule} from '@angular/common/http';
import { PostCardComponent } from './post-card/post-card.component';
import { PostDetailComponent } from './post-detail/post-detail.component';
import {UserService} from './user/user.service';
import {AnswerService} from './answer/answer.service';


@NgModule({
  declarations: [
    AppComponent,
    HelloPageComponent,
    SearchComponent,
    PostCardComponent,
    PostDetailComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatToolbarModule,
    MatButtonModule,
    MatInputModule,
    MatAutocompleteModule,
    HttpClientModule,
    MatCardModule
  ],
  providers: [
    PostService,
    UserService,
    AnswerService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
