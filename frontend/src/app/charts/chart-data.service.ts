import {Injectable} from '@angular/core';
import {of} from 'rxjs/observable/of';

@Injectable()
export class ChartDataService {

  constructor() {
  }

  get () {
    return of([{label: 'Why don\'t all my friends go to our church?', data: 30},
      {label: 'What is the most important thing in your faith?', data: 50},
      {label: 'Is there a McDonald\'s in heaven?', data: 20}]);
  }

}
