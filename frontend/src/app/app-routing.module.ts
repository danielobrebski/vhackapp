import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HelloPageComponent} from './hello-page/hello-page.component';
import {SearchComponent} from './search/search.component';

const routes: Routes = [
  {path: '', redirectTo: '/hello', pathMatch: 'full'},
  {path: 'hello', component: HelloPageComponent},
  {path: 'search', component: SearchComponent}
  ]
;

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
