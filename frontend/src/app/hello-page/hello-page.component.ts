import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-hello-page',
  templateUrl: './hello-page.component.html',
  styleUrls: ['./hello-page.component.css']
})
export class HelloPageComponent implements OnInit {

  desc = 'Connecting people app';

  navLinks = [
    {label: 'Events', path: '/events'},
    {label: 'Search', path: '/search'},
    {label: 'Story telling', path: '/story-telling'}
  ];

  constructor() {
  }

  ngOnInit() {
  }

}
