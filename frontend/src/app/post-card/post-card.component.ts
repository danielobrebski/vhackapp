import {Component, Input, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {Post} from '../post/post';

@Component({
  selector: 'app-post-card',
  templateUrl: './post-card.component.html',
  styleUrls: ['./post-card.component.css']
})
export class PostCardComponent implements OnInit {
  @Input() post: Post;
  constructor(private router: Router) { }

  ngOnInit() {
  }

  goPostDetails() {
    this.router.navigate(['/post-detail/' + this.post.postId]);
  }

}
