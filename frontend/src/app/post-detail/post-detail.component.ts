import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {PostService} from '../post/post.service';
import {Post} from '../post/post';
import {AnswerService} from '../answer/answer.service';
import {Answer} from '../answer/answer';

@Component({
  selector: 'app-post-detail',
  templateUrl: './post-detail.component.html',
  styleUrls: ['./post-detail.component.css']
})
export class PostDetailComponent implements OnInit {

  constructor(private route: ActivatedRoute, private postService: PostService,
              private answerService: AnswerService) { }

  post: Post;
  answers: Answer[];

  ngOnInit(): void {
    this.getPost();
  }

  getPost(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.postService.getPostById(id)
      .subscribe(post => {
        this.fetchAnswers(post);
        this.post = post;
      });
  }

  private fetchAnswers(post) {
    this.answerService.getAnswersByPostId(post.id).subscribe(answers => this.answers = answers);
  }
}
