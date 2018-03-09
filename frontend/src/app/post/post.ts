import {User} from '../user/user';

export class Post {
  constructor(number: number, number2: number, s: string, number3: number, number4: number) {
    this.id = number;
    this.userId = number2;
    this.text = s;
    this.rate = number3;
    this.additionalFile = number4;
  }

  id: number;
  user: User;
  userId: number;
  text: string;
  rate: number;
  additionalFile: any;
  answers
}
