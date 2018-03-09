import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {of} from 'rxjs/observable/of';
import {Post} from './post';
import {UserService} from '../user/user.service';
import {BehaviorSubject} from 'rxjs/BehaviorSubject';

@Injectable()
export class PostService {

  constructor(private http: HttpClient, private  userService: UserService) {
  }

  private postUrl = 'api/post';  // URL to web api

  private listSubject = new BehaviorSubject<Post[]>([]);
  private listObs = this.listSubject.asObservable();
  private singleSubject = new BehaviorSubject<Post>(null);
  private singleObs = this.singleSubject.asObservable();

  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  getPostsByTitle(title: string): Observable<Post[]> {
    // return this.http.get<Post[]>(`${this.postUrl}/${title}`);
    of([new Post(0, 1, 'The Shiba Inu is the smallest of the six original and distinct spitz breeds of dog from Japan.\n' +
      '      A small, agile dog that copes very well with mountainous terrain', 3, 4)])
      .subscribe(posts => {
        this.fetchUser(posts, this.listSubject);
      });
    return this.listObs;
  }

  private fetchUser(posts, subject) {
    const result = [];
    posts.forEach(post => this.userService.getUser(post.userId)
      .subscribe(user => {
        post.user = user;
        result.push(post);
      }, () => console.log('Error: '), () => subject.next(result)));
  }

  getPostById(id: number): Observable<Post> {
    // return this.http.get<Post[]>(`${this.postUrl}/${id}`);
    of(new Post(0, 1, 'The Shiba Inu is the smallest of the six original and distinct spitz breeds of dog from Japan.\n' +
      '      A small, agile dog that copes very well with mountainous terrain', 3, 4))
      .subscribe(post => this.userService.getUser(post.userId)
        .subscribe(user => {
          post.user = user;
          this.singleSubject.next(post);
        }));
    return this.singleObs;
  }

  searchByTitle(title: string): Observable<string[]> {
    if (!title || !title.trim()) {
      // if not search term, return empty hero array.
      return of();
    }
    // return this.http.get<Post[]>(`${this.postUrl}/${title}`);
    return of(['XDDDD']);
  }

}
