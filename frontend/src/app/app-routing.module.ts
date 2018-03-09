import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HelloPageComponent} from './hello-page/hello-page.component';
import {SearchComponent} from './search/search.component';
import {PostDetailComponent} from './post-detail/post-detail.component';

const routes: Routes = [
  {path: '', redirectTo: '/hello', pathMatch: 'full'},
  {path: 'hello', component: HelloPageComponent},
  {path: 'search', component: SearchComponent},
  {path: 'post-detail/:id', component: PostDetailComponent}
  ]
;

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
