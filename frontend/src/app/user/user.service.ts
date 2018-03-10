import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {of} from 'rxjs/observable/of';
import {User} from './user';
import {Post} from '../post/post';

@Injectable()
export class UserService {

  constructor(private http: HttpClient) {
  }

  private postUrl = 'api/user';  // URL to web api

  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  getUser(id: number): Observable<User> {

    // return this.http.get<Post[]>(`${this.postUrl}/${title}`);
    return this.http.get<User>(`${this.postUrl}?login=Daniel_login`);
  };


}
