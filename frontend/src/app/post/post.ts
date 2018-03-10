import {User} from '../user/user';

export class Post {
  postId: number;
  user: User;
  topic: string;
  userId: number;
  text: string;
  mediaId: number;
}
