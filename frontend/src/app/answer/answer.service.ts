import {Injectable} from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {of} from 'rxjs/observable/of';
import {BehaviorSubject} from 'rxjs/BehaviorSubject';
import {HttpClient} from '@angular/common/http';
import {UserService} from '../user/user.service';
import {Answer} from './answer';
import {Post} from '../post/post';

@Injectable()
export class AnswerService {

  constructor(private http: HttpClient, private  userService: UserService) {
  }

  private postUrl = '/api/comment/getPostComments';  // URL to web api

  getAnswersByPostId(id: number): Observable<Answer[]> {
    // return this.http.get<Post[]>(`${this.postUrl}/${title}`);
    const subject = new BehaviorSubject<Answer[]>(null);
    const obs = subject.asObservable();
    this.http.get<Answer[]>(`${this.postUrl}?postId=${id}`)
      .subscribe(answers => this.fetchUser(answers, subject));
    return obs;
  }

  private fetchUser(posts, subject) {
    const result = [];
    posts.forEach(post => this.userService.getUser(post.userId)
      .subscribe(user => {
        post.user = user;
        result.push(post);
      }, () => console.log('Error: '), () => subject.next(result)));
  }
}
