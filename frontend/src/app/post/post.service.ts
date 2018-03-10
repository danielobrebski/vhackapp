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

  private postUrl = '/api/post';  // URL to web api

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
    this.http.get<Post[]>(`${this.postUrl}/getPostsBySearch?searchText=${title}`).subscribe(posts => {
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
    this.http.get<Post>(`${this.postUrl}/getPostById?postId=${id}`)
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
     return this.http.get<string[]>(`${this.postUrl}/hint?hint=${title}`);

  }

}
