import { Component, OnInit } from '@angular/core';
import {PostService} from '../post/post.service';
import {Post} from '../post/post';
import {Observable} from 'rxjs/Observable';
import {Subject} from 'rxjs/Subject';
import {debounceTime, distinctUntilChanged, switchMap} from 'rxjs/operators';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  constructor(private postService: PostService) { }
  photo = '../../assets/backgroundsearch.jpg';
  posts: Post[];
  term: string;
  terms$: Observable<string[]>;

  private searchTerms = new Subject<string>();

  search(term: string): void {
    this.searchTerms.next(term);
  }

  ngOnInit(): void {
    this.terms$ = this.searchTerms.pipe(
      // wait 300ms after each keystroke before considering the term
      debounceTime(300),

      // ignore new term if same as previous term
      distinctUntilChanged(),

      // switch to new search observable each time the term changes
      switchMap((term: string) => this.postService.searchByTitle(term)),
    );
  }


  getPosts(title: string) {
    this.term = title;
    this.postService.getPostsByTitle(title).subscribe(p => this.posts = p);
  }

}
