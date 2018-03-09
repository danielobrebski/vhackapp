import {User} from '../user/user';

export class Answer {
  constructor(number: number, number2: number, s: string) {
    this.id = number;
    this.userId = number2;
    this.text = s;
  }

  id: number;
  user: User;
  userId: number;
  text: string;
}
