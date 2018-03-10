import {Injectable} from '@angular/core';
import {of} from 'rxjs/observable/of';

@Injectable()
export class ChartDataService {

  constructor() {
  }

  get () {
    return of([{label: 'Question 1', data: 30},
      {label: 'Question 2', data: 50},
      {label: 'Question 3', data: 20}]);
  }

}
